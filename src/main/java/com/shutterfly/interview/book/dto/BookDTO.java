package com.shutterfly.interview.book.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class BookDTO {

    public BookDTO(Long id, String isbn, String title, String authorName, String publisherName, LocalDateTime publicationDate) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.publicationDate = publicationDate;
    }

    private Long id;

    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    private String authorName;

    private String publisherName;

    private LocalDateTime publicationDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }
}
