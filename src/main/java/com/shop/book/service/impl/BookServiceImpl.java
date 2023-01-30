package com.shop.book.service.impl;
import com.shop.book.model.Book;
import com.shop.book.repository.BookRepository;
import com.shop.book.repository.specification.BookSpecificationManager;
import com.shop.book.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookSpecificationManager bookSpecificationManager;

    public BookServiceImpl(BookRepository bookRepository,
                           BookSpecificationManager bookSpecificationManager) {
        this.bookRepository = bookRepository;
        this.bookSpecificationManager = bookSpecificationManager;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book get(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(Long id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByPriceBetween(Pageable pageable,
                                             BigDecimal from, BigDecimal to) {
        return bookRepository.getBooksByPriceBetween(pageable, from, to);
    }

    @Override
    public List<Book> findAllByCriteria(Map<String, String> params) {
        Specification<Book> specification = null;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            Specification<Book> sp = bookSpecificationManager.get(entry.getKey(),
                    entry.getValue().split(","));
            specification = (specification == null) ? Specification.where(sp) : specification.and(sp);
        }
        return bookRepository.findAll(specification);
    }
}
