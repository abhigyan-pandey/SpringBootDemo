package com.example.springboot.bookstore.bookstorewebapp.dto;

import java.util.List;

public class CustomerDto
{
    private int id ;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", booksList=" + booksList +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String firstName ;
    private String lastName ;

    public List<BookDto> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<BookDto> booksList) {
        this.booksList = booksList;
    }

    private String email ;
    private List<BookDto> booksList ;

    public CustomerDto()
    {
        System.out.println("Default Constructor Called");
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
