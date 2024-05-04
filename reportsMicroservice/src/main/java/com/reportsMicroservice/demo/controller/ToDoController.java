package com.reportsMicroservice.demo.controller;
import com.reportsMicroservice.demo.model.ToDo;
import com.reportsMicroservice.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos() {
        return ResponseEntity.ok(toDoService.getAllToDos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ToDo>> getToDoById(@PathVariable int id) {
        return ResponseEntity.ok(toDoService.getToDoById(id));
    }

    @PostMapping
    public ResponseEntity<ToDo> saveOrUpdate(@RequestBody ToDo toDo) {
        return ResponseEntity.ok(toDoService.saveOrUpdate(toDo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable int id) {
        toDoService.deleteToDoById(id);
        return ResponseEntity.ok().build();
    }
}
