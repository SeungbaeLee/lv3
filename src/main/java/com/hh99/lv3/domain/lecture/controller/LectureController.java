package com.hh99.lv3.domain.lecture.controller;

import com.hh99.lv3.domain.lecture.dto.LecturePostDto;
import com.hh99.lv3.domain.lecture.entity.Category;
import com.hh99.lv3.domain.lecture.service.LectureService;
import com.hh99.lv3.domain.lecture.dto.LecturePatchDto;
import com.hh99.lv3.domain.lecture.dto.LectureResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/lectures")
@RestController
public class LectureController {

    private final LectureService lectureService;

    @PostMapping
    public ResponseEntity createLecture(@Valid @RequestBody LecturePostDto lecturePostDto) {
        LectureResponseDto createdLecture = lectureService.createLecture(lecturePostDto);
        return new ResponseEntity<>(createdLecture, HttpStatus.CREATED);
    }

    @PatchMapping("/{lectureId}")
    public ResponseEntity updateLecture(@PathVariable("lectureId") @Positive long lectureId,
                                        @Valid @RequestBody LecturePatchDto lecturePatchDto) {
        LectureResponseDto updatedLecture = lectureService.updateLecture(lectureId, lecturePatchDto);
        return new ResponseEntity<>(updatedLecture, HttpStatus.OK);
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity readLectureByInstructor(@PathVariable("instructorId") @Positive long instructorId) {
        List<LectureResponseDto> lectureResponseDtoList = lectureService.readLectureByInstructor(instructorId);
        return new ResponseEntity<>(lectureResponseDtoList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity readLectureByCategory(@RequestParam("category") Category category) {
        List<LectureResponseDto> lectureResponseDtoList = lectureService.readLectureByCategory(category);
        return new ResponseEntity<>(lectureResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{lectureId}")
    public ResponseEntity readLecture(@PathVariable("lectureId") @Positive long lectureId) {
        LectureResponseDto lectureResponseDto = lectureService.readLecture(lectureId);
        return new ResponseEntity<>(lectureResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{lectureId}")
    public ResponseEntity deleteLecture(@PathVariable("lectureId") @Positive long lectureId) {
        lectureService.deleteLecture(lectureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
