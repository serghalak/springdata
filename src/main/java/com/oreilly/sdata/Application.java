package com.oreilly.sdata;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(
						DataConfiguration.class)){
		BookService service=context.getBean("bookService",BookService.class);
		 service.save(new Book("First Book",new Date(),33,new BigDecimal("26.00")));
		}finally{
			
		}
		
	}

}
