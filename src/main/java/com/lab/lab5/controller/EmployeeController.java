package com.lab.lab5.controller;

import com.lab.lab5.entity.Employee;
import com.lab.lab5.entity.EmployeeCondition;
import com.lab.lab5.entity.GroupEmployee;
import com.lab.lab5.repository.GroupEmployeeRepository;
import com.lab.lab5.service.EmployeeService;
import com.lab.lab5.service.GroupEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Types;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private GroupEmployeeService groupEmployeeService;

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee,@RequestParam Integer gid){
        //GroupController con = new GroupController();
        //GroupEmployee group = GroupEmployeeRepository
        //employee.setGroupEmployee(group);
        //System.out.println(gid);
        GroupEmployee groupEmployee = groupEmployeeService.getGroupEmployee(gid);
        if(employee.isSet()==false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else if(groupEmployee.getMaks()==groupEmployee.getEmployeeList().size()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }else{
            employee.setGroupEmployee(groupEmployee);
            employeeService.addEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/csv")
    public ResponseEntity<Void> getEmployeesCSV(){
        employeeService.getEmployeesCSV();
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
