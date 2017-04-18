package skeleton.webproject.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.skeleton.webproject.model.User;
import com.skeleton.webproject.repository.UserRepository;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application.properties")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class UserTest extends TestCase {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testCity() {
		
      Assert.assertNotNull(userRepository);
        
      Assert.assertTrue(userRepository.findAll().size()>0);

      User country = new User();
      country.setId(2); // Should be France

      User user = userRepository.findOne(country.getId());

      Assert.assertNotNull(user);		
		
	}

}
