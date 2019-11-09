package com.example.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiacheng Yang
 * @create 2019/11/8
 **/
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //每3秒执行一次
    @Scheduled(fixedRate = 1000 * 3)
    @Async("taskExecutor")
    public void reportCurrentTime(){
        System.out.println("线程"+Thread.currentThread().getName()+"开始执行定时任务"+  dateFormat .format (new Date()));
        long start = System.currentTimeMillis();
    }
    //在固定时间执行
    @Scheduled(cron = "0 */5 * * * *")
    public void reportCurrentByCron(){
        System.out.println("Scheduling Tasks Examples By Cron : The time is now " + dateFormat .format (new Date()) );
    }
}
