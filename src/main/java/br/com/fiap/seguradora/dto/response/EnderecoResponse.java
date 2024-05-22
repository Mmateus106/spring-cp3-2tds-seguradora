package br.com.fiap.seguradora.dto.response;

public record EnderecoResponse(

        Long id,

        String logradouro,

        String complemento,

        String numero,

        String cep
) {
}
