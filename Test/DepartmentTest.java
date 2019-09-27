import com.revanwang.ssh.rbac.domain.Department;
import com.revanwang.ssh.rbac.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentTest {

    @Autowired
    private IDepartmentService departmentService;


    @Test
    public void saveTest() {
        Department depart = new Department();
        depart.setName("研发部");
        depart.setSn("Y01");
        this.departmentService.save(depart);
    }


    @Test
    public void deleteTest() {
        Department depart = new Department();
        depart.setId(1L);
        this.departmentService.delete(depart);
    }


    @Test
    public void updateTest() {
        Department depart = new Department();
        depart.setId(3L);
        depart.setName("市场部");
        depart.setSn("S01");
        this.departmentService.update(depart);
    }


    @Test
    public void getTest() {
        Department department = this.departmentService.get(3L);
        System.out.println(department);
    }

    @Test
    public void getListTest() {
        List<Department> list = this.departmentService.getList();
        for (Department department : list) {
            System.out.println("department = " + department);
        }
    }

}
