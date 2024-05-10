package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {
    private List<ToDo> todos = new ArrayList<>();


    public ToDoRepository() {
        todos.add(new ToDo(1, "Task 1", 1));
        todos.add(new ToDo(2, "Task 2", 2));
        todos.add(new ToDo(3, "Task 3", 3));


    }

    public ToDo findByUserId(Integer userId) {
        return todos.stream()
                .filter(todo -> todo.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }


}
