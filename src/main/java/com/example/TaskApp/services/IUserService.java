package com.example.TaskApp.services;

import com.example.TaskApp.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserModel> findAll();
    UserModel create(UserModel user);
    UserModel update(UserModel user);
    void delete(Integer userId);
    Optional<UserModel> findById(Integer userId);

}
