package com.example.TaskApp.services;

import com.example.TaskApp.models.RoleModel;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<RoleModel> findAll();
    RoleModel create(RoleModel role);
    RoleModel update(RoleModel role);
    void delete(Integer roleId);
    Optional<RoleModel> findById(Integer roleId);
}
