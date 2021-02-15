package com.creditcard.springtest.creditcardprocessor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.creditcard.springtest.beans.CCAccount;
import com.creditcard.springtest.controllers.CCAccountsController;
import com.creditcard.springtest.controllers.CCAccountsFetchController;
import com.creditcard.springtest.repository.CCAccountsRepository;
import com.creditcard.springtest.services.CCAccountService;

public class CCAccountsFetchControllerTest {
	
	  private static CCAccountsFetchController ccAccountsFetchController; 
	  private static CCAccountService ccAccountsService; 
	  private static BindingResult mockedBindingResult; 
	  private static Model mockedModel;
	  
	  @BeforeAll 
	  public static void setUpUserControllerInstance() {
	      
		  
		  ccAccountsService = mock(CCAccountService.class); 
		  mockedBindingResult = mock(BindingResult.class); 
		  mockedModel = mock(Model.class);
		  ccAccountsFetchController = new CCAccountsFetchController(ccAccountsService); 
	  }
	  
	  
	  
	  @Test 
	  public void whenCalledshowForm_thenCorrect() { 
		  
		  CCAccount account = new CCAccount();
	      
		  assertThat(ccAccountsFetchController.addCustomerJson(account)).isEqualTo("Added Successfully");
	  }
	  
	  
	  
	   

}
