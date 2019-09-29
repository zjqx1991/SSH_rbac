package com.revanwang.ssh.rbac.query;

import com.revanwang.ssh.rbac.domain.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 封装分页查询信息
 */
public class PageResult {
    private Long        totalCount;     //总数据个数：SQL查询
    @Setter @Getter
    private List<Employee>  result;     //获取数据：SQL查询

    private Long        currentPage;    //当前页
    private Long        pageSize;       //每页个数

    private Long        totalPage;      //总页数
    private Long        previousPage;   //上一页
    private Long        nextPage;       //下一页

    public PageResult(Long totalCount, List<Employee> result, Long currentPage, Long pageSize) {
        this.totalCount = totalCount;
        this.result = result;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        Long total_Page = this.totalCount / this.pageSize;
        this.totalPage = this.totalCount % this.pageSize == 0 ? total_Page : (total_Page + 1);
        //计算上一页
        this.previousPage = this.currentPage - 1 > 0 ? this.currentPage - 1 : 1;
        //计算下一页
        this.nextPage = this.currentPage + 1 > this.totalPage ? this.totalPage : this.currentPage + 1;
    }
}
