package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {

        // Adding some mock data
        users.add(new User(1, User.UserRole.USER, "employee1" , "user1@gmail.com", "password1",
                LocalDate.of(2020, Month.FEBRUARY, 11), 1, 1,
                LocalDate.of(2020, Month.FEBRUARY, 11), 10.0, 1000.0, "tax1", 10, 5, 5, 100.0, 40.0));
        users.add(new User(2, User.UserRole.USER, "employee2", "user2@gmail.com", "password2",  LocalDate.of(2020, Month.FEBRUARY, 12), 1, 2,
                LocalDate.of(2020, Month.FEBRUARY, 12), 20.0, 2000.0, "tax2", 20, 10, 10, 200.0, 50.0));
        users.add(new User(3, User.UserRole.USER, "employee3","user3@gmail.com", "password3",  LocalDate.of(2020, Month.FEBRUARY, 13), 1, 3,
                LocalDate.of(2020, Month.FEBRUARY, 13), 30.0, 3000.0, "tax3", 30, 15, 15, 300.0, 60.0));
    }


    public List<User> findByProjectId(Integer projectId) {
        return users.stream()
                .filter(user -> user.getProjectId().equals(projectId))
                .collect(Collectors.toList());
    }

    public User findById(Integer userId) {
        return users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public List<User> findAllById(List<Integer> userIds) {
        return users.stream()
                .filter(user -> userIds.contains(user.getId()))
                .collect(Collectors.toList());
    }


    public List<User> findAll() {
        return users;
    }
}
