package cn.edu.sdut.r314;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author subaochen
 */
@Logged @Interceptor
public class LoggedInterceptor implements Serializable {

    public LoggedInterceptor(){}
    
    @AroundInvoke
    public Object  logMethod(InvocationContext ctx) throws Exception {
        System.out.println("Entering method:" + ctx.getMethod().getName()
        + " in class: " + ctx.getMethod().getDeclaringClass().getName());
        
        return ctx.proceed();
    }
}
