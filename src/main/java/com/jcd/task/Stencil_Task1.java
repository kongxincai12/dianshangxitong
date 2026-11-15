package com.jcd.task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class Stencil_Task1 {
    //@Scheduled(cron ="*/6 * * * * ?")
    public void sayWord() {
        System.out.println("world");
    }
}
