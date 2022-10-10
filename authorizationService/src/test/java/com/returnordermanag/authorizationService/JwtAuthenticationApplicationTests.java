package com.returnordermanag.authorizationService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.returnordermanag.authorizationService.model.MyUser;

@SpringBootTest
class JwtAuthenticationApplicationTests {

	@Test
	void contextLoads() {
	}
	
		MyUser myUser = new MyUser();

		@Test
		void testGetUserId() {
			myUser.setUserid("1");
			assertEquals("1", myUser.getUserid());
		}

		

		@Test
		void testGetUsername() {
			myUser.setUsername("Sanketh");
			assertEquals("Sanketh", myUser.getUsername());
		}

		@Test 
		void login() {
			
		};
		@Test
		void testWorngUsername() {
			myUser.setUsername("Ranketh");
			assertEquals("Ranketh", myUser.getUsername());
		}

		@Test
		void testGetPassword() {
			myUser.setPassword("Sanketh");
			assertEquals("Sanketh", myUser.getPassword());
		}


		
		@Test
		void testConstructor() {
			MyUser myUser = new MyUser("1", "Sanketh", "Sanketh");
			assertNotNull(myUser.getUserid());
			assertEquals("Sanketh", myUser.getUsername());
			assertEquals("Sanketh", myUser.getPassword());
		}
	}
