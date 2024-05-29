package com.shutterfly.interview.product.respository;

import com.shutterfly.interview.product.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.authorName = ?1")
    List<Book> findAllFilterByAuthor(String authorName);

    @Query("SELECT b FROM Book b WHERE b.isbn = ?1")
    Book getByIsbn(String isbn);
}
