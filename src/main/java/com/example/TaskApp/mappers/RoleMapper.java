package com.example.TaskApp.mappers;

import com.example.TaskApp.entities.Role;
import com.example.TaskApp.models.RoleModel;

import java.util.ArrayList;
import java.util.List;

public class RoleMapper {

    public static Role toEntity(RoleModel model) {
        Role role = new Role();
        role.setId(model.getId());
        role.setRoleName(model.getRoleName());
        return role;
    }

    public static RoleModel toModel(Role entity) {
        if (entity == null) {
            return null;
        }

        return RoleModel.builder()
                .id(entity.getId())
                .roleName(entity.getRoleName())
                .build();
    }

    public static List<RoleModel> toModelList(List<Role> entities) {
        if (entities == null) {
            return null;
        }

        List<RoleModel> list = new ArrayList<>();
        for (Role entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }
}
