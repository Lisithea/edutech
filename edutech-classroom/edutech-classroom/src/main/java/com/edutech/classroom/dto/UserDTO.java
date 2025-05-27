package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class UserDTO {
   private int id;
   @NotNull
   @Size(max=100, message = "El primer nombre no puede contener mas de 100 caracteres")
   private String firstName;
   @NotNull
   @Size(max=100, message = "El apellido no puede contener mas de 100 caracteres")
   private String lastName;
   @NotNull
   @Size(max=150, message = "El email no puede contener mas de 100 caracteres")
   private String email;
   @NotNull
   @Size(max=255,message = "La password no puede contener mas de 255 caracteres")
   private String passwordHash;
   @NotNull
   private Integer roleId;
   private Boolean isActive;
   private Instant createdAt;
   private Instant updatedAt;

   public static UserDTO fromEntity(User user) {
      UserDTO userDTO = new UserDTO();
      userDTO.setId(user.getId());
      userDTO.setFirstName(user.getFirstName());
      userDTO.setLastName(user.getLastName());
      userDTO.setEmail(user.getEmail());
      userDTO.setPasswordHash(user.getPasswordHash());
      userDTO.setRoleId(user.getRole().getId());
      userDTO.setIsActive(user.getIsActive());
      userDTO.setCreatedAt(user.getCreatedAt());
      userDTO.setUpdatedAt(user.getUpdatedAt());

      return userDTO;
   }
   public User toEntity() {
      User user = new User();
      user.setId(this.getId());
      user.setFirstName(this.getFirstName());
      user.setLastName(this.getLastName());
      user.setEmail(this.getEmail());
      user.setPasswordHash(this.getPasswordHash());
      Role role = new Role();
      role.setId(this.getRoleId());
      user.setRole(role);
      user.setIsActive(this.getIsActive());
      return user;
   }

}
