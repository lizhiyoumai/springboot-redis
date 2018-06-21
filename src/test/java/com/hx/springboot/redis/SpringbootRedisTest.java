package com.hx.springboot.redis;

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

    @Test
    public void redisTest() {
        redisService.set("myname", "kobe");
        Student s = new Student();
        s.setId("001");
        s.setName("kobe");
        s.setGrade("一年级");
        s.setAge("8");
        redisService.set(s);

        String name = redisService.get("myname");
        System.out.println("name:"+name);

        Student stu = redisService.getStudent("001");
        System.out.println(stu);
    }
}

