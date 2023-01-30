package com.shop.book.repository;

import com.shop.book.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>,
        JpaSpecificationExecutor<Book> {
    List<Book> getBooksByPriceBetween(Pageable pageable, BigDecimal from, BigDecimal to);
}
