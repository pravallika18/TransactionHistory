package com.example.demo.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aspect.Transaction;
import com.example.demo.aspect.User;
@RestController("/transaction")
public class Controller {
	@GetMapping
	//@Transactional
	@Transaction(
             serviceName="User",
             actionName="New",
             entity="com.example.demo.aspect.TranscationDomain",                  
      fields={"id=id","status=status"})
public  User transaction() {
	User user=new User();
	user.setId("1");
	user.setStatus("active");
	return user;
	
}

}
