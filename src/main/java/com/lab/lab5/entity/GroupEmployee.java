package com.lab.lab5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GroupEmployee {
    @Id
    @GeneratedValue
    private Integer id;
    private String nazwa;
    private Integer maks;
    @OneToMany(mappedBy = "groupEmployee", cascade = CascadeType.ALL)
    @JsonIgnore
   private List<Employee> employeeList;

    @OneToMany(mappedBy = "groupEmployee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rating> ratingList;
    public boolean isSet() {
        try {
            if (getMaks().toString().isEmpty()) {

            }
            if (getNazwa().isEmpty()) {

            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}

