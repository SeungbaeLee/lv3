package com.hh99.lv3.domain.lecture.service;

import com.hh99.lv3.domain.lecture.dto.LecturePostDto;
import com.hh99.lv3.domain.lecture.repository.LectureRepository;
import com.hh99.lv3.domain.instructor.entity.Instructor;
import com.hh99.lv3.domain.instructor.service.InstructorService;
import com.hh99.lv3.domain.lecture.dto.LecturePatchDto;
import com.hh99.lv3.domain.lecture.dto.LectureResponseDto;
import com.hh99.lv3.domain.lecture.entity.Category;
import com.hh99.lv3.domain.lecture.entity.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LectureService {

    private final LectureRepository lectureRepository;
    private final InstructorService instructorService;

    //create
    public LectureResponseDto createLecture(LecturePostDto lecturePostDto) {
        Instructor instructor = instructorService.findByName(lecturePostDto.getInstructorName());

        Lecture lecture = lecturePostDto.toEntity(instructor);
        Lecture savedLecture = lectureRepository.save(lecture);

        return LectureResponseDto.fromEntity(savedLecture);
    }

    //update
    public LectureResponseDto updateLecture(long lectureId, LecturePatchDto lecturePatchDto) {
        Lecture lecture = findLectureById(lectureId);
        lecture.updateLecture(lecturePatchDto.getLectureName(), lecturePatchDto.getPrice(), lecturePatchDto.getIntroduction(), lecturePatchDto.getCategory());
        return LectureResponseDto.fromEntity(lecture);
    }
    public LectureResponseDto readLecture(long lectureId) {
        Lecture lecture = findLectureById(lectureId);
        return LectureResponseDto.fromEntity(lecture);
    }

    public List<LectureResponseDto> readLectureByInstructor(long instructorId) {
        if (!instructorService.isInstructorExist(instructorId)) {
            throw new NullPointerException("존재하지 않는 강사입니다.");
        } else {
            List<Lecture> lectureList = lectureRepository.findLecturesByInstructorId(instructorId);
            return LectureResponseDto.fromEntityList(lectureList);
        }
    }

    public List<LectureResponseDto> readLectureByCategory(Category category) {
        List<Lecture> lectureList = lectureRepository.findByCategoryOrderByLectureIdDesc(category);

        return LectureResponseDto.fromEntityList(lectureList);
    }


    public void deleteLecture(long lectureId) {
        Lecture lecture = findLectureById(lectureId);
        lectureRepository.delete(lecture);
    }


    public Lecture findLectureById(long lectureId) {
        Optional<Lecture> optionalLecture = lectureRepository.findById(lectureId);
        Lecture lecture = optionalLecture.orElseThrow(() -> new RuntimeException("존재하지 않는 강의 입니다."));
        return lecture;
    }
}
