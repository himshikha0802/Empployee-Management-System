package com.election.Online.Voting.System.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @ManyToMany(mappedBy = "departments")
  List<Employee> employees;

    public List<Employee> getEmployees() {
       return employees;
   }

    public void setEmployees(List<Employee> employees) {
       this.employees = employees;}

    private String departmentname;
    private String location;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department() {
    }


}


