package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDTO {
    private Integer id;

    @NotNull
    @Size(max = 150, message = "El título no puede superar los 150 caracteres")
    private String title;

    private String description;

    @NotNull
    private Integer categoryId;

    @NotNull
    private Integer managerId;

    @NotNull
    private Integer instructorId;

    private LocalDate publishDate;

    @Size(max = 20, message = "El estado no puede superar los 20 caracteres")
    private String status;

    public static CourseDTO fromEntity(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setCategoryId(course.getCategory().getId());
        dto.setManagerId(course.getManager().getId());
        dto.setInstructorId(course.getInstructor().getId());
        dto.setPublishDate(course.getPublishDate());
        dto.setStatus(course.getStatus());
        return dto;
    }
    public Course toEntity() {
        Course course = new Course();
        course.setId(getId());
        course.setTitle(getTitle());
        course.setDescription(getDescription());

        CourseCategory category = new CourseCategory();
        category.setId(this.getCategoryId());
        //falta rellenar campos
        course.setCategory(category);

        User manager = new User();
        manager.setId(this.getManagerId());
        course.setManager(manager);

        User instructor = new User();
        instructor.setId(this.getInstructorId());
        course.setInstructor(instructor);

        course.setPublishDate(this.getPublishDate());
        course.setStatus(this.getStatus());

        return course;
    }

}
