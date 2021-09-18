package com.example.springboot.bookstore.bookstorewebapp.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class IssueId implements Serializable
{
    @Column(name = "book_Id")
    private int bookId ;

    public IssueId()
    {
        System.out.println("Default Constructor Called");
    }

    @Column(name = "customer_Id")
    private int customerId ;
}
