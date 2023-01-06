package com.shop.book.controller;

import com.shop.book.model.dto.AuthorRequestDto;
import com.shop.book.model.dto.AuthorResponseDto;
import com.shop.book.model.dto.mapper.impl.AuthorMapper;
import com.shop.book.service.AuthorService;
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
@RequestMapping("/books/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> create(@RequestBody AuthorRequestDto authorRequestDto) {
        return new ResponseEntity<>(authorMapper.toDto(authorService.
                create(authorMapper.toModel(authorRequestDto))), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(authorMapper.toDto(authorService.get(id)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAll() {
        return ResponseEntity.ok(authorService.getAll()
                .stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> update(@PathVariable("id") Long id,
                                                    @RequestBody AuthorRequestDto authorRequestDto) {
    return ResponseEntity.ok(authorMapper.toDto(authorService
            .update(id, authorMapper.toModel(authorRequestDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        authorService.delete(id);
        return ResponseEntity.ok("Success, deleted author by id " + id);
    }
}
