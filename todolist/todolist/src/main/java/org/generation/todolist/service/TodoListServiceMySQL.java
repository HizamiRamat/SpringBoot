package org.generation.todolist.service;

import org.generation.todolist.repository.entity.TodoList;
import org.generation.todolist.repository.entity.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoListServiceMySQL implements TodoListService{

    private final TodoListRepository todoListRepository;


    //Dependency Injection of another class object to this class object can be done with
    // @Autowired annotation
    public TodoListServiceMySQL(@Autowired TodoListRepository todolistRepository)
    {
        this.todoListRepository = todolistRepository;
    }


    @Override
    public TodoList save(TodoList todoList)
    {
        //Since we have done the dependency injection of the itemRepository, therefore now we
        //can call any methods from the CRUDRepository Class
        return this.todoListRepository.save(todoList);
    }


    @Override
    public void delete(int toDoListId)
    {
        this.todoListRepository.deleteById(toDoListId);


    }


    @Override
    public ArrayList<TodoList> all()
    {
        //1) @Query class provide by SpringBoot : select * from item
        //2) Repository class provided by SpringBoot : we o not need to write a single query
        ArrayList<TodoList> result = new ArrayList<>();
        todoListRepository.findAll().forEach(result::add);
        return result;
    }


    @Override
    public TodoList findById(int todolistId){
        //Optional is list that accept either a null (empty), or with item
        Optional<TodoList> item = todoListRepository.findById(todolistId);
        return item.get();
    }
}
