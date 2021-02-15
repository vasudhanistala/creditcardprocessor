
  package com.creditcard.springtest.creditcardprocessor;
  
  import static org.assertj.core.api.Assertions.assertThat; 
  import static org.mockito.Mockito.mock; 
  import static org.mockito.Mockito.when;
  import org.junit.jupiter.api.BeforeAll; 
  import org.junit.jupiter.api.BeforeEach; 
  import org.junit.jupiter.api.Test; 
  import org.springframework.ui.Model; 
  import org.springframework.validation.BindingResult;
  import com.creditcard.springtest.beans.CCAccount; 
  import com.creditcard.springtest.controllers.CCAccountsController; 
  import com.creditcard.springtest.repository.CCAccountsRepository;
  
  
  public class CCAccountsControllerTest {
  
  private static CCAccountsController ccAccountsController; 
  private static CCAccountsRepository ccAccountsRepository; 
  private static BindingResult mockedBindingResult; 
  private static Model mockedModel;
  
  @BeforeAll 
  public static void setUpUserControllerInstance() {
  
	  ccAccountsRepository = mock(CCAccountsRepository.class); 
  
	  mockedBindingResult = mock(BindingResult.class); mockedModel = mock(Model.class);
  
	  ccAccountsController = new CCAccountsController(ccAccountsRepository); 
  }
  
  @Test 
  public void whenCalledIndex_thenCorrect() {
  
	  assertThat(ccAccountsController.showList(mockedModel)).isEqualTo("index"); 
  }
  
  
  @Test 
  public void whenCalledshowForm_thenCorrect() { 
	  
	  CCAccount account = new CCAccount();
      
	  assertThat(ccAccountsController.showForm(mockedModel)).isEqualTo("add-user");
  }
  
  
  
   @Test 
   public void whenCalledaddCustomerAndValidUser_thenCorrect() { 
	  
	  CCAccount account = new CCAccount();
      
	  when(mockedBindingResult.hasErrors()).thenReturn(false);
      
      assertThat(ccAccountsController.addCustomer(account, mockedBindingResult,mockedModel)).isEqualTo("redirect:/index"); 
      
  	}
  
  
 }
 