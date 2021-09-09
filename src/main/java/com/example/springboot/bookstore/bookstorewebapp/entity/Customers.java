package com.example.springboot.bookstore.bookstorewebapp.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "fname")
    private String firstName ;

    @Column(name = "lname")
    private String lastName ;

    public Customers(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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

    public List<Books> getBooksList()
    {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Customers()
    {
        System.out.println("Default Constructor Called");
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", booksList=" + booksList +
                ", email='" + email + '\'' +
                '}';
    }

    @Column(name = "email")
    private String email ;
}
