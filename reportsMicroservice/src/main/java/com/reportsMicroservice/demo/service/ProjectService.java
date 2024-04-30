package com.reportsMicroservice.demo.service;

import com.reportsMicroservice.demo.model.Project;
import com.reportsMicroservice.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(String projectId) {
        return projectRepository.findById(projectId);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(String projectId) {
        projectRepository.deleteById(projectId);
    }
}
