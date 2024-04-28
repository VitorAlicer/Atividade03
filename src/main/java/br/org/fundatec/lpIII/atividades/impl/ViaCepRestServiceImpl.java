package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.EnderecoResponseDto;
import br.org.fundatec.lpIII.atividades.model.ViaCepResponseDto;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import org.springframework.web.client.RestTemplate;

public class ViaCepRestServiceImpl implements ExternalCepRestService {
    @Override
    public EnderecoResponseDto buscarPorCep(String cep) {
        String urlViaCep = "https://viacep.com.br/ws/" + cep + "/json";
        RestTemplate restTemplate = new RestTemplate();
        ViaCepResponseDto viaCepResponse = restTemplate.getForObject(urlViaCep, ViaCepResponseDto.class, cep);
        if (viaCepResponse != null) {
            return EnderecoResponseDto.builder()
                    .origem("ViaCep")
                    .cep(viaCepResponse.getCep())
                    .logradouro(viaCepResponse.getLogradouro())
                    .bairro(viaCepResponse.getBairro())
                    .cidade(viaCepResponse.getLocalidade())
                    .estado(viaCepResponse.getUf())
                    .build();
        }
        return null;
    }

    @Override
    public EnderecoResponseDto searchByCep(String cep) {
        return null;
    }
}
