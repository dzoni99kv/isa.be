package com.example.TaskApp.mappers;

import com.example.TaskApp.entities.Cart;
import com.example.TaskApp.models.CartModel;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {
    public static Cart toEntity(CartModel model) {
        Cart cart = new Cart();
        cart.setId(model.getId());
        cart.setCreatedAt(model.getCreatedAt());

        // Ensure that the user ID is set correctly
        if (model.getUser() != null) {
            cart.setUser(UserMapper.toEntity(model.getUser()));
        }

        return cart;
    }

    public static CartModel toModel(Cart entity) {
        CartModel cartModel = new CartModel();
        cartModel.setId(entity.getId());
        cartModel.setCreatedAt(entity.getCreatedAt());
        cartModel.setUser(UserMapper.toModel(entity.getUser()));

        return cartModel;
    }

    public static List<CartModel> toModelList(List<Cart> entities) {
        return entities.stream().map(CartMapper::toModel).collect(Collectors.toList());
    }
}