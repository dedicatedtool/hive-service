package com.hive.customerthreadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author JACK LEE
 * @description ${DESCRIPTION}
 * @create 2019-03-21 0:29
 */
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            CustomerTask customerTask = (CustomerTask) r;
            System.out.println("等待。。。。。。。。。"+customerTask.getCustomerTaskName());
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("被阻塞。。。。。。。。。");
    }
}
