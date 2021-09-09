package com.example.springboot.bookstore.bookstorewebapp.dto;

import com.example.springboot.bookstore.bookstorewebapp.entity.Books;

import java.util.List;

public class CustomerDto
{
    private int id ;

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String firstName ;
    private String lastName ;

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    private String email ;
    private List<Books> booksList ;

    public CustomerDto()
    {
        System.out.println("Default Constructor Called");;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
