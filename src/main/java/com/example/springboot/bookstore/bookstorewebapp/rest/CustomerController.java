package com.example.springboot.bookstore.bookstorewebapp.rest;

import com.example.springboot.bookstore.bookstorewebapp.dto.BookDto;
import com.example.springboot.bookstore.bookstorewebapp.dto.CustomerDto;
import com.example.springboot.bookstore.bookstorewebapp.entity.Books;
import com.example.springboot.bookstore.bookstorewebapp.entity.Customers;
import com.example.springboot.bookstore.bookstorewebapp.entity.Issues;
import com.example.springboot.bookstore.bookstorewebapp.exceptions.DataNotFoundException;
import com.example.springboot.bookstore.bookstorewebapp.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class CustomerController
{
    private CustomerService customerService ;

    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService ;
    }

    @Autowired
    private ModelMapper modelMapper ;

    private Logger logger =Logger.getLogger(CustomerController.class.getName()) ;


    @RequestMapping("/")
    public String getHomepage()
    {
        return "homepage" ;
    }

    @GetMapping("/showCustomerList")
    public String customerList(Model model)
    {
        List<CustomerDto> customerDtoList = customerService.findAllCustomer().stream().
                                            map(customers -> modelMapper.map(customers, CustomerDto.class))
                                            .collect(Collectors.toList()) ;
        model.addAttribute("theCustomerList",customerDtoList) ;
        String message = customerDtoList.stream().map(Object::toString).collect(Collectors.joining(", ")) ;
        logger.log(Level.INFO,message);
        return "customer-list-view" ;
    }

    @GetMapping("/showBookList")
    public String bookList(Model model)
    {
        List<BookDto> bookDtoList =customerService.findAllBooks().stream()
                                    .map(books -> modelMapper.map(books,BookDto.class))
                                    .collect(Collectors.toList());
        model.addAttribute("theBookList",bookDtoList) ;
        String message = bookDtoList.stream().map(Object::toString).collect(Collectors.joining(", ")) ;
        logger.log(Level.INFO,message);
        return "book-list-view" ;
    }

    @GetMapping("/addCustomerForm")
    public String addCustomerForm(Model model)
    {
        Customers customers = new Customers() ;
        model.addAttribute("customer",customers) ;
        return "customer-register-form" ;
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customers customers)
    {
        customerService.saveCustomer(customers);
        return "redirect:/" ;
    }

    @GetMapping("/addBookForm")
    public String addBookForm(Model model)
    {
        Books books = new Books() ;
        model.addAttribute("book",books) ;
        return "book-register-form" ;
    }

    @PostMapping("/saveBook")
    public String saveCustomer(@ModelAttribute("book") Books books)
    {
        customerService.saveBook(books);
        return "redirect:/" ;
    }

    @GetMapping("/customerDelete")
    public String deleteform(@RequestParam("customerId") int Id)
    {
        Customers customers = customerService.findById(Id) ;
        if(customers == null)
        {
            throw new DataNotFoundException("No respective is Id there is the DB");
        }
        customerService.deleteCustomer(Id);
        return  "redirect:/" ;
    }

    @GetMapping("/bookDelete")
    public String deleteBookform(@RequestParam("customerId") int Id)
    {
        Books books = customerService.findBookId(Id) ;
        if(books == null)
        {
            throw new RuntimeException("No respective is Id there is the DB");
        }
        customerService.deleteBook(Id);
        return  "redirect:/" ;
    }

    @GetMapping("/customerUpdate")
    public String updateCustomerform(@RequestParam("customerId") int Id , Model model)
    {
        Customers customers = customerService.findById(Id) ;
        if(customers == null)
        {
            throw new RuntimeException("No respective is Id there is the DB");
        }
        model.addAttribute("customer",customers) ;
        return  "customer-register-form";
    }

    @GetMapping("/bookUpdate")
    public String updateBookform(@RequestParam("customerId") int Id , Model model)
    {
        Books books = customerService.findBookId(Id) ;
        if(books == null)
        {
            throw new DataNotFoundException("No respective is Id there is the DB");
        }
        model.addAttribute("book",books) ;
        return  "book-register-form";
    }

    @GetMapping("/createIssue")
    public String createanIssue(Model model)
    {
        Issues issues = new Issues() ;
        model.addAttribute("issue",issues) ;
        return "create-issue" ;
    }

    @PostMapping("/saveIssue")
    public String saveCustomer(@ModelAttribute("issue") Issues issues)
    {
        logger.info("HERE THIS WILL UPDATED ");
        customerService.saveIssue(issues);
        return "redirect:/" ;
    }
}
