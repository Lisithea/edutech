package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.Enrollment;
import com.edutech.classroom.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;
@Data
public class EnrollmentDTO {

    private Integer id;

    @NotNull
    private Integer studentId;

    @NotNull
    private Integer courseId;


    private Instant enrolledAt;

    @Size(max=20, message = "El estatus no puede superar los 20 caracteres")
    private String status;


    public static EnrollmentDTO fromEntity(Enrollment enrollment) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(enrollment.getId());
        dto.setStudentId(enrollment.getStudent().getId());
        dto.setCourseId(enrollment.getCourse().getId());
        dto.setEnrolledAt(enrollment.getEnrolledAt());
        dto.setStatus(enrollment.getStatus());
        return dto;
    }
    public Enrollment toEntity() {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(id);
        User student = new User();
        student.setId(this.studentId);
        enrollment.setStudent(student);

        Course course = new Course();
        course.setId(this.courseId);
        enrollment.setCourse(course);

        enrollment.setEnrolledAt(this.getEnrolledAt());
        enrollment.setStatus(this.getStatus());
        return enrollment;

    }

}
