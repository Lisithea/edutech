package com.edutech.classroom.service;

import com.edutech.classroom.Exception.ResourceNotFoundException;
import com.edutech.classroom.dto.CourseCommentDTO;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.repository.CourseCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCommentService {
    private final CourseCommentRepository courseCommentRepository;

    public List<CourseCommentDTO> findAll() {
        return courseCommentRepository.findAll()
                .stream()
                .map(CourseCommentDTO::fromEntity)
                .toList();
    }

    public CourseCommentDTO findById(Integer id) {
        CourseComment comment = courseCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        return CourseCommentDTO.fromEntity(comment);
    }

    public CourseCommentDTO create(CourseCommentDTO dto) {
        CourseComment saved = courseCommentRepository.save(dto.toEntity());
        return CourseCommentDTO.fromEntity(saved);
    }

    public CourseCommentDTO update(Integer id, CourseCommentDTO dto) {
        courseCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        CourseComment entity = dto.toEntity();
        entity.setId(id);
        CourseComment updated = courseCommentRepository.save(entity);
        return CourseCommentDTO.fromEntity(updated);
    }

    public void delete(Integer id) {
        CourseComment comment = courseCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado"));
        courseCommentRepository.delete(comment);
    }
}
