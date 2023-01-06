package com.shop.book.service;


import com.shop.book.model.Book;
import java.util.List;

public interface BookService {
    Book create(Book book);

    Book get(Long id);

    List<Book> getAll();

    Book update(Long id, Book book);

    void delete(Long id);
}
