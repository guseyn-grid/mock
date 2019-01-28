package com.gd.mock.controller;

import com.gd.mock.model.Project;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProjectController {

    @ApiOperation(value="get project", response = Project.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Project details retrieved", response = Project.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Project is not found")
    })
    @RequestMapping(value="/{id}",method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<Project> get(@PathVariable Integer id){
        Project project = new Project();
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

}
