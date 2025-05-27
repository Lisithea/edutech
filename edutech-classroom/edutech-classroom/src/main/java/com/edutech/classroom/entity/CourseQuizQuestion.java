package com.edutech.classroom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "course_quiz_question")
public class CourseQuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "quiz_id", nullable = false)
    private CourseQuiz quiz;

    @Size(max = 800)
    @Column(name = "question_text", length = 800)
    private String questionText;

    @Size(max = 800)
    @Column(name = "option_a", length = 800)
    private String optionA;

    @Size(max = 800)
    @Column(name = "option_b", length = 800)
    private String optionB;

    @Size(max = 800)
    @Column(name = "option_c", length = 800)
    private String optionC;

    @Size(max = 800)
    @Column(name = "option_d", length = 800)
    private String optionD;

    @Size(max = 800)
    @Column(name = "option_e", length = 800)
    private String optionE;

    @Size(max = 800)
    @Column(name = "correct_answer", length = 800)
    private String correctAnswer;

    @Lob
    @Column(name = "correct_option")
    private String correctOption;

    @Column(name = "order_index")
    private Integer orderIndex;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

}