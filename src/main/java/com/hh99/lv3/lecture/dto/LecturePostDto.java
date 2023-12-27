package com.hh99.lv3.lecture.dto;

import com.hh99.lv3.instructor.entity.Instructor;
import com.hh99.lv3.lecture.entity.Category;
import com.hh99.lv3.lecture.entity.Lecture;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class LecturePostDto {
        @NonNull
        private String lectureName;
        @NonNull
        private Long price;
        @NonNull
        private String introduction;
        @NonNull
        private Category category;
        @NonNull
        private String instructorName;

        @Builder
        public LecturePostDto(String lectureName, Long price, String introduction, Category category, String instructorName) {
                this.lectureName = lectureName;
                this.price = price;
                this.introduction = introduction;
                this.category = category;
                this.instructorName = instructorName;
        }

        public Lecture toEntity(Instructor instructor) {
                return Lecture.builder()
                        .instructor(instructor)
                        .lectureName(this.lectureName)
                        .price(this.price)
                        .introduction(this.introduction)
                        .category(this.category)
                        .build();

        }
}
