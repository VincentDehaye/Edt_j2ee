package Sessions;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Sylvain on 22/05/2017.
 */
@NameBinding //Permet de creer une annotation qui sera definit plus tard
//@Retention(RUNTIME)
@Retention(RetentionPolicy.RUNTIME) //Permet a l'annotation d'exister durant l'execution de l'appli
@Target({TYPE, METHOD}) //permet de préciser les entités sur lesquelles l'annotation sera utilisable
public @interface Secured {  }
