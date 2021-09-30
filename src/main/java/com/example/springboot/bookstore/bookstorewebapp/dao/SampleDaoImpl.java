package com.example.springboot.bookstore.bookstorewebapp.dao;

import com.example.springboot.bookstore.bookstorewebapp.entity.Books;
import com.example.springboot.bookstore.bookstorewebapp.entity.Customers;
import com.example.springboot.bookstore.bookstorewebapp.entity.Issues;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.awt.print.Book;
import java.util.List;

@Repository
public class SampleDaoImpl implements SampleDao
{
    private final EntityManager entityManager ;

    @Autowired
    public SampleDaoImpl(EntityManager entityManager1)
    {
        entityManager = entityManager1 ;
    }

    @Override
    public List<Customers> findAllCustomer()
    {
        Session session = entityManager.unwrap(Session.class) ;
        Query<Customers> query = session.createQuery("from Customers order by firstName", Customers.class) ;
        return query.getResultList() ;
    }

    @Override
    public List<Books> findAllBooks()
    {
        Session session = entityManager.unwrap(Session.class) ;
        Query<Books> query = session.createQuery("from Books order by bookName", Books.class) ;
        return query.getResultList() ;
    }

    @Override
    public Customers findById(int customerId)
    {
        Session session =entityManager.unwrap(Session.class) ;
        return session.get(Customers.class,customerId) ;
    }

    @Override
    public void addNewCustomer(Customers customers)
    {
        Session session = entityManager.unwrap(Session.class) ;
        session.saveOrUpdate(customers);
    }

    @Override
    public void addnewBooks(Books books)
    {
        Session session = entityManager.unwrap(Session.class) ;
        session.saveOrUpdate(books);
    }

    @Override
    public Books findbookID(int bookId)
    {
        Session session =entityManager.unwrap(Session.class) ;
        return session.get(Books.class,bookId) ;
    }

    @Override
    public void deleteCustomer(int customerId)
    {
        Session session =entityManager.unwrap(Session.class) ;
        Query<Customers> query = session.createQuery("delete from Customers where id=:customerId") ;
        query.setParameter("customerId",customerId) ;
        query.executeUpdate() ;
    }

    @Override
    public void deleteBook(int bookId)
    {
        Session session =entityManager.unwrap(Session.class) ;
        Query<Books> query = session.createQuery("delete from Books where book_id=:bookId") ;
        query.setParameter("bookId",bookId) ;
        query.executeUpdate() ;
    }

    @Override
    public void saveCustomer(Customers customers)
    {
        Session session = entityManager.unwrap(Session.class) ;
        session.saveOrUpdate(customers);
    }

    @Override
    public void saveBook(Books books)
    {
        Session session = entityManager.unwrap(Session.class) ;
        session.saveOrUpdate(books);
    }

    @Override
    public Customers saveCustomer(Customers customers, int customerid) {
        Session session = entityManager.unwrap(Session.class) ;
        Customers originalCustomer = findById(customerid) ;
        originalCustomer.setFirstName(customers.getFirstName());
        originalCustomer.setLastName(customers.getLastName());
        originalCustomer.setEmail(customers.getEmail());
        session.save(originalCustomer);
        customers.setId(originalCustomer.getId());
        return customers ;
    }

    @Override
    public Books saveBook(Books books, int bookid) {
        Session session = entityManager.unwrap(Session.class) ;
        Books books1 = findbookID(bookid) ;
        books1.setBookName(books.getBookName());
        books1.setBookPrice(books.getBookPrice());
        books1.setGenre(books.getGenre());
        session.saveOrUpdate(books1);
        books.setBookId(books1.getBookId());
        return books ;
    }

    @Override
    public void saveIssue(Issues issues)
    {
        Session session = entityManager.unwrap(Session.class) ;
        session.saveOrUpdate(issues);
    }
}
