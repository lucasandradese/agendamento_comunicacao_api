package com.lucasandrade.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasandrade.enums.Status;

import java.time.LocalDateTime;

public record DtoRequest(Long id,
                         String emailDestinatario,
                         String telDestinatario,
                         String mensagem,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                         LocalDateTime dataEnvio) {
}
