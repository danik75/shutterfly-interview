package com.shutterfly.interview.product.service;

import com.shutterfly.interview.product.dto.BookDTO;
import com.shutterfly.interview.product.model.Book;
import com.shutterfly.interview.product.respository.BookRepository;
import com.shutterfly.interview.product.service.mapper.BookMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    private final BookRepository repository;

    private final BookMapper mapper;

    public BookService(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void addProduct(BookDTO c){
        this.repository.save(mapper.fromDTO(c));
    }


}
