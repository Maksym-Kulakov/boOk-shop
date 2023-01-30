package com.shop.book.controller;

import com.shop.book.model.dto.book.BookRequestDto;
import com.shop.book.model.dto.book.BookResponseDto;
import com.shop.book.model.dto.mapper.impl.BookMapper;
import com.shop.book.service.BookService;
import com.shop.book.util.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<List<BookResponseDto>> getAll(Authentication authentication) {
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

    @GetMapping("/byPrice")
    @ApiOperation(value = "to get all Products from DB between min "
            + "and max PRICE value with sorting & pagination ability")
    public List<BookResponseDto> getByPrice(@RequestParam(defaultValue = "3")
                                            Integer count,
                                            @RequestParam(defaultValue = "0")
                                            Integer page,
                                            @RequestParam(defaultValue = "0.00")
                                            BigDecimal from,
                                            @RequestParam(defaultValue = "10000.00")
                                            BigDecimal to,
                                            @RequestParam(defaultValue = "id")
                                            String sortBy) {
        PageRequest pageRequest = PaginationUtil.getPageRequest(page, count, sortBy);
        return bookService.getBooksByPriceBetween(pageRequest, from, to)
                .stream().map(bookMapper::toDto).toList();
    }

    @GetMapping("/crit")
    public List<BookResponseDto> findAllByCriteria(@RequestParam Map<String, String> params) {
        return bookService.findAllByCriteria(params)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }
}
