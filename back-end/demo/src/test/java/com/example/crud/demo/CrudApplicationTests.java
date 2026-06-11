package com.example.crud.demo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.crud.demo.entity.Evento;
import com.example.crud.demo.repository.EventoRepository;
import com.example.crud.demo.service.EventoService;

@SpringBootTest
class EventoServiceTest {

    EventoRepository repository = Mockito.mock(EventoRepository.class);

    EventoService service = new EventoService(repository);

    @Test
    void deveSalvarEvento() {

        Evento evento = new Evento();
        evento.setTitulo("Evento Teste");

        when(repository.save(any(Evento.class)))
                .thenReturn(evento);

        Evento resultado = service.salvar(evento);

        assertNotNull(resultado);
    }

    @Test
    void deveBuscarEventoPorId() {

        Evento evento = new Evento();
        evento.setId(1L);

        when(repository.findById(1L))
                .thenReturn(Optional.of(evento));

        Optional<Evento> resultado =
                service.buscarPorId(1L);

        assertTrue(resultado.isPresent());
    }

    @Test
    void deveRealizarSoftDelete() {

        Evento evento = new Evento();
        evento.setId(1L);
        evento.setDeleted(false);

        when(repository.findById(1L))
                .thenReturn(Optional.of(evento));

        service.deletar(1L);

        assertTrue(evento.getDeleted());

        verify(repository).save(evento);
    }
}