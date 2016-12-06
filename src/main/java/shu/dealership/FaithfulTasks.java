package shu.dealership;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew Shubin on 12/5/16.
 */

@Component
public class FaithfulTasks {

    @Scheduled(cron = "0/6 * * * * *")
    protected void eat() {
        say("I am eating now.");
    }

    @Scheduled(cron = "1/6 * * * * *")
    public void eatWithFriends() {
        say("I am now eating with friends.");
    }

    @Scheduled(cron = "2/6 * * * * *")
    protected void study() {
        say("Now I'm studying.");
    }

    @Scheduled(cron = "3/6 * * * * *")
    public void meetWithFriends() {
        say("I'm going to go meet with friends.");
    }

    @Scheduled(cron = "4/6 * * * * *")
    protected void playVideoGames() {
        say("Just playing some video games now.");
    }

    @Scheduled(cron = "5/6 * * * * *")
    protected void doMoreStudying() {
        say("Aaaaand back to studying.");
    }

    private void say(String message) {
        System.out.println("--- " + message);
    }
}
