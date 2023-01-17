package com.shop.book.model.dto.mapper.impl;

import com.shop.book.model.Author;
import com.shop.book.model.Book;
import com.shop.book.model.Genre;
import com.shop.book.model.dto.book.BookRequestDto;
import com.shop.book.model.dto.book.BookResponseDto;
import com.shop.book.model.dto.mapper.GenericMapper;
import com.shop.book.service.AuthorService;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class BookMapper
        implements GenericMapper<BookResponseDto, Book, BookRequestDto> {
    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public BookResponseDto toDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setAuthors(book.getAuthors());
        bookResponseDto.setCountry(book.getCountry());
        bookResponseDto.setGenre(book.getGenre());
        bookResponseDto.setPrice(book.getPrice());
        bookResponseDto.setPages(book.getPages());
        bookResponseDto.setDescription(book.getDescription());
        bookResponseDto.setInStock(book.getInStock());
        return bookResponseDto;
    }

    @Override
    public Book toModel(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        List<Long> authorsIds = Arrays.stream(bookRequestDto.getAuthorsId()).boxed().toList();
        List<Author> authors = authorsIds.stream().map(authorService::get).toList();
        book.setAuthors(authors);
        book.setCountry(bookRequestDto.getCountry());
        book.setGenre(Genre.valueOf(bookRequestDto.getGenre().toUpperCase()));
        book.setPrice(bookRequestDto.getPrice());
        book.setPages(bookRequestDto.getPages());
        book.setDescription(bookRequestDto.getDescription());
        book.setInStock(bookRequestDto.getInStock());
        return book;
    }
}
