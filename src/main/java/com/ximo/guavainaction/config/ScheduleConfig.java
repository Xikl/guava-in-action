package com.ximo.guavainaction.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author 朱文赵
 * @date 2018/2/25 15:52
 * @description 将scheduler 配置成为并行
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer{


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public ScheduledThreadPoolExecutor taskExecutor() {
        return new ScheduledThreadPoolExecutor(3,
                new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build());
    }

}
