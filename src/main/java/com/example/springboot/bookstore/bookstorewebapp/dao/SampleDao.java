package com.example.springboot.bookstore.bookstorewebapp.dao;

import com.example.springboot.bookstore.bookstorewebapp.entity.Books;
import com.example.springboot.bookstore.bookstorewebapp.entity.Customers;
import com.example.springboot.bookstore.bookstorewebapp.entity.Issues;

import java.util.List;

public interface SampleDao
{
    public List<Customers> findAllCustomer() ;
    public List<Books> findAllBooks() ;
    public Customers findById(int customerId);
    public void addNewCustomer(Customers customers) ;
    public void addnewBooks(Books books) ;
    public Books findbookID(int bookId);
    public void deleteCustomer(int customerId) ;
    public void deleteBook(int bookId) ;
    public void saveCustomer(Customers customers);
    public void saveBook(Books books) ;
    public Customers saveCustomer(Customers customers ,int customerid) ;
    public Books saveBook(Books books ,int bookid) ;

    void saveIssue(Issues issues);
}
