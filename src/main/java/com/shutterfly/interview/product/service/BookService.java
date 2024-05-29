package com.shutterfly.interview.product.service;

import com.shutterfly.interview.product.dto.BookDTO;
import com.shutterfly.interview.product.respository.BookRepository;
import com.shutterfly.interview.product.service.mapper.BookMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class BookService {

    private final BookRepository repository;

    private final BookMapper mapper;

    public BookService(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void addBook(BookDTO book){
        this.repository.save(mapper.fromDTO(book));
    }


    public void updateBook(BookDTO book) {
        this.repository.save(mapper.fromDTO(book));
    }

    public void deleteBook(Long id) {
        this.repository.deleteById(id);
    }

    public List<BookDTO> findAllBooks() {
        return StreamSupport.stream(this.repository.findAll().spliterator(), false).map(mapper::toDTO).collect(Collectors.toList());
    }
}
