package Services; /**
 * Created by Sylvain on 05/05/2017.
 */
import Sessions.Authentification;
import Sessions.MyEndpoint;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/")
//The java class declares root resource and provider classes
public class MyApplication extends Application {
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add( EtudiantRessource.class );
        h.add( ScheduleRessource.class );
        h.add( ProfesseurRessource.class );
        h.add( UvRessource.class );
        h.add(Authentification.class);
        h.add(MyEndpoint.class);
        return h;
    }
}