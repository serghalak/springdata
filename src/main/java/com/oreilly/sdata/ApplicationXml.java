package com.oreilly.sdata;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("application-context.xml");
		BookService service=context.getBean("bookService",BookService.class);
		service.save(new Book("First Book",new Date(),33,new BigDecimal("26.00")));
		
		context.close();
	}

}
