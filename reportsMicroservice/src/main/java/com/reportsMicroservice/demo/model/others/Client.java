package com.reportsMicroservice.demo.model.others;

import com.reportsMicroservice.demo.repository.others.ProjectRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    private Integer clientId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private List<Project> projects;

    // Method to add projects from ProjectRepository based on clientId
//    public void addProjectsFromRepository(ProjectRepository projectRepository) {
//        List<Project> allProjects = projectRepository.findAll();
//        List<Project> clientProjects = new ArrayList<>();
//
//        for (Project project : allProjects) {
//            if (project.getClientId().equals(this.clientId)) {
//                clientProjects.add(project);
//            }
//        }
//
//        this.projects = clientProjects;
//    }

}
