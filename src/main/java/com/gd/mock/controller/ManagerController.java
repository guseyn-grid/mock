package com.gd.mock.controller;

import com.gd.mock.model.Employee;
import com.gd.mock.model.Manager;
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
@Api(value="/manager",description="Manager Profile",produces ="application/json")
@RequestMapping("/manager")
public class ManagerController {

    @ApiOperation(value="get manager", response = Manager.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Manager details retrieved", response = Manager.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Manager is not found")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<Manager> get(@PathVariable Integer id){
        Manager manager = new Manager();
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @ApiOperation(value="get all managers", response = Employee.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="All managers details retrieved", response = List.class),
            @ApiResponse(code=500,message="Internal Server Error")
    })
    @RequestMapping(value="/all", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Manager>> all(){
        Manager manager = new Manager();
        List<Manager> employeeList = new ArrayList<Manager>(){{ add(manager); }};
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @ApiOperation(value="add employee to manager",response= Employee.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Manager with new employee", response = Manager.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Manager not found")
    })
    @RequestMapping(value="/{id}/addEmployee/", method= RequestMethod.POST,produces="application/json")
    public ResponseEntity<Employee> addEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        Manager manager = new Manager();
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

}
