package com.revanwang.ssh.rbac.domain;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department extends BaseDomain {

    private String      name;
    private String      sn;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                '}';
    }
}
