package com.hh99.lv3.lecture.repository;

import com.hh99.lv3.lecture.entity.Category;
import com.hh99.lv3.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    @Query("SELECT l FROM Lecture l WHERE l.instructor.instructorId = :instructorId ORDER BY l.lectureId DESC")
    List<Lecture> findLecturesByInstructorId(Long instructorId);

    @Query("SELECT l FROM Lecture l WHERE l.category = :category ORDER BY l.lectureId DESC")
    List<Lecture> findByCategoryOrderByLectureIdDesc(Category category);
}
