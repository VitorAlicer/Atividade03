package br.org.fundatec.lpIII.atividades.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoResponseDto {

    private String origem;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;

}
