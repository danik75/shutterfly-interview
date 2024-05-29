package com.shutterfly.interview.product.controller;

import com.shutterfly.interview.product.dto.BookDTO;
import com.shutterfly.interview.product.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody BookDTO product){
        this.bookService.addProduct(product);
    }

    @GetMapping("")
    public List<BookDTO> findAll(){
        return null;
    }

}
