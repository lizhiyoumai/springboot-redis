package com.hx.springboot.redis;

import java.io.Serializable;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/6/21 14:23
 */
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String age;

    private String grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
