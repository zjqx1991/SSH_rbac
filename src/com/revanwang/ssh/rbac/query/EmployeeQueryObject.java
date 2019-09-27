package com.revanwang.ssh.rbac.query;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeQueryObject {
    @Setter @Getter
    private String  keyword;        //姓名和邮箱
    @Setter @Getter
    private Long    departId = 0L;  //部门id

    //保存高级查询参数
    private List<Object> params = new ArrayList();
    //保存高级查询条件
    private List<String> condition = new ArrayList<>();

    /**
     * @return 查询条件
     */
    public String getQueryCondition() {
        System.out.println("EmployeeQueryObject.getQueryCondition" + keyword + "__" + departId);
        if (hasLength(keyword)) {
            //拼接查询条件(姓名或者邮箱)
            condition.add("(obj.name LIKE ? OR obj.email LIKE ?)");
            //姓名参数值
            params.add("%" + keyword + "%");      //姓名
            params.add("%" + keyword + "%");      //邮箱
        }

        if (departId > 0) {
            //条件：部门
            condition.add("obj.department.id = ?");
            //参数：部门id
            params.add(departId);
        }

        //没有查询条件
        if (params.size() == 0) {
            return "";
        }
        //查询条件
        StringBuilder stringBuilder = new StringBuilder(80);
        for (int i = 0; i < condition.size(); i++) {
            //第一个拼接 WHERE
            if (i == 0) {
                stringBuilder.append(" WHERE ");
            }
            else {
                stringBuilder.append(" AND ");
            }

            stringBuilder.append(condition.get(i));
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * @return 高级查询参数
     */
    public List<Object> getQueryParams() {
        return params;
    }

    private boolean hasLength(String string) {
        return (string != null) && !("".equals(string.trim()));
    }
}
