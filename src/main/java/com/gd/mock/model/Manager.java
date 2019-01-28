package com.gd.mock.model;

import java.util.List;

public class Manager extends Employee {

    private List<Employee> employees;
    private List<Project> projects;

    public Manager() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
