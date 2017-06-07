package Sessions;

import java.io.Serializable;

/**
 * Created by Sylvain on 21/05/2017.
 */
public class Credentials implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Getters and setters omitted
}

