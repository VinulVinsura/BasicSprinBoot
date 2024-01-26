package com.example.basicsprinboot.service;

import com.example.basicsprinboot.Dao.EmployeeDao;
import com.example.basicsprinboot.dto.EmployeeDto;
import com.example.basicsprinboot.entity.Employee;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao ;
    @Autowired
    private ModelMapper modelMapper;
    public boolean saveEmployee(EmployeeDto employeeDto){
        if (employeeDao.existsById(employeeDto.getEmpId())){
            return false;
        }else {
           // employeeDao.findEmployeeByEmpAddress();
            employeeDao.save(modelMapper.map(employeeDto, Employee.class));
            return true;
        }
    }
    public List<EmployeeDto> getAllEmployee(){
        List<Employee> allEmployeeList = employeeDao.findAll();
        return modelMapper.map(allEmployeeList,new TypeToken<ArrayList<EmployeeDto>>(){}.getType());
    }
    public EmployeeDto search(int id){
        if (employeeDao.existsById(id)){
            Employee employee=employeeDao.findById(id).orElse(null);
            return modelMapper.map(employee,EmployeeDto.class);
        }else {
            return null;
        }

    }
    public EmployeeDto searchByName(String name){
        Employee employeeByEmpName = employeeDao.findEmployeeByEmpName(name);
        return modelMapper.map(employeeByEmpName, EmployeeDto.class);
    }
    public boolean updateEmployee(EmployeeDto employeeDto){

        if (employeeDao.existsById(employeeDto.getEmpId())){
            employeeDao.save(modelMapper.map(employeeDto, Employee.class));
            return true;
        }else {
            return false;
        }
    }
    public boolean deleteEmployee(EmployeeDto employeeDto){
        if (employeeDao.existsById(employeeDto.getEmpId())){
            employeeDao.delete(modelMapper.map(employeeDto,Employee.class));
            return true;
        }else {
            return false;
        }

    }

}
