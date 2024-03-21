package com.lab.lab5.service;

import com.lab.lab5.entity.Rating;

import java.util.List;

public interface RatingService {
    void addRating(Rating rating);

    List<Rating> getRatings();

    Rating getRating(Integer id);

    void deleteRating(Integer id);
}
