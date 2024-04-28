package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.BrasilApiResponseDto;
import br.org.fundatec.lpIII.atividades.model.EnderecoResponseDto;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import org.springframework.web.client.RestTemplate;
public class BrasilApiRestServiceImpl implements ExternalCepRestService {
    @Override
    public EnderecoResponseDto buscarPorCep(String cep) {
        String urlBrasilApi = "https://brasilapi.com.br/api/cep/v1/" + cep;
        RestTemplate restTemplate = new RestTemplate();
        BrasilApiResponseDto brasilApiResponse = restTemplate.getForObject(urlBrasilApi, BrasilApiResponseDto.class, cep);
        if (brasilApiResponse != null) {
            return EnderecoResponseDto.builder()
                    .origem("BrasilApi")
                    .cep(brasilApiResponse.getCep())
                    .logradouro(brasilApiResponse.getStreet())
                    .bairro(brasilApiResponse.getNeighborhood())
                    .cidade(brasilApiResponse.getCity())
                    .estado(brasilApiResponse.getState())
                    .build();
        }
        return null;
    }

    @Override
    public EnderecoResponseDto searchByCep(String cep) {
        return null;
    }
}
