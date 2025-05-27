package com.edutech.classroom.service;

import com.edutech.classroom.Exception.ResourceNotFoundException;
import com.edutech.classroom.dto.UserDTO;
import com.edutech.classroom.entity.User;
import com.edutech.classroom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::fromEntity).toList();
    }
    public UserDTO findById(Integer id) {
        return UserDTO.fromEntity(userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado")));
    }
    public UserDTO create(UserDTO dto) {
        return UserDTO.fromEntity(userRepository.save(dto.toEntity()));
    }
    public UserDTO update(Integer id, UserDTO dto) {
        userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado"));
        User user =dto.toEntity();
        user.setId(id);
        return UserDTO.fromEntity(userRepository.save(user));
    }
    public void delete(Integer id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado")));
    }
}
