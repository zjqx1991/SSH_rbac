package com.revanwang.ssh.rbac.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 封装查询条件
 */
abstract public class abstractQueryObject {
    @Setter
    @Getter
    private int currentPage = 1;    //当前页
    @Setter
    @Getter
    private int pageSize = 5;       //每页个数

    private boolean isCondition = false;
    //保存高级查询参数
    private List<Object> params = new ArrayList();
    //保存高级查询条件
    private List<String> conditions = new ArrayList<>();


    /**
     * 子类自定义查询条件
     */
    abstract protected void customQueryCondition();

    /**
     * 添加查询条件和对应的查询值
     */
    protected void queryConditionWithParams(String condition, Object... args) {
        this.conditions.add(condition);
        this.params.addAll(Arrays.asList(args));
        System.out.println("abstractQueryObject.queryConditionWithParams：" + this.params);
    }

    /**
     * 防止重复添加请求参数
     */
    private void initQueryCondition() {
        if (!isCondition) {
            //执行子类查询条件
            this.customQueryCondition();
            isCondition = true;
        }
    }

    /**
     * @return 查询条件
     */
    public String getQueryCondition() {

        initQueryCondition();

        //没有查询条件
        if (params.size() == 0) {
            return "";
        }
        //拼接SQL语句
        return " WHERE " + StringUtils.join(conditions, " AND ");
    }

    /**
     * @return 高级查询参数
     */
    public List<Object> getQueryParams() {
        return params;
    }

    protected boolean hasLength(String string) {
        return (string != null) && !("".equals(string.trim()));
    }
}
