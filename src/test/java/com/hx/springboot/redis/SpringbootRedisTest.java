package com.hx.springboot.redis;

import com.hx.springboot.redis.mutex.LogicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/6/21 14:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisTest {
    @Autowired
    private RedisService redisService;
    @Autowired
    private LogicService logicService;

    @Test
    public void redisTest() {
//        redisService.set("hello", "world");
//        String name = redisService.get("hello");
//        System.out.println("name:"+name);

        Student s = new Student();
        s.setId("001");
        s.setName("kobe");
        s.setGrade("一年级");
        s.setAge("8");
        redisService.set(s);
        Student stu = redisService.getStudent("001");
        System.out.println(stu);
    }

    @Test
    public void testMutexLock(){
        logicService.redisLock(1);
    }
}

