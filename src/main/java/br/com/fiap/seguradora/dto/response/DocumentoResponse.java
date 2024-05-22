package br.com.fiap.seguradora.dto.response;

import br.com.fiap.seguradora.entity.Foto;
import br.com.fiap.seguradora.entity.TipoDocumento;
import lombok.Builder;

import java.util.Collection;

@Builder
public record DocumentoResponse(

        TipoDocumento tipo,

        Long id,

        Collection<Foto> fotos,

        String numero
) {
}
