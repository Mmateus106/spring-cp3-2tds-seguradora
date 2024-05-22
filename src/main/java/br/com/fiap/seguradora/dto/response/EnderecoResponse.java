package br.com.fiap.seguradora.dto.response;

import lombok.Builder;

@Builder
public record EnderecoResponse(

        Long id,

        String logradouro,

        String complemento,

        String numero,

        String cep
) {
}
