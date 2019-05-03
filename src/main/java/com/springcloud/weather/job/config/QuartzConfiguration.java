package com.springcloud.weather.job.config;

import com.springcloud.weather.job.WeatherDataSyncJob;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务的配置
 *      不知为何不运行，应该是版本或者需要spring-context-support支持
 */
@Configuration
public class QuartzConfiguration {

    private final static int TIME = 2;   // 更新频率

    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }

    //trigger 触发器
    @Bean
    public Trigger weatherDataSyncTrigger() {

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(TIME)
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(schedBuilder).build();
    }

}
