package com.interfaceco.validationtool.usermanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.interfaceco.validationtool.usermanagement.model.Account;
import com.interfaceco.validationtool.usermanagement.service.AccountService;
import com.interfaceco.validationtool.usermanagement.validation.UsernameExistsException;

@Controller
public class UserManegmentController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/registration")
	public String goToRegistrationPage(Model model) {
		model.addAttribute("account", new Account());
		System.err.println(accountService);
		return "account-registration-form";
	}

	@PostMapping("/user/register") 
	public String registerAccount(@Valid @ModelAttribute("account") Account account, Errors errors,
			@RequestParam("password") String password, Model model) throws UsernameExistsException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		try {
			if (!accountService.registerAccount(account, password, errors))
				return "account-registration-form";
			else
				return "redirect:/welcome";
		} catch (UsernameExistsException e){
			errors.reject("exists", "username already exists!");
			return "account-registration-form";
		}
	}
}
