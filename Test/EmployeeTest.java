import com.revanwang.ssh.rbac.domain.Department;
import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.EmployeeQueryObject;
import com.revanwang.ssh.rbac.query.PageResult;
import com.revanwang.ssh.rbac.service.IDepartmentService;
import com.revanwang.ssh.rbac.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeTest {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void saveTest() {

        for (int i = 0; i < 24; i++) {

            Department department = this.departmentService.get((long) (i % 2) + 2);

            Employee emp = new Employee();
            emp.setName("test_" + i);
            emp.setAge(79);
            emp.setDepartment(department);
            this.employeeService.save(emp);
        }
    }


    @Test
    public void deleteTest() {
        this.employeeService.delete(1L);
    }

    @Test
    public void updateTest() {
        Department department = this.departmentService.get(4L);

        Employee emp = new Employee();
        emp.setId(4L);
        emp.setName("虚竹");
        emp.setAge(90);
        emp.setDepartment(department);

        this.employeeService.update(emp);
    }

    @Test
    public void getTest() {
        Employee emp = this.employeeService.get(2L);
        System.out.println("emp = " + emp);
    }

    @Test
    public void getListTest() {
        List<Employee> list = this.employeeService.getList();
        for (Employee emp : list) {
            System.out.println("emp = " + emp);
        }
    }


    @Test
    public void queryTest() {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setKeyword("11");
        qo.setDepartId(3L);
        List<Employee> list = this.employeeService.query(qo);
        for (Employee emp : list) {
            System.out.println("query = " + emp);
        }
    }


    @Test
    public void queryPageTest() {
        PageResult pageResult = employeeService.queryPage(2L, 3L);
        List<Employee> list = pageResult.getResult();
        for (Employee emp : list) {
            System.out.println("query = " + emp);
        }
    }
}
