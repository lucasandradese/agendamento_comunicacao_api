package com.lucasandrade.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasandrade.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_COMUNICACAO")
@Builder
public class ComunicacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email_destinatario")
    private String emailDestinatario;

    @Column(name = "tel_destinatario")
    private String telDestinatario;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "data_hora_envio")
    private LocalDateTime dataHoraEnvio;

    @Column(name = "data_hora_agendamento")
    private LocalDateTime dataHoraAgendamento;

    @Column(name = "data_hora_modificacao")
    private LocalDateTime dataHoraModificacao;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    private void prePersist(){
        dataHoraAgendamento = LocalDateTime.now();
        status = Status.AGUARDANDO;
    }
}
