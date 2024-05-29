package com.shutterfly.interview.book.controller;

import com.shutterfly.interview.book.dto.BookDTO;
import com.shutterfly.interview.book.service.BookService;
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
    public BookDTO create(@Valid @RequestBody BookDTO product){
        return this.bookService.addBook(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("")
    public BookDTO update(@Valid @RequestBody BookDTO product){
        return this.bookService.updateBook(product);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.bookService.deleteBook(id);
    }


    @GetMapping("")
    public List<BookDTO> findAll(@RequestParam(required = false) String author){
        return this.bookService.findAllBooks(author);
    }

    @GetMapping("/{isbn}")
    public BookDTO getBookByIsbn(@PathVariable String isbn){
        return this.bookService.getByIsbn(isbn);
    }

}
