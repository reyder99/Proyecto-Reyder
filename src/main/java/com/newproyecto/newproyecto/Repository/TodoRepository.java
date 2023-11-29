package com.newproyecto.newproyecto.Repository;

import com.newproyecto.newproyecto.Model.Tarea;

import org.springframework.data.jpa.repository.JpaRepository;
public interface TodoRepository extends JpaRepository<Tarea, Long> {
}
