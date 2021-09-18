package com.example.springboot.bookstore.bookstorewebapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@IdClass(IssueId.class)
@Table(name = "issues")
@Data
public class Issues
{
    @Id
    private int customerId ;

    @Id
    private int bookId ;

    public Issues()
    {
        System.out.println("Default Constructor Called");
    }

}
