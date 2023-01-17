package com.shop.book.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book extends Product {
    private String title;
    @ManyToMany
    private List<Author> authors;
    @JoinTable(name = "books_authors",
    joinColumns = @JoinColumn(name = "book_id",
            referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "authors_id",
            referencedColumnName = "id"))
    @Enumerated(value = EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;
    private int pages;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages
                && Objects.equals(title, book.title)
                && Objects.equals(authors, book.authors)
                && genre == book.genre
                && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, authors, genre, pages, description);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", genre=" + genre +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                '}';
    }
}
