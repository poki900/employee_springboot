package com.lab.lab5.controller;

import com.lab.lab5.entity.GroupEmployee;
import com.lab.lab5.entity.Rating;
import com.lab.lab5.repository.RatingRepository;
import com.lab.lab5.service.GroupEmployeeService;
import com.lab.lab5.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @Autowired
    private GroupEmployeeService groupEmployeeService;

    @PostMapping
    public ResponseEntity<Void> addRating(@RequestBody Rating rating, @RequestParam Integer gid){
        GroupEmployee groupEmployee = groupEmployeeService.getGroupEmployee(gid);
        if(rating.isSet()==false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else{
            rating.setGroupEmployee(groupEmployee);
            ratingService.addRating(rating);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @GetMapping
    public List<Rating> getRating(){return ratingService.getRatings();}

    @GetMapping("/{id}")
    public Rating getRating(@PathVariable Integer id){return ratingService.getRating(id);}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Integer id){
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
