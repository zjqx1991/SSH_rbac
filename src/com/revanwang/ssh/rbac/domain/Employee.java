package com.revanwang.ssh.rbac.domain;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {

    private Long        id;
    private String      name;
    private String      password;
    private String      email;
    private Integer     age;
    private Boolean     admin;          //是否是超级管理员
    private Department  department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                '}';
    }
}
