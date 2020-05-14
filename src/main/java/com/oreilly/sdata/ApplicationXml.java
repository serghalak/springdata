package com.oreilly.sdata;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

public class ApplicationXml {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("application-context.xml");
//		BookService service=context.getBean("bookService",BookService.class);
//		service.save(new Book("First Book",new Date(),33,new BigDecimal("26.00")));
//		
//		context.close();
		BookRepository bookRepository=context.getBean("bookRepository",BookRepository.class);
		//System.out.println(bookRepository.findOne(1L));
		
		//System.out.println(bookRepository.findByTitle("Design Patterns"));
		
		//ArrayList<Long>listId=new ArrayList();
//		List<Book> books= bookRepository.findAll(new ArrayList<Long>(){{
//			add(1L);
//			add(3L);
//			add(7L);
//		}});
//		for(Book book: books)
//			System.out.println(book);
		
		
		Environment env= context.getEnvironment();
		Properties ht = System.getProperties();
		
		System.out.println("***************************"+env.getProperty("java.version"));
		
		for(Book book : bookRepository.findByTitleLike("%f%")){
			System.out.println(book);
		}
		
//		Date date=new SimpleDateFormat("MM/dd/yyyy").parse("10/22/1995");
//		
//		for(Book book : bookRepository.findByPublishDateAfter(date)){
//			System.out.println(book);
//		}
		
//		for(Book book : bookRepository.queryOne()){
//			System.out.println(book);
//		}
		
		//pagable
//		for(Book book : 
//			bookRepository
//				.findByPageCountGreaterThan(99,new PageRequest(0,2))
//				){
//			System.out.println(book);
//		}
		
//		for(Book book : bookRepository.findAll(
//				new Sort(Sort.Direction.DESC,"price")
//					.and(new Sort(Sort.Direction.ASC,"pageCount")))){
//			System.out.println(book);
//		}
	
//		for(Book book : bookRepository.findByPageCountGreatherThan(100,
//				new Sort("pageCount"))){
//			System.out.println(book);
//		}
//		
//		Page page =bookRepository.findByPageCountGreaterThan(10,new PageRequest(0,3));
//		System.out.println("Page>>>>>>>>>"+page.getContent());
		
//		for(Book b : bookRepository.findByIds(1L,2L,3L)){
//			System.out.println(b);
//		}
		
		for(long x=0;x<4;x++){
			bookRepository.findByIds(x);
		}

	}
}
