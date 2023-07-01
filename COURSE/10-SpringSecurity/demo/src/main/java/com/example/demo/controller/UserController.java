package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private static final List<Todo> todoList = List.of(new Todo("MAHMUT","AA"));

    @GetMapping
    private List<Todo> getTodoList(){
        return todoList;
    }

    @GetMapping("/{username}")
    private Todo getSpecificUsername(@PathVariable String username){
        return todoList.get(0);
    }

    @PostMapping
    private void addNewTodo(@RequestBody Todo todo){
        todoList.add(todo);
    }


}


record Todo(String username, String description){}

