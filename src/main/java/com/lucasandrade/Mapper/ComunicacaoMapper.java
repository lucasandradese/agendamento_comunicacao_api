package com.lucasandrade.Mapper;


import com.lucasandrade.Dto.DtoResponse;
import com.lucasandrade.Dto.DtoRequest;
import com.lucasandrade.entity.ComunicacaoEntity;
import org.springframework.stereotype.Component;

@Component
public class ComunicacaoMapper {

    public ComunicacaoEntity toEntity(DtoRequest dtoRequest){
        ComunicacaoEntity comunicacao = new ComunicacaoEntity();

        comunicacao.setId(dtoRequest.id());
        comunicacao.setEmailDestinatario(dtoRequest.emailDestinatario());
        comunicacao.setTelDestinatario(dtoRequest.telDestinatario());
        comunicacao.setMensagem(dtoRequest.mensagem());
        comunicacao.setDataHoraEnvio(dtoRequest.dataEnvio());

        return comunicacao;
    }

    public DtoResponse toDto(ComunicacaoEntity comunicacaoEntity){
         DtoResponse dto = new DtoResponse(
                 comunicacaoEntity.getEmailDestinatario(),
                 comunicacaoEntity.getTelDestinatario(),
                 comunicacaoEntity.getMensagem(),
                 comunicacaoEntity.getDataHoraEnvio(),
                 comunicacaoEntity.getStatus()
         );

         return dto;
    }

    public ComunicacaoEntity dtoCancelamento(ComunicacaoEntity dtoCancelamento){
        ComunicacaoEntity comunicacao = new ComunicacaoEntity();
        comunicacao.setDataHoraModificacao(dtoCancelamento.getDataHoraModificacao());
        comunicacao.setStatus(dtoCancelamento.getStatus());
        return comunicacao;
    }
}
