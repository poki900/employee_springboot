package com.lab.lab5.service.impl;

import com.lab.lab5.entity.Employee;
import com.lab.lab5.entity.GroupEmployee;
import com.lab.lab5.repository.GroupEmployeeRepository;
import com.lab.lab5.service.GroupEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GroupEmployeeServiceImpl implements GroupEmployeeService {
    @Autowired
    private GroupEmployeeRepository groupRepository;

    @Override
    public void addGroup(GroupEmployee group) {
        groupRepository.save(group);
    }

    @Override
    public List<GroupEmployee> getGroup() {
        return groupRepository.findAll();
    }

    @Override
    public GroupEmployee getGroupEmployee(Integer id) {
        GroupEmployee group = groupRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Złe id "+id));
        return group;
    }

    @Override
    public void deleteGroupEmployee(Integer id) {
        GroupEmployee group = groupRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Złe id "+id));
        groupRepository.delete(group);
    }
}
