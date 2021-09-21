package com.example.springboot.bookstore.bookstorewebapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.logging.Logger;

@Entity
@Table(name = "books")
@Data
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

    @Column(name = "genre")
    private String genre ;

    public Books(String bookName, int bookPrice, String genre) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.genre = genre;
    }

    public Books() {}
}
