package com.reportsMicroservice.demo.dto;

import java.io.Serializable;
import java.util.List;

public class ProjectDTO implements Serializable {

    private Integer id;
    private String projectName;
    private Integer organizationId;
//    private List<Integer> employees;

    public ProjectDTO(Integer id, String projectName, Integer organizationId) {
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
}