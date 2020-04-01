package com.oreilly.sdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationXml {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("application-context.xml");
//		BookService service=context.getBean("bookService",BookService.class);
//		service.save(new Book("First Book",new Date(),33,new BigDecimal("26.00")));
//		
//		context.close();
		BookRepository bookRepository=context.getBean("bookRepository",BookRepository.class);
		System.out.println(bookRepository.findOne(1L));
		//ArrayList<Long>listId=new ArrayList();
//		List<Book> books= bookRepository.findAll(new ArrayList<Long>(){{
//			add(1L);
//			add(3L);
//			add(7L);
//		}});
//		for(Book book: books)
//			System.out.println(book);
		
		
		
	}

}
