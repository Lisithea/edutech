package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleDTO {
    private int id;
    @NotNull
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String name;
    private String description;

    public static RoleDTO fromEntity(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        dto.setDescription(role.getDescription());
        return dto;


    }
    public Role toEntity() {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        role.setDescription(description);
        return role;
    }

}
