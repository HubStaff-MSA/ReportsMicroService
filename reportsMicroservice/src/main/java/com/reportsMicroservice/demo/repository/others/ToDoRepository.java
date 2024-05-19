package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ToDoRepository {
    private List<ToDo> todos = new ArrayList<>();


    public ToDoRepository() {
        todos.add(new ToDo(1, "Task 1", 1));
        todos.add(new ToDo(2, "Task 2", 2));
        todos.add(new ToDo(3, "Task 3", 3));


    }

    public List<ToDo> findByUserId(Integer userId) {
        return todos.stream()
                .filter(toDo -> toDo.getUserId().equals(userId))
                .collect(Collectors.toList());
    }


}
