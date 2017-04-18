package skeleton.webproject.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.skeleton.webproject.model.Department;
import com.skeleton.webproject.repository.DepartmentRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application.properties")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class DepartmentTest extends TestCase {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void testDepartment() {
		
	  Assert.assertNotNull(departmentRepository);

      long count = departmentRepository.findAll().size();

      Assert.assertTrue(count > 0);

      List<Department> countries = departmentRepository.findAll();

      Assert.assertEquals((int) count, countries.size());		
		
	}
	
    @Test
    public void testFindOneDepartment() {

        Assert.assertNotNull(departmentRepository);

        Department department = departmentRepository.findById(2);

        Assert.assertNotNull(department);

    }

}
