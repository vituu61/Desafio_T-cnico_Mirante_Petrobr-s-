package com.example.crud.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.demo.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
  List<Evento> findByDeletedFalse();
}
