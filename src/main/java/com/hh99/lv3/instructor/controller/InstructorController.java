package com.hh99.lv3.instructor.controller;

import com.hh99.lv3.instructor.dto.InstructorPatchDto;
import com.hh99.lv3.instructor.dto.InstructorPostDto;
import com.hh99.lv3.instructor.dto.InstructorResponseDto;
import com.hh99.lv3.instructor.service.InstructorService;
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
}
