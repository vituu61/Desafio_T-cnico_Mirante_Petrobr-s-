package com.example.crud.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.crud.demo.repository.EventoRepository;

@SpringBootTest
class EventoIntegrationTest {

    @Autowired
    private EventoRepository eventoRepository;

    @Test
    void deveCarregarContextoEBanco() {

        assertNotNull(eventoRepository);

    }
}