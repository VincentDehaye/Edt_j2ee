package Sessions;

import java.io.Serializable;

/**
 * Created by Sylvain on 07/06/2017.
 */

public class Token implements Serializable {

    private String Bearer;

    public String getBearer() {
        return Bearer;
    }

    public void setBearer(String token) {this.Bearer = token;}

    // Getters and setters omitted
}

