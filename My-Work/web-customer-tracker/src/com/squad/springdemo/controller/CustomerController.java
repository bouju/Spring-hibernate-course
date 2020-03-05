package com.squad.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.misc.Contended;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/list")
	public String listCustomers(Model mode) {
		
		return "list-customers";
	}

}
