package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findEmployeesForService(Set<EmployeeSkill> skills, DayOfWeek day){
        return employeeRepository.findByDaysAvailableContaining(day).stream()
                .filter(employee -> employee.getSkills().containsAll(skills))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByIds(List<Long> ids){
        return employeeRepository.findAllById(ids);
    }

}
