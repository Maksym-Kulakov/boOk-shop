package com.shop.book.model.dto.mapper.impl;

import com.shop.book.model.ShoppingCart;
import com.shop.book.model.dto.mapper.GenericMapper;
import com.shop.book.model.dto.shoppingcart.ShoppingCartRequestDto;
import com.shop.book.model.dto.shoppingcart.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper implements GenericMapper<ShoppingCartResponseDto,
        ShoppingCart, ShoppingCartRequestDto> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUser(shoppingCart.getUser());
        responseDto.setBooks(shoppingCart.getBooks());
        return responseDto;
    }

    @Override
    public ShoppingCart toModel(ShoppingCartRequestDto requestDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(requestDto.getUser());
        shoppingCart.setBooks(requestDto.getBooks());
        return shoppingCart;
    }
}
