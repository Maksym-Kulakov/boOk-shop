package com.shop.book.model.dto;

import com.shop.book.model.Author;
import com.shop.book.model.Genre;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class BookResponseDto {
    private Long id;
    private String title;
    private List<Author> authors;
    private Genre genre;
    private int pages;
    private String description;
    private String country;
    private BigDecimal price;
    private Boolean inStock;
}
