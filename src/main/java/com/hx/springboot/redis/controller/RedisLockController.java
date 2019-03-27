package com.hx.springboot.redis.controller;

import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2019/3/27 16:39
 */
@RestController
public class RedisLockController {
    @Resource
    private RedisLockRegistry redisLockRegistry;

    @GetMapping("test")
    public void test() throws InterruptedException {
        Lock lock = redisLockRegistry.obtain("lock");
        boolean flag = lock.tryLock();
        if(flag) {
            try {
                System.out.println("do something...");
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                lock.unlock();
                System.out.println("unlock...");
            }
        } else {
            System.out.println("未获取到锁!");
        }
    }
}
