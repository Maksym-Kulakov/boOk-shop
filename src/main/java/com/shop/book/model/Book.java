package com.shop.book.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book extends Product {
    private String title;
    @ManyToMany
    private List<Author> authors;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private int pages;
    private String description;
}
