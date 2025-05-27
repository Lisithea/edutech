package com.edutech.classroom.service;

import com.edutech.classroom.Exception.ResourceNotFoundException;
import com.edutech.classroom.dto.CourseCategoryDTO;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.repository.CourseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CourseCategoryService {

    private final CourseCategoryRepository courseCategoryRepo;

    public List<CourseCategoryDTO> findAll() {
        return courseCategoryRepo.findAll().stream().map(CourseCategoryDTO::fromEntity).toList();
    }

    public CourseCategoryDTO findById(Integer id) {
        return CourseCategoryDTO.fromEntity(courseCategoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no encontrada"))
        );
    }

    public CourseCategoryDTO create(CourseCategoryDTO dto) {
        return CourseCategoryDTO.fromEntity(courseCategoryRepo.save(dto.toEntity()));

    }

    public CourseCategoryDTO update(Integer id,CourseCategoryDTO dto) {
        courseCategoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));
        CourseCategory entity = dto.toEntity();
        entity.setId(id);
        return CourseCategoryDTO.fromEntity(courseCategoryRepo.save(entity));
    }
    public void delete(Integer id) {
        courseCategoryRepo.delete(courseCategoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada")));
    }
}
