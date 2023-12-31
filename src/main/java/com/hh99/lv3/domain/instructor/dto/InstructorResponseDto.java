package com.hh99.lv3.domain.instructor.dto;

import com.hh99.lv3.domain.instructor.entity.Instructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class InstructorResponseDto {
    public String instructorName;
    public long years;
    public String company;
    public String phoneNumber;
    public String instruction;

    @Builder
    public InstructorResponseDto(String instructorName, long years, String company, String phoneNumber, String instruction) {
        this.instructorName = instructorName;
        this.years = years;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.instruction = instruction;
    }

    public static InstructorResponseDto fromEntity(Instructor instructor) {
        return InstructorResponseDto.builder()
                .instructorName(instructor.getInstructorName())
                .years(instructor.getYears())
                .company(instructor.getCompany())
                .phoneNumber(instructor.getPhoneNumber())
                .instruction(instructor.getIntroduction())
                .build();
    }
}
