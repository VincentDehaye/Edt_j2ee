package Sessions;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.ext.Provider;
import java.io.UnsupportedEncodingException;

/**
 * Created by Sylvain on 22/05/2017.
 */


@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthentificationFilter{

    static public void filter(String authorizationHeader) throws Exception {
        // Check if the HTTP Authorization header is present and formatted correctly
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }
        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();
        try {
            // Validate the token
            validateToken(token);
        } catch (Exception e) {
            throw new Exception("token non valide");
        }
    }

    static private void validateToken(String token) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .acceptExpiresAt(5)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
            throw new Exception("UTF-8 encoding not supported");
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            throw new Exception("Invalid signature/claims");
        }
    }

}