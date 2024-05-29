package com.shutterfly.interview.book.service;

import com.shutterfly.interview.book.dto.BookDTO;
import com.shutterfly.interview.book.model.Book;
import com.shutterfly.interview.book.respository.BookRepository;
import com.shutterfly.interview.book.service.mapper.BookMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

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

    public BookDTO addBook(BookDTO book){
        return mapper.toDTO(this.repository.save(mapper.fromDTO(book)));
    }

    public BookDTO updateBook(BookDTO book) {
        if (book == null || book.getId() == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Id must be provided"
            );
        }
        return mapper.toDTO(this.repository.save(mapper.fromDTO(book)));
    }

    public void deleteBook(Long id) {
        if (id == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Id must be provided"
            );
        }

        this.repository.deleteById(id);
    }

    public List<BookDTO> findAllBooks(String author) {
        if (author!=null){
            return this.repository.findAllFilterByAuthor(author).stream().map(mapper::toDTO).collect(Collectors.toList());
        }
        else {
            return StreamSupport.stream(this.repository.findAll().spliterator(), false).map(mapper::toDTO).collect(Collectors.toList());
        }
    }
    public BookDTO getByIsbn(String isbn) {
        Book byIsbn = this.repository.getByIsbn(isbn);
        BookDTO result = null;
        if (byIsbn!=null) {
            result = mapper.toDTO(byIsbn);
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return result;

    }
}
