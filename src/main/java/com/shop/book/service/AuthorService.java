package com.shop.book.service;


import com.shop.book.model.Author;
import java.util.List;

public interface AuthorService {
    Author create(Author author);

    Author get(Long id);

    List<Author> getAll();

    Author update(Long id, Author author);

    void delete(Long id);
}
