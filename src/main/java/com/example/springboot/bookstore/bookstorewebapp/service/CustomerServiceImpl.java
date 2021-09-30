package com.example.springboot.bookstore.bookstorewebapp.service;

import com.example.springboot.bookstore.bookstorewebapp.dao.SampleDao;
import com.example.springboot.bookstore.bookstorewebapp.entity.Books;
import com.example.springboot.bookstore.bookstorewebapp.entity.Customers;
import com.example.springboot.bookstore.bookstorewebapp.entity.Issues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
    private SampleDao sampleDao ;

    @Autowired
    public CustomerServiceImpl(SampleDao sampleDao)
    {
        this.sampleDao = sampleDao ;
    }

    @Override
    public List<Customers> findAllCustomer()
    {
        return sampleDao.findAllCustomer() ;
    }

    @Override
    public List<Books> findAllBooks()
    {
        return sampleDao.findAllBooks() ;
    }

    @Override
    public Customers findById(int customerId) {
        return sampleDao.findById(customerId);
    }

    @Override
    public Books findBookId(int bookId) {
        return sampleDao.findbookID(bookId) ;
    }

    @Override
    public void addNewCustomer(Customers customers) {
         sampleDao.addNewCustomer(customers) ;
    }

    @Override
    public void addnewBooks(Books books) {
        sampleDao.addnewBooks(books);
    }

    @Override
    public void deleteCustomer(int customerId)
    {
        sampleDao.deleteCustomer(customerId);
    }

    @Override
    public void deleteBook(int bookId)
    {
        sampleDao.deleteBook(bookId);
    }

    @Override
    public Customers saveCustomer(Customers customers, int customerid) {
        return sampleDao.saveCustomer(customers,customerid);
    }

    @Override
    public Books saveBook(Books books, int bookid) {
       return sampleDao.saveBook(books,bookid);
    }

    @Override
    public void saveCustomer(Customers customers)
    {
        sampleDao.saveCustomer(customers);
    }

    @Override
    public void saveBook(Books books)
    {
        sampleDao.saveBook(books);
    }

    @Override
    public void saveIssue(Issues issues)
    {
        sampleDao.saveIssue(issues) ;
    }
}
