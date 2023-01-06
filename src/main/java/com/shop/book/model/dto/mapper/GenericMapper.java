package com.shop.book.model.dto.mapper;

public interface GenericMapper<T, V, U> {
    T toDto(V v);

    V toModel(U u);
}
