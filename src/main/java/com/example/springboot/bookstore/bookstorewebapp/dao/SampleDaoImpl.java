package com.example.springboot.bookstore.bookstorewebapp.dao;

import com.example.springboot.bookstore.bookstorewebapp.entity.Books;
import com.example.springboot.bookstore.bookstorewebapp.entity.Customers;
import com.example.springboot.bookstore.bookstorewebapp.entity.Issues;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class SampleDaoImpl implements SampleDao
{
    private EntityManager entityManager ;
    private Logger logger = Logger.getLogger(SampleDaoImpl.class.getName()) ;

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
        List<Customers> samplesList = query.getResultList() ;
        logger.info("SIZE OF LIST IS "+samplesList.size());
        return samplesList ;
    }

    @Override
    public List<Books> findAllBooks()
    {
        Session session = entityManager.unwrap(Session.class) ;
        Query<Books> query = session.createQuery("from Books order by bookName", Books.class) ;
        List<Books> samplesList = query.getResultList() ;
        logger.info("SIZE OF LIST IS "+samplesList.size());
        return samplesList ;
    }

    @Override
    public Customers findById(int customerId)
    {
        Session session =entityManager.unwrap(Session.class) ;
        Customers customers =session.get(Customers.class,customerId) ;
        logger.info("IN FIND ID FUNCTION "+customers);
        return customers ;
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
        Books books =session.get(Books.class,bookId) ;
        return books;
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
        logger.info("This customer will be updated"+customers);
        session.saveOrUpdate(customers);
    }

    @Override
    public void saveBook(Books books)
    {
        Session session = entityManager.unwrap(Session.class) ;
        session.saveOrUpdate(books);
    }

    @Override
    public void saveIssue(Issues issues)
    {
        Session session = entityManager.unwrap(Session.class) ;
        session.saveOrUpdate(issues);
    }
}