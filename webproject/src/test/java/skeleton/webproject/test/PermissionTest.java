package skeleton.webproject.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.skeleton.webproject.Application;
import com.skeleton.webproject.model.Department;
import com.skeleton.webproject.model.Permission;
import com.skeleton.webproject.model.User;
import com.skeleton.webproject.repository.PermissionRepository;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest("server.port:0")
public class PermissionTest extends TestCase {
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	User userCashier;
	Department departmentCashier;
	Permission permission;
	List<User> users;
	
	   @Before
	    public void setUp() {
		   
	        users = new ArrayList<User>();
	        
	        userCashier = new User();
	        userCashier.setName("Nate");
	        userCashier.setDescription("Nate has three dots");
	        
	        users.add(userCashier);
	        
	        userCashier = new User();
	        userCashier.setName("Baca");
	        userCashier.setDescription("Non of the has three dots");
	        
	        users.add(userCashier);
	        
	        departmentCashier.setName("Cashier 2");
	        departmentCashier.setDescription("Inserting money there");
	        
	        userCashier.setDepartment(departmentCashier);
	        
	        permission.setName("take off money");
	        permission.setDescription("Someone will get more money");
	        permission.setUsers(users);

	        permissionRepository.deleteAll();
	        permissionRepository.save(permission);

	
	    }

}
