package com.sdzee.bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class TestJDBC {
    /* La liste qui contiendra tous les résultats de nos essais */
    private List<String> messages = new ArrayList<String>();

    public List<String> executerTests( HttpServletRequest request ) {
    /* Chargement du driver JDBC pour MySQL */
        try {
            messages.add( "Chargement du driver..." );
            Class.forName( "com.mysql.jdbc.Driver" );
            messages.add( "Driver chargé !" );
        } catch ( ClassNotFoundException e ) {
            messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                    + e.getMessage() );
        }

    /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/sr03_project";
        String utilisateur = "root";
        String motDePasse = "templenoir";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            messages.add( "Connexion à la base de données..." );
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
            messages.add( "Connexion réussie !" );

        /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();
            messages.add( "Objet requête créé !" );

        /* Récupération des paramètres d'URL saisis par l'utilisateur */
            String paramNom = request.getParameter( "nom" );
            String paramPrenom = request.getParameter( "prenom" );
            String paramMail = request.getParameter( "mail" );
            String paramSemestre = request.getParameter( "semestre" );
            String paramCursus = request.getParameter( "cursus" );
            String paramNiveau = request.getParameter( "niveau" );

        /* Exécution d'une requête d'écriture */
            int statut = statement.executeUpdate( "INSERT INTO Etudiant (Nom, Prenom, Mail, Semestre, Cursus, Niveau)" +
                    " VALUES ('" + paramNom + "'," +
                            "' " + paramPrenom + "'," +
                            "' " + paramMail + "'," +
                            "' " + paramSemestre + "'," +
                            "' " + paramCursus + "'," +
                            "' " + paramNiveau + "');"
                    , Statement.RETURN_GENERATED_KEYS);

        /* Formatage pour affichage dans la JSP finale. */
            messages.add( "Résultat de la requête d'insertion : " + statut + "." );

        /* Récupération de l'id auto-généré par la requête d'insertion. */
            resultat = statement.getGeneratedKeys();

        /* Parcours du ResultSet et formatage pour affichage de la valeur qu'il contient dans la JSP finale. */
            while ( resultat.next() ) {
                messages.add( "ID retourné lors de la requête d'insertion :" + resultat.getInt( 1 ) );
            }
            
        /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery( "SELECT * FROM Etudiant;" );
            messages.add( "Requête \"SELECT * FROM Etudiant;\" effectuée !" );

        /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                int idEtudiant = resultat.getInt( "Id" );
                String mailEtudiant = resultat.getString( "Mail" );
                String nomEtudiant = resultat.getString( "Nom" );
            /* Formatage des données pour affichage dans la JSP finale. */
                messages.add( "Données retournées par la requête : id = " + idEtudiant + ", email = " + mailEtudiant
                        + ", nom = " + nomEtudiant + "." );
            }
        } catch ( SQLException e ) {
            messages.add( "Erreur lors de la connexion : <br/>"
                    + e.getMessage() );
        } finally {
            messages.add( "Fermeture de l'objet ResultSet." );
            if ( resultat != null ) {
                try {
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Statement." );
            if ( statement != null ) {
                try {
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Connection." );
            if ( connexion != null ) {
                try {
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
        }

        return messages;
    }
}