package com.example.TaskApp.mappers;

import com.example.TaskApp.entities.User;
import com.example.TaskApp.models.RegisterUserModel;
import com.example.TaskApp.models.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    // Method to convert UserModel to User entity without password encoding
    public static User toEntity(UserModel model) {
        User user = new User();
        user.setId(model.getId());
        user.setUsername(model.getUsername());
        user.setEmail(model.getEmail());
        user.setPassword(model.getPassword()); // This might be null if you're not hashing yet
        return user;
    }
    public static User toEntity(RegisterUserModel model, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }

    // Method to convert UserModel to User entity with password encoding
    public static User toEntity(UserModel model, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setId(model.getId()); // Ensure you set the ID if you're updating
        user.setUsername(model.getUsername()); // Set the username
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword())); // Hash the password
        return user;
    }

    // Method to convert User entity to UserModel
    public static UserModel toModel(User entity) {
        return UserModel.builder()
                .id(entity.getId())
                .username(entity.getUsername()) // Ensure username is included
                .email(entity.getEmail())
                .build();
    }

    // Method to convert a list of User entities to UserModels
    public static List<UserModel> toModelList(List<User> entities) {
        List<UserModel> list = new ArrayList<>();
        for (User entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }
}
