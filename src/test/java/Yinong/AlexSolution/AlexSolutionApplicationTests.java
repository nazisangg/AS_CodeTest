package Yinong.AlexSolution;

import Yinong.AlexSolution.Model.Courses;
import Yinong.AlexSolution.Model.User;
import Yinong.AlexSolution.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlexSolutionApplicationTests {
	@Resource
	private UserRepository userRepository;
	@Test
	public void UserRepositoryTest() {
		Set<Courses> courses = new HashSet<>();
		userRepository.save(new User("YinongXia", "summer1993", courses));
		Assert.assertEquals(1, userRepository.findAll().size());
		Assert.assertEquals("YinongXia", userRepository.findByUsername("YinongXia").getUsername());
		userRepository.deleteAll();
		Assert.assertEquals(0, userRepository.findAll().size());
	}

}
