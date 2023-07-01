package com.mahmutcelik.demo.todo;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("list-todos")
    public String getListTodos(ModelMap model){
        model.addAttribute("todos",todoService.findByUsername(getLoggedinUsername()));
        return "listTodos";
    }

    private String getLoggedinUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName(); //It returns username that has signed in
    }



    @GetMapping("add-todo")
    public String getAddTodo(ModelMap model){
        Todo todo = new Todo(0, (String) model.get("name"),"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todoOperations";
    }
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){ //ModelMap must be first parameter
        if(result.hasErrors())
            return "todoOperations";

        todoService.addNewTodo(String.valueOf(model.get("name")),todo.getDescription(), todo.getTargetDate(),false);
        logger.debug(model.toString());
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam("id") int id){
        todoService.deleteFromList(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String showUpdateTodo(@RequestParam("id") int id, ModelMap model){
        model.addAttribute("todo",todoService.findById(id));
        return "todoOperations";
    }

    @PostMapping("update-todo")
    public String makeChangesOnTodo(ModelMap model,@Valid Todo todo,BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "todoOperations";

        logger.debug(todo.toString());
        logger.debug(model.toString());

        todoService.updateFromList(todo);
        return "redirect:list-todos";
    }



}
