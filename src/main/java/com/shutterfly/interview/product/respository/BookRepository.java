package com.shutterfly.interview.product.respository;

import com.shutterfly.interview.product.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
