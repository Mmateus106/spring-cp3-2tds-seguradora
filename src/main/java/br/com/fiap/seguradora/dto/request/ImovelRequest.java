package br.com.fiap.seguradora.dto.request;

import br.com.fiap.seguradora.entity.TipoSeguro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ImovelRequest(

        @NotNull(message = "Descrição é um campo obrigatório")
        String descricao,

        @Positive
        Float metrosQuadrados,

        @Positive
        Integer quartos,

        @Positive
        Integer banheiros,

        @Positive
        Integer vagasGaragem,

        TipoSeguro tipo,

        @Valid
        EnderecoRequest endereco
) {
}
