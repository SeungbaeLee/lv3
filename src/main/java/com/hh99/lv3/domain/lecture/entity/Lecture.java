package com.hh99.lv3.domain.lecture.entity;

import com.hh99.lv3.domain.instructor.entity.Instructor;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    private String lectureName;

    private Long price;

    private String introduction;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Builder
    public Lecture(Long lectureId, Instructor instructor, String lectureName, Long price, String introduction, Category category) {
        this.lectureId = lectureId;
        this.instructor = instructor;
        this.lectureName = lectureName;
        this.price = price;
        this.introduction = introduction;
        this.category = category;
    }

    public void updateLecture(String lectureName, Long price, String introduction, Category category) {
        this.lectureName = lectureName;
        this.price = price;
        this.introduction = introduction;
        this.category = category;
    }
}
