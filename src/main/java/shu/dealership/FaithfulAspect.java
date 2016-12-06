package shu.dealership;

import org.apache.commons.io.FileUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
public class FaithfulAspect {

    private final String PATH = FileUtils.getUserDirectoryPath()
            + "/IdeaProjects/Project2"
            + "/src/main/java/shu/dealership/";

    @Pointcut("execution(void shu.dealership.FaithfulTasks.*(..))")
    public void faithfulTasks() {}

    @Before("faithfulTasks()")
    public void pray (final JoinPoint joinPoint) {
        String prayer = null;
        try {
            prayer = FileUtils.readFileToString(new File(PATH +
                        "prayers.txt"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("^^^ PRAYING... \"" + prayer + "\"");
        }
    }

    @After("faithfulTasks()")
    public void praiseAndGiveGloryToGod(final JoinPoint joinPoint) {
        try {
            FileUtils.writeStringToFile(new File(PATH + "praises.txt"),
                    "PRAISES!!!" + System.lineSeparator(), "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("^^^ PRAISING!!!");
        }
    }
}
