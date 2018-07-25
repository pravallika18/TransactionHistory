package com.example.demo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

	@Retention(RetentionPolicy.RUNTIME)  
	@Target({ElementType.METHOD})  
	public @interface Transaction {
		public String serviceName();
		public String actionName(); 
	/*	public String transactionId(); 
		public String status();
	    public String createdDate();
	    public String lastModifiedDate();
	    public String errorInfo();
	 */
	// @interface EntityInfo {
	    public String entity();
	    public String[] fields();
	// }
	
}
