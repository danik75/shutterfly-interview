package com.shutterfly.interview.product.controller;

import com.shutterfly.interview.product.dto.BookDTO;
import com.shutterfly.interview.product.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("")
    public void create(@Valid @RequestBody BookDTO product){
        this.bookService.addBook(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("")
    public void update(@Valid @RequestBody BookDTO product){
        this.bookService.updateBook(product);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.bookService.deleteBook(id);
    }


    @GetMapping("")
    public List<BookDTO> findAll(){
        return this.bookService.findAllBooks();
    }

}
