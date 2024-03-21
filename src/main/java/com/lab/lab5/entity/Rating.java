package com.lab.lab5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer ocena;

    private String data;

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getKom() {
        return kom;
    }

    public void setKom(String kom) {
        this.kom = kom;
    }

    private String kom;

    public void setGroupEmployee(GroupEmployee groupEmployee) {
        this.groupEmployee = groupEmployee;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "group_employee_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private GroupEmployee groupEmployee;

    public boolean isSet(){
        try{
            if(getData().isEmpty()){

            }
            if(getOcena().toString().isEmpty()){

            }
            if(getKom().isEmpty()){

            }
        } catch (Exception ex){
            return false;
        }
        return true;
    }
}
