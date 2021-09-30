package com.example.springboot.bookstore.bookstorewebapp.rest;

import com.example.springboot.bookstore.bookstorewebapp.dto.BookDto;
import com.example.springboot.bookstore.bookstorewebapp.dto.CustomerDto;
import com.example.springboot.bookstore.bookstorewebapp.entity.Books;
import com.example.springboot.bookstore.bookstorewebapp.entity.Customers;
import com.example.springboot.bookstore.bookstorewebapp.exceptions.DataNotFoundException;
import com.example.springboot.bookstore.bookstorewebapp.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestApisController
{
    private final CustomerService customerService ;

    @Autowired
    public RestApisController(CustomerService customerService)
    {
        this.customerService=customerService ;
    }

    @Autowired
    private ModelMapper modelMapper ;

    @GetMapping("/books")
    public Optional<List<BookDto>> booksList()
    {
        return Optional.ofNullable(customerService.findAllBooks().stream().map(books -> modelMapper.map(books, BookDto.class))
                .toList());
    }

    @GetMapping("/customers")
    public Optional<List<CustomerDto>> findAll()
    {
        return Optional.ofNullable(customerService.findAllCustomer().stream().map(customers -> modelMapper.map(
                customers, CustomerDto.class))
                .toList()) ;
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDto> findcustomerById(@PathVariable int customerId)
    {
        Customers customers = customerService.findById(customerId) ;
        Optional<Customers> optionalCustomers = Optional.ofNullable(customers) ;
        if(optionalCustomers.isEmpty())
        {
            throw new DataNotFoundException("No customer data with this ID in the DB") ;
        }
        CustomerDto customerDto = modelMapper.map(customers ,CustomerDto.class) ;
        return  ResponseEntity.ok().body(customerDto) ;
    }
    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDto> findAllBooks(@PathVariable int bookId)
    {
        Books books = customerService.findBookId(bookId) ;
        Optional<Books> optionalBooks = Optional.ofNullable(books) ;
        if(optionalBooks.isEmpty())
        {
            throw new DataNotFoundException("No book data with this ID in the DB") ;
        }
        BookDto bookDto = modelMapper.map(books,BookDto.class) ;
        return  ResponseEntity.ok().body(bookDto) ;
    }

    @PostMapping("/customers")
    public Customers addnewCustomer(@RequestBody Customers customers)
    {
        customers.setId(0) ;
        customerService.addNewCustomer(customers) ;
        return customers ;
    }

    @PostMapping("/books")
    public Books addnewBooks(@RequestBody Books books)
    {
        books.setBookId(0);
        customerService.addnewBooks(books) ;
        return books ;
    }

    @PutMapping("/books/{bookId}")
    public Books updateBooks(@PathVariable  int bookId , @RequestBody Books books)
    {
        customerService.saveBook(books,bookId);
        return books ;
    }

    @PutMapping("/customers/{customerId}")
    public Customers updateCustomers(@PathVariable  int customerId , @RequestBody Customers customers)
    {
         return customerService.saveCustomer(customers , customerId);
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomerData(@PathVariable int customerId)
    {
        Customers customers =  customerService.findById(customerId);
        if(customers == null)
        {
            throw  new DataNotFoundException("Invalid customer-id provided") ;
        }
        customerService.deleteCustomer(customerId);
        return ("Deleted the customer with ID ==" +customerId );
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBooks(@PathVariable int bookId)
    {
        Books books = customerService.findBookId(bookId);
        if(books == null)
        {
            throw new DataNotFoundException("Invalid Book-Id provided") ;
        }
        customerService.deleteBook(bookId);
        return ("Deleted the book with ID ==" +bookId );
    }
}
