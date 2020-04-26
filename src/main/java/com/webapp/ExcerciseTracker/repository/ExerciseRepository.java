package com.webapp.ExcerciseTracker.repository;

import com.webapp.ExcerciseTracker.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise,Integer> {
}
