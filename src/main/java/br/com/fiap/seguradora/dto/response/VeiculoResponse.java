package br.com.fiap.seguradora.dto.response;

import br.com.fiap.seguradora.entity.Foto;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Collection;

@Builder
public record VeiculoResponse(

        String placa,

        Long id,

        Collection<Foto> fotos,

        String marca,

        String modelo,

        String cor,

        Year ano,

        BigDecimal valor
) {
}
