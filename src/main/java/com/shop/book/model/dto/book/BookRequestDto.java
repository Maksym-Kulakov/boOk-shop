package com.shop.book.model.dto.book;

import com.shop.book.model.Author;
import com.shop.book.model.Genre;
import lombok.Data;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.List;

@Data
public class BookRequestDto {
    private String title;
    private long[] authorsId;
    private String genre;
    private int pages;
    private String description;
    private String country;
    private BigDecimal price;
    private Boolean inStock;
}
