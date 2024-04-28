package br.org.fundatec.lpIII.atividades.service;

import br.org.fundatec.lpIII.atividades.model.EnderecoResponseDto;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CepService {

    private final ExternalCepRestService externalCepRestService;

    public EnderecoResponseDto buscarEndereco(String cep) {
        return externalCepRestService.buscarPorCep(cep);
    }

}
