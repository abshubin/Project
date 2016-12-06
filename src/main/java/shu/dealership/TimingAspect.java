package shu.dealership;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew Shubin on 12/5/16.
 */

@Component
@Aspect
public class TimingAspect {

    @Pointcut("execution(public * shu.dealership..*(..))")
    public void publicMethods() {}

    @Around("publicMethods() && @annotation(Timed)")
    public Object profile(final ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        try {
            final Object value = joinPoint.proceed();
            return value;
        } catch (Throwable t) {
            throw t;
        } finally {
            final long stop = System.currentTimeMillis();
            System.out.println("+++ Execution time of " + joinPoint.getSignature().getName() +
                                " was : " + (stop - start) + "ms");
        }
    }
}
