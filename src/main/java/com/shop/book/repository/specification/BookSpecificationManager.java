package com.shop.book.repository.specification;

import com.shop.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BookSpecificationManager implements SpecificationManager<Book>{
    private final Map<String, SpecificationProvider<Book>> providersMap;

    @Autowired
    public BookSpecificationManager(List<SpecificationProvider<Book>> bookSpecifications) {
        this.providersMap = bookSpecifications
                .stream()
                .collect(Collectors.toMap(SpecificationProvider::getFilterKey,
                        Function.identity()));
    }

    @Override
    public Specification<Book> get(String filterKey, String[] params) {
        if (!providersMap.containsKey(filterKey)) {
            throw new RuntimeException("Key " + filterKey + "is not supported for filtering");
        }
        return providersMap.get(filterKey).getSpecification(params);
    }
}
