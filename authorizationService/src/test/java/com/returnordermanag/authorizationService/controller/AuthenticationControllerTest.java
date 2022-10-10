package com.returnordermanag.authorizationService.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.returnordermanag.authorizationService.controller.AuthenticationController;
import com.returnordermanag.authorizationService.exception.BadCredentialException;
import com.returnordermanag.authorizationService.model.AuthenticationRequest;
import com.returnordermanag.authorizationService.model.AuthenticationResponse;
import com.returnordermanag.authorizationService.service.MyUserDetailsService;
import com.returnordermanag.authorizationService.service.ValidateService;
import com.returnordermanag.authorizationService.service.JwtUtil;



@ExtendWith(MockitoExtension.class) 
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AuthenticationControllerTest {
	
	@InjectMocks
	AuthenticationController authController;
	
	@InjectMocks
	AuthenticationResponse authResponse;
	
	@Mock
	AuthenticationManager authenticationManager;
	
	@Mock
	MyUserDetailsService userDetailsService;
	
	@Mock
	JwtUtil jwtTokenUtil;
	
	@Mock
	ValidateService validateService;
	
	@Mock
	AuthenticationResponse authenticationResponse;
	
	
	
	UserDetails userDetails;
	
	@InjectMocks
	JwtUtil jwtToken;

	
	@Test
	void createAuthenticationTokenTest() throws BadCredentialException {
		AuthenticationRequest authRequest = new AuthenticationRequest("Sanketh","sanketh");
		 ResponseEntity<?> response=authController.createAuthenticationToken(authRequest);
		 assertEquals( 200 , response.getStatusCodeValue() );
		
	}
	
	
	@Test
	void createAuthenticationTokenTestFailed() throws BadCredentialException {
		AuthenticationRequest authRequest = new AuthenticationRequest("Sanketh","bhargav");
		 ResponseEntity<?> response=authController.createAuthenticationToken(authRequest);	 
		 assertNotNull(response);
		
	}
	
	@Test
	void getValidityFailTest() {	
		userDetails = new User("Sanketh", "Sanketh", new ArrayList<>());
		String generateToken = jwtToken.generateToken(userDetails);
		Boolean response=jwtTokenUtil.validateToken(generateToken);
		assertEquals(false,response);
	}

}

