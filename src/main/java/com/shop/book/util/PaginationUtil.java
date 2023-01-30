package com.shop.book.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class PaginationUtil {
    private static final String SYMBOL_BETWEEN_ATTRIBUTES = ":";
    private static final String SYMBOL_BETWEEN_PARAMETERS = ";";
    private static final int INDEX_OF_DIRECTION_VALUE = 0;
    public static final int INDEX_OF_FIELD_NAME = 1;

    public static PageRequest getPageRequest(Integer page, Integer count, String sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sortBy.contains(SYMBOL_BETWEEN_ATTRIBUTES)) {
            String[] sortingFields = sortBy.split(SYMBOL_BETWEEN_PARAMETERS);
            for (String field : sortingFields) {
                Sort.Order order;
                if (field.contains(SYMBOL_BETWEEN_ATTRIBUTES)) {
                    String[] fieldAndDirections = field.split(SYMBOL_BETWEEN_ATTRIBUTES);
                    order = new Sort.Order(Sort.Direction.valueOf(
                            fieldAndDirections[INDEX_OF_FIELD_NAME]),
                            fieldAndDirections[INDEX_OF_DIRECTION_VALUE]);
                } else {
                    order = new Sort.Order(Sort.Direction.ASC, sortBy);
                }
                orders.add(order);
            }
        } else {
            Sort.Order order = new Sort.Order(Sort.Direction.ASC, sortBy);
            orders.add(order);
        }
        Sort sort = Sort.by(orders);
        return PageRequest.of(page, count, sort);
    }
}
