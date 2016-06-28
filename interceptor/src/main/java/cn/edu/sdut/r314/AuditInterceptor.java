package cn.edu.sdut.r314;

import java.io.Serializable;
import java.util.Date;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author subaochen
 */
@Audit @Interceptor
public class AuditInterceptor implements Serializable {
    
    public AuditInterceptor(){}
    
    @AroundInvoke
    public Object doAudit(InvocationContext ctx) throws Exception{
        System.out.println("doing audit @" + new Date() + "......");
        return ctx.proceed();
    }
    
}
