package com.bridgelabz.employeepayroll.Controller;

import com.bridgelabz.employeepayroll.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.DTO.ResponseDTO;
import com.bridgelabz.employeepayroll.Model.EmployeepayrollData;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeepayrollData employeeData = null;
        employeeData = new EmployeepayrollData(1, new EmployeePayrollDTO("Arun", 800000));
        ResponseDTO responseDTO = new ResponseDTO("GET call for ID is Successful", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
        /**
         * 
         * @param employeepayrollDTO
         * @return
         */
    
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeepayrollData employeeData = null;
        employeeData = new EmployeepayrollData(1, new EmployeePayrollDTO("Arun", 800000));
        ResponseDTO responseDTO = new ResponseDTO("GET call is successfull for ID: ", employeeData);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }
        /**
         * 
         * @param employeepayrollDTO
         * @return
         */

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
                                @RequestBody EmployeePayrollDTO employeepayrollDTO) {
        EmployeepayrollData employeeData = null;
        employeeData = new EmployeepayrollData(1, employeepayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfull !!", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO,  HttpStatus.OK);
    }
       /**
        * 
        * @param employeePayrollDTO
        * @return
        */
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
                            @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeepayrollData employeeData = null;
        employeeData = new EmployeepayrollData(1, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully!!", employeeData);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }
        /**
         * 
         * @param empId
         * @return
         */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO>deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO responseDTO = new ResponseDTO("DELETED Successfully !!", "Deleted ID: " + empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


}
