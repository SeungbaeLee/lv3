package com.hh99.lv3.instructor.repository;

import com.hh99.lv3.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByInstructorName(String instructorName);
}
