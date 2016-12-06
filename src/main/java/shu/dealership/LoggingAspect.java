package shu.dealership;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew Shubin on 12/5/16.
 */

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(public * shu.dealership..*(..))")
    public void publicMethod() {}

    @Before("publicMethod() && @annotation(Log)")
    public void addLog(final JoinPoint joinPoint) {
        System.out.println("*** Executing: " + joinPoint.getSignature());
        Object[] arguments = joinPoint.getArgs();
        for (Object argument : arguments) {
            System.out.println("*** " + argument.getClass().getSimpleName() + " = " + argument);
        }
    }
}
