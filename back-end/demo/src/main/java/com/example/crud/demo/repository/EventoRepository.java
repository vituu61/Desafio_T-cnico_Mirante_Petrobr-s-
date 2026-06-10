package com.example.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.demo.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
