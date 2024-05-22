package br.com.fiap.seguradora.dto.response;

import java.time.LocalDate;

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
