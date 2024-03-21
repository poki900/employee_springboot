package com.lab.lab5.controller;

import com.lab.lab5.entity.Employee;
import com.lab.lab5.entity.GroupEmployee;
import com.lab.lab5.service.GroupEmployeeService;
import com.lab.lab5.service.GroupEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    @Autowired
    private GroupEmployeeService groupService;

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody GroupEmployee group){
        if(group.isSet()==false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else{
            groupService.addGroup(group);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @GetMapping
    public List<GroupEmployee> getEmployees(){
        return groupService.getGroup();
    }

    @GetMapping("/{id}")
    public GroupEmployee getGroupEmployee(@PathVariable Integer id){
        return groupService.getGroupEmployee(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        groupService.deleteGroupEmployee(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/employee")
    public List<Employee>getEmployeeList(@PathVariable Integer id){
        GroupEmployee groupEmployee = getGroupEmployee(id);

        return groupEmployee.getEmployeeList();
    }
    @GetMapping("/{id}/fill")
    public Double getEmployeeFill(@PathVariable Integer id){
        GroupEmployee groupEmployee = getGroupEmployee(id);
        Double l = (double) groupEmployee.getEmployeeList().size();
        Double m = (double) groupEmployee.getMaks();
        return l/m*100;
    }
}
