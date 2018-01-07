package com.ximo.guavainaction.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author 朱文赵
 * @date 2018/1/7 16:23
 * @description 自定义实现AsyncTaskExecutor的任务执行器
 */
@Slf4j
public class ExceptionHandlingAsyncTaskExecutor implements AsyncTaskExecutor{

    private AsyncTaskExecutor executor;

    public ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void execute(Runnable runnable, long l) {
        executor.execute(createWrappedRunnable(runnable), l);
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        return executor.submit(createWrappedRunnable(runnable));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        return executor.submit(createCallable(callable));
    }

    @Override
    public void execute(Runnable runnable) {
        executor.execute(createWrappedRunnable(runnable));
    }

    private Runnable createWrappedRunnable(final Runnable task) {
        return () -> {
            try {
                task.run();
            } catch (Exception e) {
                handleException(e);
                throw e;
            }
        };
    }

    private Callable createCallable(final Callable task) {
        return (Callable) () -> {
            try {
                return task.call();
            } catch (Exception e) {
                handleException(e);
                throw e;
            }
        };
    }

    private void handleException(Exception e) {
        log.error("【异步任务】spring中异步任务 线程调用出现了错误");
    }
}
