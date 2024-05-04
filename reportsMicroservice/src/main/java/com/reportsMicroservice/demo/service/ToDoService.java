package com.reportsMicroservice.demo.service;
import com.reportsMicroservice.demo.model.ToDo;
import com.reportsMicroservice.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(int id) {
        return toDoRepository.findById(id);
    }

    public ToDo saveOrUpdate(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public void deleteToDoById(int id) {
        toDoRepository.deleteById(id);
    }

}
