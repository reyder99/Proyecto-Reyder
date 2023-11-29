package com.newproyecto.newproyecto.Controller;

import com.newproyecto.newproyecto.Model.Tarea;
import com.newproyecto.newproyecto.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;



    @GetMapping(value= "/tareas")
    public List<Tarea> getTasks(){
        return todoRepository.findAll();
    }

    @PostMapping(value="/savetarea")
    public String saveTask(@RequestBody Tarea tarea){
        System.out.println(tarea);
        todoRepository.save(tarea);
        return "Saved tarea";
    }

    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Tarea tarea){
        Tarea updatedTarea = todoRepository.findById(id).get();
        updatedTarea.setTitle(tarea.getTitle());
        updatedTarea.setDescription(tarea.getDescription());
        todoRepository.save(updatedTarea);
        return "Updated tarea";
    }

    @DeleteMapping(value="delete/{id}")
    public String deleteTask(@PathVariable long id){
        Tarea deletedTarea = todoRepository.findById(id).get();
        todoRepository.delete(deletedTarea);
        return "Deleted tarea";
    }

}
