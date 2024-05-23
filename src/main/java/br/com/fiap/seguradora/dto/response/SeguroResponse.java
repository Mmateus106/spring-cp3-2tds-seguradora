package br.com.fiap.seguradora.dto.response;

import br.com.fiap.seguradora.dto.request.AbstractRequest;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record SeguroResponse(

        Long id,

        LocalDate fim,

        Object objeto,

        PessoaResponse contratante,

        Double premio,

        LocalDate inicio,

        Double valor
) {
}
