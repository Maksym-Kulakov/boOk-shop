package com.shop.book.model.dto.shoppingcart;

import com.shop.book.model.Book;
import com.shop.book.model.User;
import lombok.Data;
import java.util.List;

@Data
public class ShoppingCartResponseDto {
    private Long id;
    private List<Book> books;
    private User user;
}
