package com.example.crud.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.demo.entity.Evento;
import com.example.crud.demo.service.EventoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;


     @GetMapping
    public ResponseEntity<List<Evento>> listarTodos() {

        List<Evento> eventos = eventoService.listarTodos();

        return ResponseEntity.ok(eventos);
    }
    // GET - buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable @NonNull Long id) {

        Optional<Evento> evento = eventoService.buscarPorId(id);

        if (evento.isPresent()) {
            return ResponseEntity.ok(evento.get());
        }

        return ResponseEntity.notFound().build();
    }

    // POST - criar evento
    @PostMapping
    public ResponseEntity<Evento> salvar(@RequestBody @NonNull Evento evento) {

        Evento novoEvento = eventoService.salvar(evento);

        return ResponseEntity.ok(novoEvento);
    }

    // DELETE - remover evento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull Long id) {

        eventoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    // PUT - atualizar evento
    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable @NonNull Long id, @RequestBody @NonNull Evento evento) {
        Optional<Evento> eventoAtualizado = eventoService.atualizar(id, evento);

        if (eventoAtualizado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(eventoAtualizado.get());
    }
}
