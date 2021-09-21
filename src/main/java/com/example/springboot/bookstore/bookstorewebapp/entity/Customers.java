package com.example.springboot.bookstore.bookstorewebapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "fname")
    private String firstName ;

    @Column(name = "lname")
    private String lastName ;

    @ManyToMany(fetch = FetchType.LAZY ,
                cascade =
                        {
                            CascadeType.MERGE ,
                            CascadeType.PERSIST,
                            CascadeType.DETACH ,
                            CascadeType.DETACH
                        }
    )
    @JoinTable(name = "issues" ,
            joinColumns = @JoinColumn(name = "customer_Id"),
            inverseJoinColumns =@JoinColumn(name = "book_Id")
    )
    private List<Books> booksList ;

    public Customers() {}

    public Customers(String firstName, String lastName, List<Books> booksList, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.booksList = booksList;
        this.email = email;
    }

    @Column(name = "email")
    private String email ;
}
