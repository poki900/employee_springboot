package com.lab.lab5.service.impl;

import com.lab.lab5.entity.Rating;
import com.lab.lab5.repository.RatingRepository;
import com.lab.lab5.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRating(Integer id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Złe id "+id));
        return rating;
    }

    @Override
    public void deleteRating(Integer id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Złe id "+id));
        ratingRepository.delete(rating);
    }
}
