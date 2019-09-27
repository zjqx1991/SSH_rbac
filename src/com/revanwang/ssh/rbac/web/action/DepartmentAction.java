package com.revanwang.ssh.rbac.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.revanwang.ssh.rbac.domain.Department;
import com.revanwang.ssh.rbac.service.IDepartmentService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class DepartmentAction extends BaseAction {

    @Setter
    private IDepartmentService departmentService;

    @Getter
    private Department department = new Department();

    public String list() throws Exception {
        List<Department> list = this.departmentService.getList();
        System.out.println("DepartmentAction.list");
        ActionContextPut("department", list);
        return LIST;
    }

    @Override
    public String execute() throws Exception {
        List<Department> list = this.departmentService.getList();
        System.out.println("DepartmentAction.execute");
        ActionContextPut("department", list);
        return LIST;
    }

    @Override
    public String input() throws Exception {
        System.out.println("DepartmentAction.input" + this.department);
        if (this.department.getId() != null) {
            this.department = this.departmentService.get(this.department.getId());
        }
        return INPUT;
    }

    public String delete() {
        System.out.println("DepartmentAction.delete" + department);
        if (this.department.getId() != null) {
            departmentService.delete(department);
        }
        return SUCCESS;
    }

    /**
     * 保存或者更新
     */
    public String saveOrUpdate() {
        System.out.println("DepartmentAction.saveOrUpdate" + this.department);
        if (this.department.getId() == null) {
            //新增部门
            this.departmentService.save(this.department);
        }
        else {
            //更新部门
            departmentService.update(department);
        }
        return SUCCESS;
    }

}
