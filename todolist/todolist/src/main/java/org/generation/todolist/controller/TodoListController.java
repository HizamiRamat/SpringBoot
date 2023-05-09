package org.generation.todolist.controller;

import org.generation.todolist.controller.dto.TodoListDTO;
import org.generation.todolist.repository.entity.TodoList;
import org.generation.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@RestController
@RequestMapping("/item")
public class TodoListController {


    private final TodoListService todoListService;
    private String title;
    private String description;
    private String date;


    public TodoListController( @Autowired TodoListService todoListService )
    {
        this.todoListService = todoListService;
    }


    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<TodoList> getTodoList()
    {
        return todoListService.all();
    }

    @CrossOrigin
    @GetMapping( "/{id}" )
    public TodoList findTodoListById( @PathVariable Integer id )
    {
        return todoListService.findById( id );
    }

    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        todoListService.delete( id );
    }

    @CrossOrigin
    @PostMapping("/add")
    public void submit(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="date", required = true) String date)
    {
        TodoListDTO todoListDTO = new TodoListDTO(title, description, date);
        todoListService.save(new TodoList(todoListDTO));
    }
}
