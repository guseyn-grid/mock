package com.gd.mock.controller;


import com.gd.mock.model.Employee;
import com.gd.mock.model.Manager;
import com.gd.mock.model.Project;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value="/employee",description="Employee Profile",produces ="application/json")
@RequestMapping("/employee")
public class EmployeeController {

    @ApiOperation(value="get employee",response = Employee.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Employee details retrieved",response= Employee.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Employee is not found")
    })
    @RequestMapping(value="/{id}",method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<Employee> get(@PathVariable Integer id){
        Employee employee = new Employee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @ApiOperation(value="get all employees", response = List.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="All employees details retrieved",response= Employee.class),
            @ApiResponse(code=500,message="Internal Server Error")
    })
    @RequestMapping(value="/all",method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Employee>> all(){
        Employee employee = new Employee();
        List<Employee> employeeList = new ArrayList<Employee>(){{ add(employee); }};
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @ApiOperation(value="update employee's active status", response = Employee.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Employee with updated active status", response= Employee.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Employee is not found")
    })
    @RequestMapping(value="/{id}/updateStatus/{status}", method= RequestMethod.GET,produces="application/json")
    public ResponseEntity<Employee> updateEmployeeStatus(@PathVariable Integer id, @PathVariable Boolean status){
        Employee employee = new Employee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @ApiOperation(value="update employee's manager",response = Employee.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Employee with updated manager", response = Employee.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Employee is not found")
    })
    @RequestMapping(value="/{id}/updateManager",method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<Employee> updateEmployeeManager(@PathVariable Integer id, @RequestBody Manager manager){
        Employee employee = new Employee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @ApiOperation(value="update employee's project", response = Employee.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Updated manager of employee", response = Employee.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Employee is not found")
    })
    @RequestMapping(value="/{id}/updateProject",method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<Employee> updateEmployeeProject(@PathVariable Integer id, @RequestBody Project project){
        Employee employee = new Employee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
