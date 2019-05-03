package com.springcloud.weather.taskDemo;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务
 *     基于接口实现 SchedulingConfigurer
 */

/*
@Component
@Configuration          //用于标记配置类，兼备Component的效果。
@EnableScheduling       //开启定时任务
*/
public class DemoTask02 implements SchedulingConfigurer {


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> System.out.println("定时任务"),
                triggerContext -> {
                    return new CronTrigger("0/5 * * * * ?").nextExecutionTime(triggerContext);
                }
        );
    }
}
