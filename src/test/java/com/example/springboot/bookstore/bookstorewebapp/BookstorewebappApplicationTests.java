package com.example.springboot.bookstore.bookstorewebapp;

import com.example.springboot.bookstore.bookstorewebapp.dao.SampleDao;
import com.example.springboot.bookstore.bookstorewebapp.dao.SampleDaoImpl;
import com.example.springboot.bookstore.bookstorewebapp.entity.Books;
import com.example.springboot.bookstore.bookstorewebapp.entity.Customers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {com.example.springboot.bookstore.bookstorewebapp.BookstorewebappApplication.class})
class BookstorewebappApplicationTests
{
	@Mock
	private SampleDaoImpl sampleDao ;

	@Test
	void find_All_Customers_Test()
	{
		Customers customers = new Customers("Vinay" ,"Singh" , Collections.emptyList(),"vinaysingh@gmail.com") ;
		Customers customers2 = new Customers("Ahilya" ,"Singh" , Collections.emptyList(),"ahilya@gmail.com") ;
		Customers customers3 = new Customers("Rajeev" ,"Shukla" , Collections.emptyList(),"rajeev.s@gmail.com") ;
		List<Customers> customersList = new ArrayList<>();
		customersList.add(customers) ;
		customersList.add(customers2) ;
		customersList.add(customers3) ;
		Mockito.when(sampleDao.findAllCustomer()).thenReturn(customersList) ;
		Assertions.assertEquals(customersList,sampleDao.findAllCustomer());
		Mockito.verify(sampleDao).findAllCustomer() ;
	}
	@Test
	void find_All_Books_Test()
	{
		Books books = new Books("Springboot in Deep",4500,"Backend Development");
		Books books2 = new Books("Django in Deep",5500,"Backend Development");
		Books books3 = new Books("Css in Deep",3300,"Frontend Development");
		List<Books> booksList = new ArrayList<>() ;
		booksList.add(books) ;
		booksList.add(books2) ;
		booksList.add(books3) ;
		Mockito.when(sampleDao.findAllBooks()).thenReturn(booksList) ;
		Assertions.assertEquals(booksList,sampleDao.findAllBooks());
		Mockito.verify(sampleDao).findAllBooks() ;
	}

	@Test
	void test_Customer_By_Id()
	{
		Customers customers2 = new Customers("Mayank" ,"Rana" , Collections.emptyList(),"ahilya@gmail.com") ;
		int id = 100;
		Mockito.when(sampleDao.findById(id)).thenReturn(customers2) ;
		Assertions.assertEquals(customers2,sampleDao.findById(id));
		Mockito.verify(sampleDao).findById(id) ;
	}

	@Test
	void test_Book_By_Id()
	{
		Books books = new Books("MERN STACK from scratch",7600,"Full Stack Development") ;
		int id = 200;
		Mockito.when(sampleDao.findbookID(id)).thenReturn(books) ;
		Assertions.assertEquals(books,sampleDao.findbookID(id));
		Mockito.verify(sampleDao).findbookID(id) ;
	}
}
