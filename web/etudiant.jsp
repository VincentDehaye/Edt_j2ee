<%@ page import="beans.EtudiantEntity" %><%--
  Created by IntelliJ IDEA.
  User: Sylvain
  Date: 13/04/2017
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@ page import="beans.ProfesseurEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>etudiant</title>
</head>
<body>
    <p>Ceci est une page générée depuis une JSP.</p>

    <table border="1">
        <tr>
            <th>Id</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Mail</th>
        </tr>
        <%
            Object obj = request.getAttribute("listeEtu");
            if(obj!=null){
                List<EtudiantEntity> lu = (List<EtudiantEntity>)obj;
                for(EtudiantEntity u : lu){
        %>
        <tr>
            <td><%=u.getIdEtudiant()%></td>
            <td><%=u.getNom()%></td>
            <td><%=u.getPrenom()%></td>
            <td><%=u.getMail()%></td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <%
        obj = request.getAttribute("etu");
        if(obj != null){
            EtudiantEntity etu = (EtudiantEntity) obj;
    %> <p>Résultat de la recherche par adresse mail :
        <% out.println(etu.getIdEtudiant() + " " + etu.getNom() + " " +  etu.getPrenom() + " " + etu.getMail());%>
    </p> <%
        }
    %>

    <%
        obj = request.getAttribute("deleted");
        if(obj != null){

    %> <p>Etudiant supprimé</p>
    <%
        }
    %>

    <%
        obj = request.getAttribute("created");
        if(obj != null){

    %> <p>Etudiant créé</p>
    <%
        }
    %>

</body>
</html>
