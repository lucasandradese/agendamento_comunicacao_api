package com.lucasandrade.controller;

import com.lucasandrade.Dto.DtoRequest;
import com.lucasandrade.Dto.DtoResponse;
import com.lucasandrade.Mapper.ComunicacaoMapper;
import com.lucasandrade.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/agendamento/")
public class ComunicacaoController {

    private final AgendamentoService agendamentoService;
    private final ComunicacaoMapper comunicacaoMapper;

    public ComunicacaoController(AgendamentoService agendamentoService, ComunicacaoMapper comunicacaoMapper) {
        this.agendamentoService = agendamentoService;
        this.comunicacaoMapper = comunicacaoMapper;
    }

    @PostMapping
    public ResponseEntity<DtoResponse> criar(@RequestBody DtoRequest payload){
        return ResponseEntity.created(URI.create("/" + payload.id()))
                .body(agendamentoService
                        .save(payload));

    }

    @GetMapping("{id}")
    public ResponseEntity<DtoResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(agendamentoService.getById(id));
    }
}
