package Sessions;

import Ressources.EtudiantService;
import beans.EtudiantEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
/**
 * Created by Sylvain on 21/05/2017.
 */

@Path("/authentification")
public class Authentification {
    private EtudiantService etudiantService = new EtudiantService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials) {

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Authenticate the user, issue a token and return a response
        try {
            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = tokenJwt(username);
            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        EtudiantEntity etu = etudiantService.findEtudiantByLogin(username);
        if (etu == null){
            throw new Exception("Aucun étudiants avec ce login");
        }else{
            if(!etu.getPassword().equals(password)){
                throw new Exception("Password incorrecte");
            }
        }
    }

    private String tokenJwt(String username) {
        String token = new String();
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create()
                    .withIssuer(username)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException exception) {
            //UTF-8 encoding not supported
        } catch (JWTCreationException exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }
}

