package top.ornobug.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TransactionAop {

    static {
        System.out.println(1);
    }

    @Pointcut(value = "@annotation(top.ornobug.annotation.Transaction)")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("切点开始");
        System.out.println(joinPoint.getSignature());

    }


    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
        System.out.println("切点结束");

    }
}
