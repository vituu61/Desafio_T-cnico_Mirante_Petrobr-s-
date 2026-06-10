package com.example.crud.demo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crud.demo.entity.Evento;
import com.example.crud.demo.repository.EventoRepository;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    CommandLineRunner testDatabase(EventoRepository eventoRepository) {
        return args -> {
        
            Evento eventoTeste = new Evento();
            eventoTeste.setTitulo("Evento de Teste567567567");
            eventoTeste.setDescricao("Descrição do evento de teste");
            eventoTeste.setLocal("Local do evento de teste");
            eventoTeste.setDataEvento(LocalDateTime.now().plusDays(7));
            eventoRepository.save(eventoTeste);
             
        };
    }
}
