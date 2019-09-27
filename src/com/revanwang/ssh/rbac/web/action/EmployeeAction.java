package com.revanwang.ssh.rbac.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.revanwang.ssh.rbac.domain.Department;
import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.service.IDepartmentService;
import com.revanwang.ssh.rbac.service.IEmployeeService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class EmployeeAction extends BaseAction {


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
        ActionContextPut("employees", employees);
        ActionContextPut("depts", departments);
        return LIST;
    }

    @Override
    public String input() throws Exception {
        System.out.println("DepartmentAction.input" + employee);
        List<Department> departments = departmentService.getList();
        ActionContextPut("depts", departments);
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
        if (employee.getId() == null) {
            //新增Employee
            employeeService.save(employee);
        } else {
            //更新Employee
            employeeService.update(employee);
        }
        return SUCCESS;
    }

    /**
     * 只会在 saveOrUpdate方法执行前执行
     * 默认拦截器栈defaultStack，prepare拦截器是在params拦截器前
     * 所以在执行prepareSaveOrUpdate的时候是无法拿到参数值，所以
     * 需要换一个拦截器栈paramsPrepareParamsStack
     */
    public void prepareSaveOrUpdate() {
        System.out.println("EmployeeAction.prepareSaveOrUpdate_1:" + employee);
        if (employee.getId() != null) {
            System.out.println("EmployeeAction.prepareSaveOrUpdate_2:" + employeeService.get(employee.getId()));
            employee = employeeService.get(employee.getId());
            System.out.println("EmployeeAction.prepareSaveOrUpdate_3:" + employee);
        }
    }
}
