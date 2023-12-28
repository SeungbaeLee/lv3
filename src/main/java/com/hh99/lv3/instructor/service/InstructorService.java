package com.hh99.lv3.instructor.service;

import com.hh99.lv3.instructor.dto.InstructorPatchDto;
import com.hh99.lv3.instructor.dto.InstructorPostDto;
import com.hh99.lv3.instructor.dto.InstructorResponseDto;
import com.hh99.lv3.instructor.entity.Instructor;
import com.hh99.lv3.instructor.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class InstructorService {

    private final InstructorRepository instructorRepository;

    //create
    public InstructorResponseDto createInstructor(InstructorPostDto instructorPostDto) {
        Instructor instructor = instructorPostDto.toEntity();
        Instructor savedInstructor = instructorRepository.save(instructor);
        return InstructorResponseDto.fromEntity(savedInstructor);
    }

    //read
    public InstructorResponseDto readInstructor(long instructorId) {
        Instructor instructor = isExistingInstructor(instructorId);
        return InstructorResponseDto.fromEntity(instructor);
    }

    //update
    public InstructorResponseDto updateInstructor(long instructorId, InstructorPatchDto instructorPatchDto) {
        Instructor instructor = isExistingInstructor(instructorId);
        instructor.updateInstructor(instructorPatchDto.years, instructorPatchDto.company, instructorPatchDto.phoneNumber,instructorPatchDto.instruction);
        return InstructorResponseDto.fromEntity(instructor);

    }

    public Instructor isExistingInstructor(long instructorId) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorId);
        Instructor instructor = optionalInstructor.orElseThrow(() -> new RuntimeException("존재하지 않는 강사입니다."));
        return instructor;
    }
    public Instructor findByName(String name) {
        Optional<Instructor> optionalInstructor = instructorRepository.findByInstructorName(name);
        Instructor instructor = optionalInstructor.orElseThrow(()-> new RuntimeException("존재하지 않는 강사입니다."));
        return instructor;
    }
}
