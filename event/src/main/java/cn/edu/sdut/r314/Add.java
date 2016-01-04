package cn.edu.sdut.r314;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * 增加房间
 * @author subaochen
 *
 */
@Qualifier
@Target({FIELD,PARAMETER})
@Retention(RUNTIME)
public @interface Add {
}
