package com.lab.lab5.repository;

import com.lab.lab5.entity.Employee;
import com.lab.lab5.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository  extends JpaRepository<Rating, Integer> {
}
