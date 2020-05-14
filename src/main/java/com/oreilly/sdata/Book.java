package com.oreilly.sdata;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.data.jpa.repository.Query;



@NamedQueries({
	@NamedQuery(name="Book.queryOne" 
			, query="select b from Book b"),
	@NamedQuery(name="Book.queryTwo" 
			,query="select b from Book b where b.pageCount > ?1"),
	@NamedQuery(name="Book.queryThree"
			, query="select b from Book b where b.title = :title")
})

@Entity
@Table(name = "BOOK")
//@Proxy(lazy = false)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Long bookId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "PUBLISH_DATE")
	private Date publishDate;

	@Column(name = "PAGE_COUNT")
	private int pageCount;

	@Column(name = "PRICE")
	private BigDecimal price;

	public Book() {

	}

	public Book(String title, Date publishDate, int pageCount, BigDecimal price) {
		this.title = title;
		this.publishDate = publishDate;
		this.pageCount = pageCount;
		this.price = price;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publishDate=" + publishDate + ", pageCount="
				+ pageCount + ", price=" + price + "]";
	}
		
	
}
