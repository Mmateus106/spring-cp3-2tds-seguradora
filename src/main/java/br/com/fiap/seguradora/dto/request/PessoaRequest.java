package br.com.fiap.seguradora.dto.request;

import br.com.fiap.seguradora.entity.TipoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record PessoaRequest(

        @NotNull(message = "Nome é um campo obrigatório")
        String nome,

        @NotNull(message = "Sobrenome é um campo obrigatório")
        String sobrenome,

        @Email(message = "Email inválido")
        @NotNull(message = "Email é um campo obrigatório")
        String email,

        @PastOrPresent
        LocalDate nascimento,

        TipoPessoa tipo,

        @Valid
        DocumentoRequest documento
) {
}
