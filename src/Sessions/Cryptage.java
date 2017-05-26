package Sessions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Sylvain on 26/05/2017.
 */
public class Cryptage {
        public static String crypterMdp(String passwordToHash)
        {
            byte[] salt = {69, 121, 101, 45, 62, 118, 101, 114, 96, 95, 61, 101, 98, 01, 104, 18}; ;
            String generatedPassword = null;
            try {
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                //Add password bytes to digest
                md.update(salt);
                //Get the hash's bytes
                byte[] bytes = md.digest(passwordToHash.getBytes());
                //This bytes[] has bytes in decimal format;
                //Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for(int i=0; i< bytes.length ;i++)
                {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                //Get complete hashed password in hex format
                generatedPassword = sb.toString();
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return generatedPassword;
        }
}
