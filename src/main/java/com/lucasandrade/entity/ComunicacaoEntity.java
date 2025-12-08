package com.lucasandrade.entity;

import com.lucasandrade.enums.Status;
import com.lucasandrade.enums.TipoDeMensagem;
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

    @Column(name = "data", nullable = true)
    private LocalDateTime data;

    @Column(name = "tipo_de_mensagem", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoDeMensagem tipoDeMensagem;

    @Column(name = "email_destinatario", nullable = true)
    private String emailDestinatario;

    @Column(name = "tel_destinatario", nullable = true)
    private String telDestinatario;

    @Column(name = "mensagem", nullable = true)
    private String mensagem;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)
    private Status status;
}
