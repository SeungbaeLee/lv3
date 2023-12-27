package com.hh99.lv3.instructor.dto;

import com.hh99.lv3.instructor.entity.Instructor;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class InstructorPatchDto {
    @NonNull
    public Long years;
    @NonNull
    public String company;
    @NotBlank
    public String phoneNumber;
    @NonNull
    public String instruction;

    @Builder
    public InstructorPatchDto(long years, String company, String phoneNumber, String instruction) {
        this.years = years;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.instruction = instruction;
    }

    public Instructor toEntity() {
        return Instructor.builder()
                .years(this.years)
                .company(this.company)
                .phoneNumber(this.phoneNumber)
                .introduction(this.instruction)
                .build();
    }
}
