package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.Project;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository {
    List<Project> projects = new ArrayList<>();

    public ProjectRepository() {
        projects.add(new Project(1, "Project X", true, true, false, 1,
                10000.0, Project.BudgetType.TotalCost, Project.BudgetBasedOn.BillRate, 1.0, LocalDate.of(2021, 1, 1), false));
        projects.add(new Project(2, "Project Y", true, true, false, 2, 20000.0,
                Project.BudgetType.TotalCost, Project.BudgetBasedOn.BillRate, 1.0, LocalDate.of(2021, 2, 2), false));
        projects.add(new Project(3, "Project Z", true, true, false, 3, 30000.0,
                Project.BudgetType.TotalCost, Project.BudgetBasedOn.BillRate, 1.0, LocalDate.of(2021, 3, 3), false));
    }

    //find by project id
    public Optional<Project> findById(Integer projectId) {
        return projects.stream()
                .filter(project -> project.getProjectId().equals(projectId))
                .findFirst();
    }


    //find by client id
    public Project findByClientId(Integer clientId) {
        return projects.stream()
                .filter(project -> project.getClientId().equals(clientId))
                .findFirst()
                .orElse(null);
    }



    public List<Project> findAll() {
        return projects;
    }
}
