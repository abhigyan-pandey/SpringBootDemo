package com.example.springboot.bookstore.bookstorewebapp.entity;

import javax.persistence.*;

@Entity
@IdClass(IssueId.class)
@Table(name = "issues")
public class Issues
{
    @Id
    private int customerId ;

    @Id
    private int bookId ;

    public Issues(int customerId, int bookId) {
        this.customerId = customerId;
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Issues()
    {
        System.out.println("Default Constructor Called");
    }

}
