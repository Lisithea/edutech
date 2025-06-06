package com.edutech.classroom.dto;


import com.edutech.classroom.entity.CourseCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseCategoryDTO {


    private Integer id;

    @NotNull(message = "El nombre de la categoria no puede estar vacio")
    @Size(max = 100, message = "El nombre de la categoria nno puede superar los 100 caracteres")
    private String name;
    @NotNull(message = "La descripcion de la categoria no puede estar vacia")
    @Size(max = 800, message = "La descripcion de la categiria no puede superar los 800 caracteres")

    private String description;

    public static CourseCategoryDTO fromEntity(CourseCategory courseCategory) {
        CourseCategoryDTO courseCategoryDTO = new CourseCategoryDTO();
        courseCategoryDTO.setId(courseCategory.getId());
        courseCategoryDTO.setName(courseCategory.getName());
        courseCategoryDTO.setDescription(courseCategory.getDescription());
        return courseCategoryDTO;
    }
    public CourseCategory toEntity() {
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setId(this.getId());
        courseCategory.setName(this.getName());
        courseCategory.setDescription(this.getDescription());
        return courseCategory;
    }



}
