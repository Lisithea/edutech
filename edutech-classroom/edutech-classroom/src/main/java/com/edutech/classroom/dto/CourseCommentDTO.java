package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
public class CourseCommentDTO {
    private Integer id;

    @NotNull
    private Integer courseId;

    @NotNull
    private Integer userId;

    @Size(max = 800, message = "El comentario no puede superar los 800 caracteres")
    private String commentText;

    private Integer rating;

    private Instant createdAt;

    public static CourseCommentDTO fromEntity(CourseComment comment) {
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(comment.getId());
        dto.setCourseId(comment.getCourse().getId());
        dto.setUserId(comment.getUser().getId());
        dto.setCommentText(comment.getCommentText());
        dto.setRating(comment.getRating());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }

    public CourseComment toEntity() {
        CourseComment comment = new CourseComment();
        comment.setId(this.getId());

        Course course = new Course();
        course.setId(this.getCourseId());
        comment.setCourse(course);

        User user = new User();
        user.setId(this.getUserId());
        comment.setUser(user);

        comment.setCommentText(this.getCommentText());
        comment.setRating(this.getRating());
        comment.setCreatedAt(this.getCreatedAt());

        return comment;
    }
}
