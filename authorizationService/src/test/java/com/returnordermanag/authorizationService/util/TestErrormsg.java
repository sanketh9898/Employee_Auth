package com.returnordermanag.authorizationService.util;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import org.springframework.http.HttpStatus;

import com.returnordermanag.authorizationService.exception.Error;



 class TestErrormsg {
    Error error = new Error();
    
    
    /*Testing Error message creation*/
	  @Test
	   void SetTestError() {
	      
	       
	       String msg="Card not found";
	       error.setMessage(msg);
	       assertSame(error.getMessage(),msg);
	      

}
	  @Test
	    void GetTestError() {
		 
		  String msg="Card not found";
		  error.setMessage(msg);
	      assertSame(error.getMessage(),msg);
	      

}
	  @Test 
		 void testNotNullErrormsgObject() {
			assertNotNull(error);
		}
	  
	  @Test
		 void testEqualsMethod() {
			boolean equals = error.equals(error);
			assertTrue(equals);
		}
	  
	  @Test
	   void GetTestErrorFalse() {
		  
		  String msg="Card not found";
		  error.setMessage(msg);
		  String msg1="Card found";
	       /*Passing wrong message*/
	      assertNotSame(error.getMessage(),msg1);
	      

}
	  
	  @Test
	   void GetTestErrorEquals() {
		  
		  String msg="Card not found";
		  error.setMessage(msg);
	      assertEquals(msg,error.getMessage());
	      

}
	  
	  @Test
	   void GetTestErrorNotEquals() {
		 
		  String msg="Error";
		  error.setMessage(msg);
		  HttpStatus status = null;
		  LocalDateTime  time = LocalDateTime.now();
		error.setStatus(status);
		  	error.setTimestamp(time);
	      assertNotEquals(error.getMessage(),error.getStatus());
	      assertEquals(time,error.getTimestamp());

}
}
