package br.com.fiap.seguradora.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoRequest(

        @NotNull(message = "Logradouro é um campo obrigatório")
        String logradouro,

        @NotNull(message = "Número é um campo obrigatório")
        String numero,

        @NotNull(message = "Complemento é um campo obrigatório")
        String complemento,

        @NotNull(message = "CEP é campo obrigatório")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX")
        String cep
) {
}
