package com.hx.springboot.redis.mutex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/12/18 15:12
 */
@Service
public class LogicService {
    private Logger logger = LoggerFactory.getLogger(LogicService.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void redisLock(int i) {
        RedisLock redisLock = new RedisLock(redisTemplate, "redisLockKey:"+i % 10, 5*60 , 500);
        try {
            long now = System.currentTimeMillis();
            if (redisLock.lock()) {
                logger.info("获取锁花费的时间:" + (System.currentTimeMillis() - now));
                // TODO 获取到锁要执行的代码块
                System.out.println("逻辑执行...");
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        } finally {
            // 一定要释放锁
            redisLock.unlock();
        }
    }

}
