package com.example.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.crud.demo.entity.Evento;
import com.example.crud.demo.repository.EventoRepository;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> listarTodos() {
        return eventoRepository.findByDeletedFalse();
    }

    public Optional<Evento> buscarPorId(@NonNull Long id) {
    return eventoRepository.findById(id)
            .filter(evento -> !evento.getDeleted());
}

    public Evento salvar(@NonNull Evento evento) {
        return eventoRepository.save(evento);
    }

   public void deletar(Long id) {

    Evento evento = eventoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

    evento.setDeleted(true);

    eventoRepository.save(evento);
}

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