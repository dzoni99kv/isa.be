package com.example.TaskApp.models;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleModel {
    private Integer id;
    private String roleName;
}
