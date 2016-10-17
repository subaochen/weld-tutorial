package cn.edu.sdut.r314;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author subaochen
 */
@InterceptorBinding
@Target({TYPE,METHOD})
@Retention(RUNTIME)
public @interface Logged {
    
}
