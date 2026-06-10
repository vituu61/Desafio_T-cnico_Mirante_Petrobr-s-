package com.example.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.crud.demo.entity.Evento;
import com.example.crud.demo.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // LISTAR TODOS
    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    // BUSCAR POR ID
    public Optional<Evento> buscarPorId(@NonNull Long id) {
        return eventoRepository.findById(id);
    }

    // SALVAR
    public Evento salvar(@NonNull Evento evento) {
        return eventoRepository.save(evento);
    }

    // DELETAR
    public void deletar(@NonNull Long id) {
        eventoRepository.deleteById(id);
    }

    // ATUALIZAR
    public Optional<Evento> atualizar(@NonNull Long id, @NonNull Evento eventoAtualizado) {
        Optional<Evento> eventoExistenteOpt = eventoRepository.findById(id);

        if (eventoExistenteOpt.isEmpty()) {
            return Optional.empty();
        }

        Evento eventoExistente = eventoExistenteOpt.get();
        eventoExistente.setTitulo(eventoAtualizado.getTitulo());
        eventoExistente.setDescricao(eventoAtualizado.getDescricao());
        eventoExistente.setLocal(eventoAtualizado.getLocal());
        eventoExistente.setDataEvento(eventoAtualizado.getDataEvento());

        return Optional.of(eventoRepository.save(eventoExistente));
    }
}
