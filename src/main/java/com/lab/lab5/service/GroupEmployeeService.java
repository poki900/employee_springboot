package com.lab.lab5.service;

import com.lab.lab5.entity.Employee;
import com.lab.lab5.entity.GroupEmployee;

import java.util.List;

public interface GroupEmployeeService {

    void addGroup(GroupEmployee group);

    List<GroupEmployee> getGroup();

    GroupEmployee getGroupEmployee(Integer id);

    void deleteGroupEmployee(Integer id);
}
