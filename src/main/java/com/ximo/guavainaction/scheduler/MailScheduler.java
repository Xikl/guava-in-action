package com.ximo.guavainaction.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author 朱文赵
 * @date 2018/1/7 15:06
 * @description
 */
@Component
@EnableScheduling
@Slf4j
public class MailScheduler {

//    @Scheduled(cron = "0 10 * * * *")
//    public void cron() {
//        log.info("执行cron测试时间, {}", LocalTime.now());
//    }

    @Scheduled(fixedRate = 1000)
    public void fixedRate() throws InterruptedException {
//        Thread.sleep(2000);
        log.info("执行fixedRate的时间为：{}", LocalTime.now());
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000 * 2)
    public void fixedDelay() throws InterruptedException {
//        Thread.sleep(3000);
        log.info("执行fixedDelay的时间为：{}", LocalTime.now());
    }



}
