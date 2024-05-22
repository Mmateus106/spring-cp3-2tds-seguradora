package br.com.fiap.seguradora.dto.response;

import br.com.fiap.seguradora.entity.Foto;

import java.math.BigDecimal;
import java.util.Collection;

public record ImovelResponse(

        BigDecimal valor,

        Integer banheiros,

        String descricao,

        Integer vagasGaragem,

        Integer quartos,

        Collection<Foto> fotos,

        EnderecoResponse endereco,

        Long id,

        Float metrosQuadrados
) {
}
