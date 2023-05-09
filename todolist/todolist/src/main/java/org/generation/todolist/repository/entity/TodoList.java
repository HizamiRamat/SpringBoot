package org.generation.todolist.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.TodoListDTO;

import java.util.Date;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;             //retrieve product item by ID - has to be an object
    private String title;
    private String description;
    private String date;

    //Item Class is used to map within the Database table
    //Any CRUD operation, JPA will make use of this Item Clas to map
    //Even for Read operation

    //Constructor Overloading
    public TodoList() {}

    //*- DTO
    public TodoList(TodoListDTO todoListDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.title = todoListDTO.getTitle();
        this.description = todoListDTO.getDescription();
        this.date = todoListDTO.getDate();

    }


    public Integer getId()
    {
        return id;
    }


    public void setId( Integer id )
    {
        this.id = id;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle( String title)
    {
        this.title = title;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription( String description)
    {
        this.description = description;
    }


    public String getDate()
    {
        return date;
    }


    public void setDate( String date)
    {
        this.date = date;
    }





    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", title='" + title + '\'' + ", description='" +
                description + ", date='" + date + '\'' +
                '}';
    }
}
