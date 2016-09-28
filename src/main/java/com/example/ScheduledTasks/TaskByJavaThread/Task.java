package com.example.ScheduledTasks.TaskByJavaThread;

import java.util.TimerTask;

public class Task extends TimerTask {
    public void run() {
        System.out.println("我有一头小毛驴!我从来也不骑！");
    }
}