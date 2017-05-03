package com.example.ScheduledTasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * spring boot的定时任务
 */
@Component
public class ScheduledTasks {

//    fixedRate = 5000表示每隔5000ms，Spring scheduling会调用一次该方法，不论该方法的执行时间是多少
//    fixedDelay = 5000表示当方法执行完毕5000ms后，Spring scheduling会再次调用该方法
//    cron = "*/5 * * * * * *"提供了一种通用的定时任务表达式，这里表示每隔5秒执行一次，更加详细的信息可以参考cron表达式。

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    //50秒执行一次
   /* @Scheduled(fixedRate = 50000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }*/

     //每天凌晨执行
    @Scheduled(cron="0 0 0 * * ?")
    public void executeFileDownLoadTask() {

        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务1:"+current.getId());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }
    //每天下午6点执行
    @Scheduled(cron="0 30 17 * * ?")
    public void executeUploadTask() {

        // 间隔1分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务2:"+current.getId());
        logger.info("ScheduledTest.executeUploadTask 定时任务2:"+current.getId() + ",name:"+current.getName());
    }
}