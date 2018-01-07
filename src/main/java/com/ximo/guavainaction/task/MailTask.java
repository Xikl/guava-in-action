package com.ximo.guavainaction.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.concurrent.Future;

/**
 * @author 朱文赵
 * @date 2018/1/7 16:10
 * @description 异步任务
 */
@Component
@EnableAsync
@Slf4j
public class MailTask {

    @Async
    public void taskAsyncMethodWithVoidReturnType() {
        log.info("没有返回值的异步任务，当前时间为：{}", LocalTime.now());
    }

    @Async
    public Future<String> taskAsyncMethodWithReturnType() throws InterruptedException {
        log.info("有返回值得异步任务，当前时间为：{}", LocalTime.now());
        Thread.sleep(5000);
        return new AsyncResult<>("你好周日，今天学到了很多");
    }



}
