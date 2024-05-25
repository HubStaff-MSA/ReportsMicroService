package com.reportsMicroservice.demo.dto;

import java.io.Serializable;

public class ProjectDTO2 implements Serializable {

    private Integer id;
    private String projectName;
    private Integer organizationId;
//    private List<Integer> employees;

    public ProjectDTO2(Integer id, String projectName, Integer organizationId) {
        this.id = id;
        this.projectName = projectName;
//        this.employees = employees;
        this.organizationId = organizationId;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

//    public List<Integer> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Integer> employees) {
//        this.employees = employees;
//    }
}