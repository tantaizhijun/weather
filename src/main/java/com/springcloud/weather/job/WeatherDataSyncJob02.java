package com.springcloud.weather.job;

import com.springcloud.weather.service.CityDataService;
import com.springcloud.weather.service.WeatherService;
import com.springcloud.weather.weatherPojo.city.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration          //用于标记配置类，兼备Component的效果。
@EnableScheduling       //开启定时任务
public class WeatherDataSyncJob02 implements SchedulingConfigurer {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherService weatherService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> {
                    System.out.println("定时任务");

                    List<City> cities = null;
                    try {
                        //获取城市列表
                        cities = cityDataService.listCity();

                    } catch (Exception e) {
                        e.getStackTrace();
                    }

                    for (City city: cities) {
                        String cityId = city.getCityId();
                        System.out.println("city id :" + cityId);
                        weatherService.syncDateByCityId(cityId);
                    }
                },
                triggerContext -> {
                    return new CronTrigger("0/59 * * * * ?").nextExecutionTime(triggerContext);
                }
        );
    }
}
