package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.CepAbertoResponseDto;
import br.org.fundatec.lpIII.atividades.model.EnderecoResponseDto;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class CepAbertoRestServiceImpl implements ExternalCepRestService {
    @Override
    public EnderecoResponseDto buscarPorCep(String cep) {
        return null;
    }

    @Override
    public EnderecoResponseDto searchByCep(String cep) {

        String urlCepAberto = "https://www.cepaberto.com/api/v3/cep?cep=" + cep;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token token=f7fc1cc9b4e5fc5969b230bd52aa33c5");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<CepAbertoResponseDto> response = restTemplate.exchange(urlCepAberto, HttpMethod.GET, entity, CepAbertoResponseDto.class);
            CepAbertoResponseDto cepAbertoResponse = response.getBody();
            if (cepAbertoResponse != null) {
                return EnderecoResponseDto.builder()
                        .origem("CepAberto")
                        .cidade(cepAbertoResponse.getCidade().getNome())
                        .estado(cepAbertoResponse.getEstado().getSigla())
                        .bairro(cepAbertoResponse.getBairro())
                        .cep(cepAbertoResponse.getCep())
                        .logradouro(cepAbertoResponse.getLogradouro())
                        .build();
            }
        } catch (HttpClientErrorException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}


