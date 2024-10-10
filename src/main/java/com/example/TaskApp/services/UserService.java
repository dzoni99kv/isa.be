package com.example.TaskApp.services;

import com.example.TaskApp.exceptions.user.UserAlreadyExistException;
import com.example.TaskApp.exceptions.user.UserException;
import com.example.TaskApp.mappers.UserMapper;
import com.example.TaskApp.models.UserModel;
import com.example.TaskApp.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        var result = userRepository.findAll();
        return UserMapper.toModelList(result);
    }
    @Override
    public UserModel create(UserModel model) {
        var user = UserMapper.toEntity(model);

        var existingUser = userRepository.findByEmail(model.getEmail());

        if (existingUser.isPresent())
            throw new UserAlreadyExistException("User with email " + model.getEmail() + " already exists");

        var savedUser = userRepository.save(user);

        return UserMapper.toModel(savedUser);
    }
    @Override
    public UserModel update(UserModel model) {
        var entity = UserMapper.toEntity(model);
        try {
            var result = userRepository.save(entity);
            return UserMapper.toModel(result);
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }
    @Override
    public void delete(Integer userId) {
        var entity = userRepository.findById(userId).orElseThrow(() -> new UserException("User Not Found"));
        userRepository.delete(entity);
    }
    @Override
    public Optional<UserModel> findById(Integer userId) {
        return userRepository.findById(userId).map(UserMapper::toModel);
    }
}
