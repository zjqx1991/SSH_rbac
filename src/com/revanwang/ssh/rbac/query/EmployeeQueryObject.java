package com.revanwang.ssh.rbac.query;

import lombok.Getter;
import lombok.Setter;

public class EmployeeQueryObject extends abstractQueryObject {
    @Setter
    @Getter
    protected String  keyword;        //姓名和邮箱
    @Setter @Getter
    private Long    departId = 0L;  //部门id

    @Override
    public void customQueryCondition() {
        if (hasLength(keyword)) {
            //拼接查询条件(姓名或者邮箱)
            super.queryConditionWithParams("(obj.name LIKE ? OR obj.email LIKE ?)", "%" + keyword + "%", "%" + keyword + "%");
        }
        if (departId > 0) {
            //条件：部门
            super.queryConditionWithParams("obj.department.id = ?", departId);
        }
    }
}
