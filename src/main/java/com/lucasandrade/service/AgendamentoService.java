package com.lucasandrade.service;

import com.lucasandrade.Dto.DtoRequest;
import com.lucasandrade.Dto.DtoResponse;
import com.lucasandrade.Mapper.ComunicacaoMapper;
import com.lucasandrade.entity.ComunicacaoEntity;
import com.lucasandrade.exception.NotFountException;
import com.lucasandrade.repository.ComunicacaoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendamentoService {

    private final ComunicacaoRepository comunicacaoRepository;
    private final ComunicacaoMapper comunicacaoMapper;

    public AgendamentoService(ComunicacaoRepository comunicacaoRepository, ComunicacaoMapper comunicacaoMapper) {
        this.comunicacaoRepository = comunicacaoRepository;
        this.comunicacaoMapper = comunicacaoMapper;
    }

    public DtoResponse save(DtoRequest agendamento){

      return comunicacaoMapper.toDto(
              comunicacaoRepository.save(
                      comunicacaoMapper.toEntity(agendamento)));
    }

    public DtoResponse getById(Long id){
        return comunicacaoMapper.toDto(comunicacaoRepository.findById(id)
                .orElseThrow(()-> new NotFountException("Agendamento com o " + id + " não encontrato")));

    }
}
