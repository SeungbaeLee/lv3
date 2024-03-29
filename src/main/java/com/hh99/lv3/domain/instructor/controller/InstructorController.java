package com.hh99.lv3.domain.instructor.controller;

import com.hh99.lv3.domain.instructor.dto.InstructorPatchDto;
import com.hh99.lv3.domain.instructor.dto.InstructorPostDto;
import com.hh99.lv3.domain.instructor.service.InstructorService;
import com.hh99.lv3.domain.instructor.dto.InstructorResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/instructors")
@RestController
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity createInstructor(@Valid @RequestBody InstructorPostDto instructorPostDto) {
        InstructorResponseDto createdInstructor = instructorService.createInstructor(instructorPostDto);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity readInstructor(@PathVariable("instructorId") @Positive long instructorId) {
        InstructorResponseDto foundInstructor = instructorService.readInstructor(instructorId);
        return new ResponseEntity<>(foundInstructor, HttpStatus.OK);
    }

    @PatchMapping("/{instructorId}")
    public ResponseEntity updateInstructor(@PathVariable("instructorId") @Positive long instructorId,
                                           @Valid @RequestBody InstructorPatchDto instructorPatchDto) {
        InstructorResponseDto createdInstructor = instructorService.updateInstructor(instructorId, instructorPatchDto);
        return new ResponseEntity<>(createdInstructor, HttpStatus.OK);
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity deleteInstructor(@PathVariable("instructorId") @Positive long instructorId) {
        instructorService.deleteInstructor(instructorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
