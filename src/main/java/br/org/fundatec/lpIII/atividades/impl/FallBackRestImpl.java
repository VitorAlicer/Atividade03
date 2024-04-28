package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.EnderecoResponseDto;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FallBackRestImpl implements ExternalCepRestService {
    private final List<String> fallbackOrder;
    private List<ExternalCepRestService> externalImpl =
            List.of(
                    new CepAbertoRestServiceImpl(),
                    new BrasilApiRestServiceImpl(),
                    new ViaCepRestServiceImpl()
            );


    public EnderecoResponseDto searchByCep(String cep) {

        EnderecoResponseDto response = null;
        for (ExternalCepRestService externalService : externalImpl) {
            try {
                 response = externalService.buscarPorCep(cep);
                 break;
            } catch (RuntimeException ex) {
                continue;
            }
        }
        return response;
    }

    @Override
    public EnderecoResponseDto buscarPorCep(String cep) {
        return null;
    }
}
