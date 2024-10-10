package com.example.TaskApp.services;

import com.example.TaskApp.models.CartItemModel;
import com.example.TaskApp.models.CartModel;

import java.util.List;
import java.util.Optional;
public interface ICartService {
    CartModel create(CartModel model);
    Optional<CartModel> findById(Integer id);
    List<CartModel> findAll();
    CartModel update(CartModel model);
    void delete(Integer id);

    List<CartItemModel> getCartItems(Integer cartId);

    void removeCart(Integer cartId);
}
