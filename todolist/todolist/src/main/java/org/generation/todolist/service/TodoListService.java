package org.generation.todolist.service;

import org.generation.todolist.repository.entity.TodoList;

import java.util.ArrayList;

public interface TodoListService {

    //save method is for 2 purposes - Create new item & Update existing item
    TodoList save(TodoList todoList);


    //Delete item from database - based on item Id
    void delete(int todoListId);


    //Read all item from database
    ArrayList<TodoList> all();


    //Read an item from database - based on item Id
    TodoList findById(int todoListId);
}
