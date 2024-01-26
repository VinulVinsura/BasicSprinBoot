package com.example.basicsprinboot.Dao;

import com.example.basicsprinboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeDao extends JpaRepository<Employee,Integer> {


    Employee findEmployeeByEmpName(String name);
//    void findEmployeeByEmpAddress();
}
