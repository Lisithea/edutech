package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseContent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseContentDTO {
    private Integer id;

    @NotNull
    private Integer courseId;

    @NotNull
    @Size(max = 200, message = "El título no puede tener más de 200 caracteres")
    private String title;

    @Size(max = 50, message = "El tipo de contenido no puede tener más de 50 caracteres")
    private String contentType;

    private String url;

    private Integer orderIndex;

    public static CourseContentDTO fromEntity(CourseContent content) {
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(content.getId());
        dto.setCourseId(content.getCourse().getId());
        dto.setTitle(content.getTitle());
        dto.setContentType(content.getContentType());
        dto.setUrl(content.getUrl());
        dto.setOrderIndex(content.getOrderIndex());
        return dto;
    }

    public CourseContent toEntity() {
        CourseContent entity = new CourseContent();
        entity.setId(this.getId());
        entity.setTitle(this.getTitle());
        entity.setContentType(this.getContentType());
        entity.setUrl(this.getUrl());
        entity.setOrderIndex(this.getOrderIndex());

        Course course = new Course();
        course.setId(this.getCourseId());
        entity.setCourse(course);

        return entity;
    }
}
