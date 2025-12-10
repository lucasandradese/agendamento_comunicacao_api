package com.lucasandrade.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasandrade.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCancelamento{
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime data_hora_modificacao = LocalDateTime.now();
    Status status = Status.CANCELADO;
}
