package com.example.springboot.bookstore.bookstorewebapp.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class IssueId implements Serializable
{
    @Column(name = "book_Id")
    private int bookId ;

    public IssueId()
    {
        System.out.println("Default Constructor Called");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Column(name = "customer_Id")
    private int customerId ;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
