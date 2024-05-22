package br.com.fiap.seguradora.dto.response;

import br.com.fiap.seguradora.entity.Foto;
import br.com.fiap.seguradora.entity.TipoPessoa;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Collection;

@Builder
public record PessoaResponse(

        TipoPessoa tipo,

        Long id,

        LocalDate nascimento,

        String sobrenome,

        Collection<Foto> fotos,

        DocumentoResponse documento,

        Collection<EnderecoResponse> enderecos,

        String nome,

        String email
) {
}
