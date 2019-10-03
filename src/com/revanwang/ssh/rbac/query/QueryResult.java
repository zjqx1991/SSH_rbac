package com.revanwang.ssh.rbac.query;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * 封装分页查询信息
 */
public class QueryResult<T> {
    @Setter @Getter
    private int        totalCount;     //总数据个数：SQL查询
    @Setter @Getter
    private List<T>  result;     //获取数据：SQL查询
    @Setter @Getter
    private int        currentPage;    //当前页
    @Setter @Getter
    private int        pageSize;       //每页个数

    @Setter @Getter
    private int        totalPage;      //总页数
    @Setter @Getter
    private int        previousPage;   //上一页
    @Setter @Getter
    private int        nextPage;       //下一页

    public QueryResult(int totalCount, List<T> result, int currentPage, int pageSize) {
        this.totalCount = totalCount;
        this.result = result;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        int total_Page = this.totalCount / this.pageSize;
        this.totalPage = this.totalCount % this.pageSize == 0 ? total_Page : (total_Page + 1);
        //计算上一页
        this.previousPage = this.currentPage - 1 > 0 ? this.currentPage - 1 : 1;
        //计算下一页
        this.nextPage = this.currentPage + 1 > this.totalPage ? this.totalPage : this.currentPage + 1;
    }

    public static QueryResult empty() {
        return new QueryResult(0, Collections.emptyList(), 1, 5);
    }
}

