package com.example.TaskApp.services;

import com.example.TaskApp.entities.Cart;
import com.example.TaskApp.entities.CartItem;
import com.example.TaskApp.entities.User;
import com.example.TaskApp.exceptions.cart.CartException;
import com.example.TaskApp.exceptions.user.UserException;
import com.example.TaskApp.mappers.CartItemMapper;
import com.example.TaskApp.mappers.CartMapper;
import com.example.TaskApp.mappers.UserMapper;
import com.example.TaskApp.models.CartItemModel;
import com.example.TaskApp.models.CartModel;
import com.example.TaskApp.repositories.ICartItemRepository;
import com.example.TaskApp.repositories.ICartRepository;
import com.example.TaskApp.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final ICartRepository cartRepository;
    private final ICartItemRepository cartItemRepository;
    private final IUserRepository userRepository;
    @Override
    public CartModel create(CartModel cartModel) {
        System.out.println("Incoming CartModel: " + cartModel); // Log incoming cart model

        // Check if the User ID is provided
        if (cartModel.getUser() == null || cartModel.getUser().getId() == null) {
            throw new UserException("User ID must be provided");
        }

        // Fetch the User entity using the provided user ID
        User user = userRepository.findById(cartModel.getUser().getId())
                .orElseThrow(() -> new UserException("User not found"));

        System.out.println("Fetched User: " + user); // Log the fetched user

        // Set the fetched User to the cartModel
        cartModel.setUser(UserMapper.toModel(user));

        // Now convert CartModel to Cart entity and save
        Cart cart = CartMapper.toEntity(cartModel);
        Cart savedCart = cartRepository.save(cart);

        return CartMapper.toModel(savedCart); // Return the saved CartModel
    }

    @Override
    public Optional<CartModel> findById(Integer id) {
        return cartRepository.findById(id).map(CartMapper::toModel);
    }

    @Override
    public List<CartModel> findAll() {
        var carts = cartRepository.findAll();
        return CartMapper.toModelList(carts);
    }

    @Override
    public CartModel update(CartModel model) {
        if (!cartRepository.existsById(model.getId())) {
            throw new CartException("Cart not found");
        }
        var cart = CartMapper.toEntity(model);
        var updatedCart = cartRepository.save(cart);
        return CartMapper.toModel(updatedCart);
    }

    @Override
    public void delete(Integer id) {
        if (!cartRepository.existsById(id)) {
            throw new CartException("Cart not found");
        }
        cartRepository.deleteById(id);
    }

    @Override
    public List<CartItemModel> getCartItems(Integer cartId) {
        List<CartItem> cartItems = cartItemRepository.findByCartId(cartId); // Fetch items by cart ID
        return CartItemMapper.toModelList(cartItems); // Convert to model list
    }

    @Override
    public void removeCart(Integer cartId) {
        cartRepository.deleteById(cartId);
    }
}