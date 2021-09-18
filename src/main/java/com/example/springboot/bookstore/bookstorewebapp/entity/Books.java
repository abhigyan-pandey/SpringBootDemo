package com.example.springboot.bookstore.bookstorewebapp.entity;

import javax.persistence.*;
import java.util.logging.Logger;

@Entity
@Table(name = "books")
public class Books
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId ;

    @Column(name = "book_name")
    private String bookName ;

    @Column(name = "price")
    private int bookPrice ;

    public Books(String bookName, int bookPrice, String genre) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.genre = genre;
    }

    @Column(name = "genre")
    private String genre ;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Books()
    {
    }
}
