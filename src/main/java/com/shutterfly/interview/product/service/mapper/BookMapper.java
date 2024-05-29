package com.shutterfly.interview.product.service.mapper;

import com.shutterfly.interview.mapper.Mapper;
import com.shutterfly.interview.product.dto.BookDTO;
import com.shutterfly.interview.product.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<Book, BookDTO> {

    @Override
    public BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(),book.getIsbn(), book.getTitle(), book.getAuthorName(), book.getPublisherName(), book.getPublicationDate() );
    }

    @Override
    public Book fromDTO(BookDTO dto) {
        return new Book(dto.getId(), dto.getIsbn(), dto.getTitle(), dto.getAuthorName(), dto.getPublisherName(), dto.getPublicationDate());
    }
}
