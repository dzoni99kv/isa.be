package com.example.TaskApp.services;

import com.example.TaskApp.exceptions.role.RoleException;
import com.example.TaskApp.mappers.RoleMapper;
import com.example.TaskApp.models.RoleModel;
import com.example.TaskApp.repositories.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;

    @Override
    public List<RoleModel> findAll() {
        var roles = roleRepository.findAll();
        return RoleMapper.toModelList(roles);
    }

    @Override
    public RoleModel create(RoleModel model) {
        var role = RoleMapper.toEntity(model);
        var savedRole = roleRepository.save(role);
        return RoleMapper.toModel(savedRole);
    }

    @Override
    public RoleModel update(RoleModel model) {
        var existingRole = roleRepository.findById(model.getId())
                .orElseThrow(() -> new RoleException("Role Not Found"));
        existingRole.setRoleName(model.getRoleName()); // Update fields as necessary
        var updatedRole = roleRepository.save(existingRole);
        return RoleMapper.toModel(updatedRole);
    }

    @Override
    public void delete(Integer roleId) {
        var role = roleRepository.findById(roleId).orElseThrow(() -> new RoleException("Role Not Found"));
        roleRepository.delete(role);
    }

    @Override
    public Optional<RoleModel> findById(Integer roleId) {
        return roleRepository.findById(roleId).map(RoleMapper::toModel);
    }
}