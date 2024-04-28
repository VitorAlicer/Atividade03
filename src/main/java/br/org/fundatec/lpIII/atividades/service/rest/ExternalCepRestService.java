package br.org.fundatec.lpIII.atividades.service.rest;

import br.org.fundatec.lpIII.atividades.model.EnderecoResponseDto;

public interface ExternalCepRestService {
    EnderecoResponseDto buscarPorCep(String cep);

    EnderecoResponseDto searchByCep(String cep);
}
