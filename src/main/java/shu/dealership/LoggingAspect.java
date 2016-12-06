package shu.dealership;

import org.apache.commons.io.FileUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by Andrew Shubin on 12/5/16.
 */

@Component
@Aspect
public class LoggingAspect {

    private final String PATH = FileUtils.getUserDirectoryPath()
            + "/IdeaProjects/Project2"
            + "/src/main/java/shu/dealership/logs.txt";

    @Pointcut("execution(public * shu.dealership..*(..))")
    public void publicMethod() {}

    @Before("publicMethod() && @annotation(Log)")
    public void addLog(final JoinPoint joinPoint) {
        System.out.println("*** Executing: " + joinPoint.getSignature());
        Object[] arguments = joinPoint.getArgs();
        for (Object argument : arguments) {
            String log = "*** " + argument.getClass().getSimpleName() + " = " + argument;
            System.out.println(log);
            try {
                FileUtils.writeStringToFile(new File(PATH), log +
                        System.lineSeparator(), "UTF-8", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
