package com.mahmutcelik.demo.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();

    static {
        todoList.add(new Todo(1,"mahmut","LEARN SPRING BOOT", LocalDate.now().plusYears(1),true));
        todoList.add(new Todo(2,"mahmut","LEARN SPRING BOOT", LocalDate.now().plusYears(1),true));
        todoList.add(new Todo(3,"mahmut","LEARN SPRING BOOT", LocalDate.now().plusYears(1),true));
        todoList.add(new Todo(4,"mahmut","LEARN SPRING BOOT", LocalDate.now().plusYears(1),true));
    }

    private static final Logger logger = LoggerFactory.getLogger(TodoService.class);

    public List<Todo> findByUsername(String username){
        logger.debug(username);

        return todoList.stream().filter(e -> e.getUsername().equalsIgnoreCase(username)).toList();
    }

    public void addNewTodo(String username,String description, LocalDate targetDate, boolean isDone){
        todoList.add(new Todo(todoList.size()+1, username,description,targetDate,isDone));
    }


    public void deleteFromList(int id){
        todoList.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id){
        return todoList.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void updateFromList(Todo todo) {

        deleteFromList(todo.getId());
        todoList.add(todo);
    }
}
