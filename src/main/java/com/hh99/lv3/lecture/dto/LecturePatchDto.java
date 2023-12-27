package com.hh99.lv3.lecture.dto;

import com.hh99.lv3.lecture.entity.Category;
import com.hh99.lv3.lecture.entity.Lecture;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class LecturePatchDto {
    @NonNull
    private String lectureName;
    @NonNull
    private Long price;
    @NonNull
    private String introduction;
    @NonNull
    private Category category;

    @Builder
    public LecturePatchDto(String lectureName, Long price, String introduction, Category category) {
        this.lectureName = lectureName;
        this.price = price;
        this.introduction = introduction;
        this.category = category;
    }

    public Lecture toEntity() {
        return Lecture.builder()
                .lectureName(this.lectureName)
                .price(this.price)
                .introduction(this.introduction)
                .category(this.category)
                .build();
    }
}
