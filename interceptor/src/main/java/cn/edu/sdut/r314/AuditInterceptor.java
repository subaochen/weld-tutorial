package cn.edu.sdut.r314;

import java.util.Date;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author subaochen
 */
@Audit @Interceptor
public class AuditInterceptor {
    
    @AroundInvoke
    public Object doAudit(InvocationContext ctx){
        System.out.println("doing audit @" + new Date() + "......");
        return null;
    }
    
}
