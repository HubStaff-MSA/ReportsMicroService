package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository{
    List<Project> projects=new ArrayList<>();

    public ProjectRepository(){
        projects.add(new Project(1, "Project X", true, true, false, 1, 10000.0));
        projects.add(new Project(2, "Project Y", true, true, false, 2, 20000.0));
        projects.add(new Project(3, "Project Z", true, true, false, 3, 30000.0));
    }

    //find by project id
    public Project findById(Integer projectId) {
        return projects.stream()
                .filter(project -> project.getProjectId().equals(projectId))
                .findFirst()
                .orElse(null);
    }

    //find by client id
    public Project findByClientId(Integer clientId) {
        return projects.stream()
                .filter(project -> project.getClientId().equals(clientId))
                .findFirst()
                .orElse(null);
    }

}
