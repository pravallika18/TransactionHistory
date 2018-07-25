package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.aspect.Transaction;
import com.example.demo.aspect.User;

@SpringBootApplication
public class TransactionHistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionHistoryApplication.class, args);
		
	}
	
   
}
