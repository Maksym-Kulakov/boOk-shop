package com.shop.book.service;


import com.shop.book.model.Book;
import org.springframework.data.domain.Pageable;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BookService {
    Book create(Book book);

    Book get(Long id);

    List<Book> getAll();

    Book update(Long id, Book book);

    void delete(Long id);

    List<Book> getBooksByPriceBetween(Pageable pageable, BigDecimal from, BigDecimal to);

    List<Book> findAllByCriteria(Map<String, String> params);
}
