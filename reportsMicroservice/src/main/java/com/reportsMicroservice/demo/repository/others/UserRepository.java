package com.reportsMicroservice.demo.repository.others;
import com.reportsMicroservice.demo.model.others.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        // Adding some mock data
        users.add(new User(1, User.UserRole.USER, "user1@gmail.com", "password1", "employee1", LocalDate.of(2020, Month.FEBRUARY, 11), 1,1));
        users.add(new User(2, User.UserRole.USER, "user2@gmail.com", "password2", "employee2", LocalDate.of(2020, Month.FEBRUARY, 12), 1,2));
        users.add(new User(3, User.UserRole.USER, "user3@gmail.com", "password3", "employee3", LocalDate.of(2020, Month.FEBRUARY, 13), 1,3));
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



}
