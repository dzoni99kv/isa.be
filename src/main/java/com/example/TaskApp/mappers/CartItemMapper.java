package com.example.TaskApp.mappers;

import com.example.TaskApp.entities.CartItem;
import com.example.TaskApp.models.CartItemModel;

import java.util.List;
import java.util.stream.Collectors;

public class CartItemMapper {
    public static CartItem toEntity(CartItemModel model) {
        CartItem cartItem = new CartItem();
        cartItem.setId(model.getId());
        cartItem.setQuantity(model.getQuantity());
        // Assuming you have a way to fetch Product using ProductModel
        cartItem.setProduct(ProductMapper.toEntity(model.getProduct()));
        return cartItem;
    }

    public static CartItemModel toModel(CartItem entity) {
        CartItemModel cartItemModel = new CartItemModel();
        cartItemModel.setId(entity.getId());
        cartItemModel.setQuantity(entity.getQuantity());
        cartItemModel.setProduct(ProductMapper.toModel(entity.getProduct()));
        return cartItemModel;
    }

    public static List<CartItemModel> toModelList(List<CartItem> entities) {
        return entities.stream().map(CartItemMapper::toModel).collect(Collectors.toList());
    }

    public static List<CartItem> toEntityList(List<CartItemModel> models) {
        return models.stream().map(CartItemMapper::toEntity).collect(Collectors.toList());
    }
}
