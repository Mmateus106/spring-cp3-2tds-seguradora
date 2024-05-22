package br.com.fiap.seguradora.dto.request;

import br.com.fiap.seguradora.entity.TipoDocumento;
import jakarta.validation.constraints.NotNull;

public record DocumentoRequest(
        @NotNull(message = "Número é um campo obrigatório")
        String numero,

        @NotNull(message = "Tipo é um campo obrigatório")
        TipoDocumento tipo
) {

}
