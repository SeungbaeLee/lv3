package com.hh99.lv3.domain.instructor.repository;

import com.hh99.lv3.domain.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByInstructorName(String instructorName);
}
