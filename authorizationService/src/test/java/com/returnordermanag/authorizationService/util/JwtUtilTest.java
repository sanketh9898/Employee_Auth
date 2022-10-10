package com.returnordermanag.authorizationService.util;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.returnordermanag.authorizationService.Repository.UserRepository;
import com.returnordermanag.authorizationService.service.JwtUtil;

import io.jsonwebtoken.Claims;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class JwtUtilTest {

	UserDetails userDetails;

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object
	 *              automatically
	 */
	@InjectMocks
	JwtUtil jwtUtil;

	@Mock
	UserRepository userRepository;

	@Mock
	Claims claim;

	/**
	 * to test the generation of a token
	 */
	@Test
	void test_generateTokenTest() {
		userDetails = new User("Sanketh", "Sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		assertNotNull(generateToken);
	}
	@Test
	void test_generateTokenWithWrongCredTest() {
		userDetails = new User("Rahul", "Sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		assertNotNull(generateToken);
	}
	/**
	 * to test the validateToken()
	 */
	@Test
	void test_validateTokenTest() {
		userDetails = new User("Sanketh", "Sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	@Test
	void test_validateWithWrongCredTokenTest() {
		userDetails = new User("Somesh", "Sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}
	
	/**
	 * to test the validate token by name
	 */
	@Test
	void test_validateTokenWithNameTest() {
		userDetails = new User("Sanketh", "Sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}
	@Test
	void test_validateTokenWithWrongNameTest() {
		userDetails = new User("Sanket", "Sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}
	@Test
	void test_validateTokenWithWrongPasswordTest() {
		userDetails = new User("Sanket", "sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	@Test
	void tokenExpirationTest() {
		userDetails = new User("Sanketh", "Sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Date expire = jwtUtil.extractExpiration(generateToken);
		Date actual = new Date(System.currentTimeMillis());
		assertTrue(expire.getTime() > actual.getTime());

	}
	
	@Test
	void tokenExpirationWrongCredTest() {
		userDetails = new User("sanketh", "Sanketh", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Date expire = jwtUtil.extractExpiration(generateToken);
		Date actual = new Date(System.currentTimeMillis());
		assertTrue(expire.getTime() > actual.getTime());

	}

}
