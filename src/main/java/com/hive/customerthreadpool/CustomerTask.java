package com.hive.customerthreadpool;

import java.util.concurrent.*;

/**
 * @author JACK LEE
 * @description ${DESCRIPTION}
 * @create 2019-03-21 0:22
 */
public class CustomerTask implements Runnable {

    public CustomerTask(int customerTaskId, String customerTaskName) {
        this.customerTaskId = customerTaskId;
        this.customerTaskName = customerTaskName;
    }

    /*
     * 任务Id
     * */
    private int customerTaskId;
    /*
     * 任务名称
     * */
    private String customerTaskName;

    public int getCustomerTaskId() {
        return customerTaskId;
    }

    public void setCustomerTaskId(int customerTaskId) {
        this.customerTaskId = customerTaskId;
    }

    public String getCustomerTaskName() {
        return customerTaskName;
    }

    public void setCustomerTaskName(String customerTaskName) {
        this.customerTaskName = customerTaskName;
    }


    @Override
    public void run() {
        System.out.println("CustomerTask{" +
                "customerTaskId=" + customerTaskId +
                ", customerTaskName='" + customerTaskName + '\'' +
                '}');
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //获取开始时间
        System.out.println();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(// 自定义一个线程池

                1, // coreSize

                2, // maxSize

                60, // 60s

                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3) // 有界队列，容量是3个

                , Executors.defaultThreadFactory()

                , new CustomRejectedExecutionHandler()

        );
        pool.execute(new CustomerTask(1, "任务1"));

        System.out.println("活跃的线程数：" + pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new CustomerTask(2, "任务2"));

        System.out.println("活跃的线程数：" + pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new CustomerTask(3, "任务3"));

        System.out.println("活跃的线程数：" + pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new CustomerTask(4, "任务4"));

        System.out.println("活跃的线程数：" + pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new CustomerTask(5, "任务5"));

        System.out.println("活跃的线程数：" + pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.execute(new CustomerTask(6, "任务6"));

        System.out.println("活跃的线程数：" + pool.getActiveCount() + ",核心线程数：" + pool.getCorePoolSize() + ",线程池大小：" + pool.getPoolSize() + ",队列的大小" + pool.getQueue().size());

        pool.shutdown();
        long endTime=System.currentTimeMillis(); //获取结束时间



        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
