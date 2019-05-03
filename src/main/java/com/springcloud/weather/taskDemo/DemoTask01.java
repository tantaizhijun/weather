package com.springcloud.weather.taskDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务
 *  基于注解实现
 *  Cron表达式参数分别表示：
 *
 *     秒（0~59） 例如0/5表示每5秒
 *     分（0~59）
 *     时（0~23）
 *     日（0~31）的某天，需计算
 *     月（0~11）
 *     周几（ 可填1-7 或 SUN/MON/TUE/WED/THU/FRI/SAT）
 *
 * @Scheduled：除了支持灵活的参数表达式cron之外，还支持简单的延时操作，
 *   fixedRate：定义一个按一定频率执行的定时任务
 *   fixedDelay：定义一个按一定频率执行的定时任务，与上面不同的是，改属性可以配合initialDelay， 定义该任务延迟执行时间。
 *   cron：通过表达式来配置任务执行时间
 */

/*
@Component
@EnableScheduling
@Configuration
*/
public class DemoTask01 {


    //@Scheduled(fixedRate = 5000)    //直接指定时间间隔
    @Scheduled(cron = "0/2 * * * * ?")
    private void taskDemo() {
        System.out.println("定时任务测试。。。。。1");
    }


}
