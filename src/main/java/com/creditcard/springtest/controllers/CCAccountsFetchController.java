
  package com.creditcard.springtest.controllers;
  
  import java.util.List;
  import com.creditcard.springtest.services.CCAccountService;
  import org.springframework.stereotype.Controller; 
  import org.springframework.web.bind.annotation.*;
  import com.creditcard.springtest.beans.*;
  import org.apache.commons.logging.Log;
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  
  @RestController
  public class CCAccountsFetchController {
	  
	  private static final Logger logger = LoggerFactory.getLogger(CCAccountsController.class);
      private final CCAccountService CCAccountService;
  
      public CCAccountsFetchController(CCAccountService ccAccountService) {
	  
	  CCAccountService = ccAccountService; 
	  
      }	
      
      //To get json response of customer details
      @GetMapping (value="/index",produces = "application/json")
      public List<CCAccount> getAllCustomers() { 
    	  
	  return CCAccountService.findAll(); 
	  }
  
      //To post customer details
      @PostMapping(value="/addcustomer")
      public String addCustomerJson(@RequestBody CCAccount account)
      {
		 logger.info("In addCustomer: "+ account);
		 CCAccountService.add(account);
		 
		return "Added Successfully";
		 
      }
  
  }
 