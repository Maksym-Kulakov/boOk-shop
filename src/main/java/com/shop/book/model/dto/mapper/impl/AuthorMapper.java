package com.shop.book.model.dto.mapper.impl;

import com.shop.book.model.Author;
import com.shop.book.model.dto.author.AuthorRequestDto;
import com.shop.book.model.dto.author.AuthorResponseDto;
import com.shop.book.model.dto.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper
        implements GenericMapper<AuthorResponseDto, Author, AuthorRequestDto> {
    @Override
    public AuthorResponseDto toDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setName(author.getName());
        authorResponseDto.setSurname(author.getSurname());
        return authorResponseDto;
    }

    @Override
    public Author toModel(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setSurname(authorRequestDto.getSurname());
        return author;
    }
}
