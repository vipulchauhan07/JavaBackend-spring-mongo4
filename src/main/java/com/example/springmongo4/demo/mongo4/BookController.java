package com.example.springmongo4.demo.mongo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/getBookByAuthor")
    public List<Book> getBook(@RequestParam(value="name") String name) {
           return bookRepository.findByAuthorName(name);
    }

    @PostMapping("/insertBook")
    public void insertBook(@RequestBody CreateRequest request) {

        Book book = new Book(request.getName(), request.getAuthorName(), request.getCost());
        bookRepository.save(book);
    }
}
