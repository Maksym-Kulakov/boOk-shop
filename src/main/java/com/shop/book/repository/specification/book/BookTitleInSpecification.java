package com.shop.book.repository.specification.book;

import com.shop.book.model.Book;
import com.shop.book.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.CriteriaBuilder;

@Component
public class BookTitleInSpecification implements SpecificationProvider<Book> {
    public static final String FILTER_KEY = "titleIn";
    public static final String FIELD_NAME = "title";

    @Override
    public Specification<Book> getSpecification(String[] titles) {
        return ((root, query, cb) -> {
            CriteriaBuilder.In<String> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : titles) {
                predicate.value(value);
            }
            return cb.and(predicate);
        });
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
