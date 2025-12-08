package com.lucasandrade.service;

import com.lucasandrade.Dto.DtoRequest;
import com.lucasandrade.Dto.DtoResponse;
import com.lucasandrade.Mapper.ComunicacaoMapper;
import com.lucasandrade.repository.ComunicacaoRepository;
import org.springframework.stereotype.Service;

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
}
