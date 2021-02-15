package com.creditcard.springtest.controllers;

import com.creditcard.springtest.beans.CCAccount;
import com.creditcard.springtest.repository.CCAccountsRepository;
import com.creditcard.springtest.services.CCAccountService;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class CCAccountsController {
	
	private static final Logger logger = LoggerFactory.getLogger(CCAccountsController.class);
    private final CCAccountsRepository accountRepository;
  

	public CCAccountsController(CCAccountsRepository accountRepository) {
		
		this.accountRepository = accountRepository;
	}
	
	//To display default home page
	@GetMapping("/")
    public String showForm(Model model) {
		
		model.addAttribute("account", new CCAccount());
		
        return "add-user";
    }
	
	//To add customer details from the html page
	@PostMapping(path="/add")
	 public String addCustomer(@ModelAttribute("account")@Valid CCAccount account,BindingResult result,Model model)
	 {
		logger.info("In addCustomer: "+ account);
		if(result.hasErrors())
		 {
			 return "add-user";
		 }
		 
		 accountRepository.save(account);
	     return "redirect:/index";
		 
	 }
	
	//To fetch customer details on html page
	@GetMapping(value="/index",produces = "text/html")
    public String showList(Model model) {
        
		model.addAttribute("users", accountRepository.findAll());
        return "index";
    }
		 	 
}


