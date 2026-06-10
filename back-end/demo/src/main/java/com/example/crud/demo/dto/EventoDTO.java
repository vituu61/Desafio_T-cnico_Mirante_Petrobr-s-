package com.example.crud.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoDTO {

    private Long id;

    private String titulo;
    private String descricao;
    private String local;

    private LocalDateTime dataEvento;
}
