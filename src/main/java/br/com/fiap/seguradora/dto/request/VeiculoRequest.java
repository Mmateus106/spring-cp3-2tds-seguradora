package br.com.fiap.seguradora.dto.request;

import br.com.fiap.seguradora.entity.TipoSeguro;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.Year;

public record VeiculoRequest(

        @NotNull(message = "Placa é um campo obrigatório")
        String placa,

        String modelo,

        String cor,

        String marca,

        @PastOrPresent
        Year ano,

        TipoSeguro tipo
) {
}