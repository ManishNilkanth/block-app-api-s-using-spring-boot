package com.manishCreation.blogappapi.s;

import com.manishCreation.blogappapi.s.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	public void repoTest()
	{
		String className = this.userRepository.getClass().getName();
		String packageName = this.userRepository.getClass().getPackageName();

		System.out.println("the class name is :"+className);
		System.out.println("the class name is :"+packageName);

	}

}
