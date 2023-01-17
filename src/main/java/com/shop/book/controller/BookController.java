package com.shop.book.controller;

import com.shop.book.model.dto.book.BookRequestDto;
import com.shop.book.model.dto.book.BookResponseDto;
import com.shop.book.model.dto.mapper.impl.BookMapper;
import com.shop.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> create(@RequestBody BookRequestDto bookRequestDto) {
        return new ResponseEntity<>(bookMapper.toDto(bookService
                .create(bookMapper.toModel(bookRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(bookMapper.toDto(bookService.get(id)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAll() {
        return ResponseEntity.ok(bookService.getAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable("id") Long id,
                                                    @RequestBody BookRequestDto bookRequestDto) {
        return ResponseEntity.ok(bookMapper.toDto(bookService
                .update(id, bookMapper.toModel(bookRequestDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok("Success, deleted book by id " + id);
    }

}
