package com.reportsMicroservice.demo.model.others;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    private Integer clientId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

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
