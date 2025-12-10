package com.lucasandrade.service;

import com.lucasandrade.Dto.DtoRequest;
import com.lucasandrade.Dto.DtoResponse;
import com.lucasandrade.Mapper.ComunicacaoMapper;
import com.lucasandrade.entity.ComunicacaoEntity;
import com.lucasandrade.enums.Status;
import com.lucasandrade.exception.NotFountException;
import com.lucasandrade.repository.ComunicacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final ComunicacaoRepository repository;
    private final ComunicacaoMapper mapper;

    public AgendamentoService(ComunicacaoRepository repository, ComunicacaoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public DtoResponse save(DtoRequest agendamento){

      return mapper.toDto(
              repository.save(
                      mapper.toEntity(agendamento)));
    }

    public DtoResponse getById(Long id){
        return mapper.toDto(repository.findById(id)
                .orElseThrow(()-> new NotFountException("Agendamento com o " + id + " não encontrato")));

    }

    public DtoResponse cancelarPorId(Long id){
       ComunicacaoEntity comunicacao = repository.findById(id).orElseThrow(()-> new NotFountException("Agendamento com o " + id + " não encontrato"));

       comunicacao.setStatus(Status.CANCELADO);
       comunicacao.setDataHoraModificacao(LocalDateTime.now());
       repository.save(comunicacao);

       return mapper.toDto(comunicacao);
    }
}
