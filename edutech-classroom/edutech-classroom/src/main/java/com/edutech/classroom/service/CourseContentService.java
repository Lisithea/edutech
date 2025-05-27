package com.edutech.classroom.service;

import com.edutech.classroom.Exception.ResourceNotFoundException;
import com.edutech.classroom.dto.CourseContentDTO;
import com.edutech.classroom.entity.CourseContent;
import com.edutech.classroom.repository.CourseContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseContentService {
    private final CourseContentRepository courseContentRepository;

    public List<CourseContentDTO> findAll() {
        return courseContentRepository.findAll()
                .stream()
                .map(CourseContentDTO::fromEntity)
                .toList();
    }

    public CourseContentDTO findById(Integer id) {
        return CourseContentDTO.fromEntity(courseContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido de curso no encontrado")));
    }

    public CourseContentDTO create(CourseContentDTO dto) {
        CourseContent entity = dto.toEntity();
        return CourseContentDTO.fromEntity(courseContentRepository.save(entity));
    }

    public CourseContentDTO update(Integer id, CourseContentDTO dto) {
        courseContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido de curso no encontrado"));
        CourseContent entity = dto.toEntity();
        entity.setId(id);
        return CourseContentDTO.fromEntity(courseContentRepository.save(entity));
    }

    public void delete(Integer id) {
        CourseContent entity = courseContentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido de curso no encontrado"));
        courseContentRepository.delete(entity);
    }
}
