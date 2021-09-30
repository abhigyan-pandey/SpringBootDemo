package com.example.springboot.bookstore.bookstorewebapp.service;

import com.example.springboot.bookstore.bookstorewebapp.entity.Books;
import com.example.springboot.bookstore.bookstorewebapp.entity.Customers;
import com.example.springboot.bookstore.bookstorewebapp.entity.Issues;

import java.util.List;

public interface CustomerService
{
    public List<Customers> findAllCustomer() ;
    public List<Books> findAllBooks() ;
    public Customers findById(int customerId);
    public Books findBookId(int bookId);
    public void addNewCustomer(Customers customers) ;
    public void addnewBooks(Books books) ;
    public void deleteCustomer(int customerId) ;
    public void deleteBook(int bookId) ;
    public Customers saveCustomer(Customers customers , int customerid) ;
    public Books saveBook(Books books,int bookid) ;
    public void saveCustomer(Customers customers) ;
    public void saveBook(Books books) ;
    public void saveIssue(Issues issues) ;
}
