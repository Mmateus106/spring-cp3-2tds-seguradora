package br.com.fiap.seguradora.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AbstractRequest(
        @Positive(message = "O Id deve ser um número positivo")

        @NotNull(message = "O id é obrigatório")
        Long id
) {
}