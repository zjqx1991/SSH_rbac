package com.revanwang.ssh.rbac.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.revanwang.ssh.rbac.domain.Department;
import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.service.IDepartmentService;
import com.revanwang.ssh.rbac.service.IEmployeeService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class EmployeeAction extends ActionSupport {

    private final String LIST = "list";

    @Setter
    private IEmployeeService employeeService;
    @Setter
    private IDepartmentService departmentService;
    @Getter
    private Employee employee = new Employee();

    @Override
    public String execute() throws Exception {
        System.out.println("EmployeeAction.execute");
        List<Employee> employees = employeeService.getList();
        List<Department> departments = departmentService.getList();
        ActionContext.getContext().put("employees", employees);
        ActionContext.getContext().put("depts", departments);
        return LIST;
    }

    @Override
    public String input() throws Exception {
        System.out.println("DepartmentAction.input" + employee);
        List<Department> departments = departmentService.getList();
        ActionContext.getContext().put("depts", departments);
        if (employee.getId() != null) {
            employee = employeeService.get(employee.getId());
        }
        return INPUT;
    }

    public String delete() {
        System.out.println("DepartmentAction.delete" + employee);
        if (employee.getId() != null) {
            employeeService.delete(employee);
        }
        return SUCCESS;
    }

    /**
     * 保存或者更新
     */
    public String saveOrUpdate() {
        System.out.println("DepartmentAction.saveOrUpdate" + employee);
        Department d = departmentService.get(employee.getDepartment().getId());
        if (employee.getId() == null) {
            //新增Employee
            employeeService.save(employee);
        } else {
            //更新Employee
            employeeService.update(employee);
        }
        return SUCCESS;
    }

}
