package com.springcloud.weather.weather.job;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.logging.Logger;

public class WeatherDataSyncJob extends QuartzJobBean {




    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class)

    //job 执行的方法
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job. Start！");




    }



}
