package com.example.demo.config;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.aspect.Transaction;
import com.example.demo.aspect.TranscationDomain;


@Aspect
@Component
public class TransactionHistoryAspect {
	
	
	@AfterReturning(pointcut = "execution(@com.example.demo.aspect.Transaction * *(..)) && @annotation(userTransactionAnnotation)", returning = "returnObject")
	public void logTransactionInfo(JoinPoint joinPoint, Transaction userTransactionAnnotation,
			Object returnObject) throws Exception {

		this.saveHistory(joinPoint, userTransactionAnnotation, returnObject);
	}
	
	private void saveHistory(JoinPoint joinPoint, Transaction annotation, Object returnObject) {
		try {
			
			TranscationDomain transactionDomain = new TranscationDomain();
			
			BeanUtils.copyProperties(transactionDomain, annotation);
			BeanUtils.setProperty(transactionDomain, "serviceName", annotation.serviceName());
			BeanUtils.setProperty(transactionDomain, "methodName", joinPoint.getSignature().getName());
			BeanUtils.setProperty(transactionDomain, "actionName", annotation.actionName());
				
			Object objectValue = null;
			String[] fields = annotation.fields();
			for (String field : fields) {
				String[] split = field.split("=");
				objectValue = PropertyUtils.getProperty(returnObject, split[1]);
				PropertyUtils.setProperty(transactionDomain, split[0], objectValue);
			}
			System.out.println(transactionDomain.toString());
			
			//em.persist(transEntity);
		} catch (Exception e) {
			// Dont stop incase of error in annotation
			e.printStackTrace();
		}

	}

}
