package com.lab.lab5.service.impl;

import com.lab.lab5.entity.Employee;
import com.lab.lab5.repository.EmployeeRepository;
import com.lab.lab5.service.EmployeeService;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileWriter;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Złe id "+id));

        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Złe id "+id));
        employeeRepository.delete(employee);
    }

    @Override
    public void getEmployeesCSV() {
        List<Employee> list= employeeRepository.findAll();

        String csvFileName = "employees.csv";
        try(CSVWriter writer = new CSVWriter(new FileWriter(csvFileName))) {
            String[] header = {"id", "imie", "nazwisko", "stan","wynagrodzenie", "rok"};
            writer.writeNext(header);

            for(Employee em: list){
                String[] line = {em.getImie(),em.getNazwisko(),em.getStan().toString(),em.getWynagrodzenie().toString(),em.getRok().toString()};
                writer.writeNext(line);
            }
        } catch(Exception ex){

        }

    }
}
