package com.lab.lab5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.engine.jdbc.spi.TypeNullability;

//import static com.sun.tools.javac.resources.CompilerProperties.Fragments.TypeNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

//    public void setGroupEmployee(GroupEmployee groupEmployee) {
////        this.groupEmployee = groupEmployee;
////    }
////
////    public GroupEmployee getGroupEmployee() {
////        return groupEmployee;
////    }

    private String imie;
    private String nazwisko;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "group_employee_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private GroupEmployee groupEmployee;
    //private Integer group_employee_id;

    public Integer getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public EmployeeCondition getStan() {
        return stan;
    }

    public void setStan(EmployeeCondition stan) {
        this.stan = stan;
    }

    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    public Double getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(Double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    @Enumerated(EnumType.STRING)
    private EmployeeCondition stan;
    private Integer rok;
    private Double wynagrodzenie;
    public boolean isSet(){
        try{
            if(getNazwisko().isEmpty()){

            }
            if(getImie().isEmpty()){

            }
            if(getStan().toString().isEmpty()){

            }
            if(getRok().toString().isEmpty()){

            }
            if(getWynagrodzenie().toString().isEmpty()){

            }
        } catch(Exception ex ){
            return false;
        }
        return true;
    }
}
