package com.example.basicsprinboot.Controller;

import com.example.basicsprinboot.dto.EmployeeDto;
import com.example.basicsprinboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto){
      if (employeeDto.equals(null)){
          return null;
      }else{
          boolean isSave = employeeService.saveEmployee(employeeDto);
          if (isSave){
              return "Employee Saved..";
          }else {
              return "Employee Not Saved..";

          }}
    }
    @GetMapping("/getEmployee")
    public List<EmployeeDto> getAllEmployee(){
        List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
        return allEmployee;
    }
    @GetMapping("/search/{id}")
    public EmployeeDto search(@PathVariable  int id){
       return employeeService.search(id);

    }
    @GetMapping("/searchByName/{name}")
    public EmployeeDto searchEmployeeByName(@PathVariable String name){
        return employeeService.searchByName(name);
    }
    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeDto employeeDto){
        boolean isUpdate = employeeService.updateEmployee(employeeDto);
        if (isUpdate){
            return " Employee Updated..";
        }else {
            return "Error";
        }
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestBody EmployeeDto employeeDto){
        boolean isDelete = employeeService.deleteEmployee(employeeDto);
        if (isDelete){
            return "Employee Deleted..";
        }
        return "Error..";
    }
}
