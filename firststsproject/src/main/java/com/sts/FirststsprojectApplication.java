package com.sts;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sts.dao.UserRepository;
import com.sts.entities.User;
import com.sts.entities.UserDetails;

@SpringBootApplication
public class FirststsprojectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(FirststsprojectApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);
		User user=new User();
		user.setName("abc");
		user.setCity("purnia");
		user.setStatus("I am dotnet programmer");
		
		User user1=new User();
		user1.setName("john");
		user1.setCity("delhi");
		user1.setStatus("I am php programmer");
		List<User> users=List.of(user,user1);
		Iterable<User> result=userRepository.saveAll(users);
		result.forEach(u->System.out.println("the users added now"+u));
		
		/*Optional<User> op=userRepository.findById(16);
		User us=op.get();
		//System.out.println(us);
		us.setName("tom");
		User resultnew=userRepository.save(us);
		
		System.out.println("The updated result is "+resultnew);
		
		Iterable<User> itr=userRepository.findAll();
		itr.forEach(a->System.out.println("all the records "+a));*/
		
		//List<User> findByName = userRepository.findByName("tom");
		//findByName.forEach(n->System.out.println(n));
		
		//List<User> findByNameAndCity = userRepository.findByNameAndCity("john", "delhi");
		//List<User> findByNameAndCity=userRepository.findByNameStartingWith("j");
		//findByNameAndCity.forEach(a->System.out.println(a));
		
		/*List<String> allUser = userRepository.getname("tom");
		allUser.forEach(a->System.out.println(a));*/
	

		
		
		
		

	}

}
