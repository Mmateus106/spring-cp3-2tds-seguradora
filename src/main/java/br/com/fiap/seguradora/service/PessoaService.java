package br.com.fiap.seguradora.service;

import br.com.fiap.seguradora.dto.request.PessoaRequest;
import br.com.fiap.seguradora.dto.response.DocumentoResponse;
import br.com.fiap.seguradora.dto.response.EnderecoResponse;
import br.com.fiap.seguradora.dto.response.PessoaResponse;
import br.com.fiap.seguradora.entity.*;
import br.com.fiap.seguradora.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
public class PessoaService implements ServiceDTO<Pessoa, PessoaRequest, PessoaResponse>{

    @Autowired
    private PessoaRepository repo;

    @Autowired
    private DocumentoService docService;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public Collection<Pessoa> findAll(Example<Pessoa> example) {
        return repo.findAll(example);
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Pessoa save(Pessoa e) {
        return repo.save(e);
    }

    @Override
    public Pessoa toEntity(PessoaRequest dto) {

        Documento documento = docService.toEntity(dto.documento());

        return Pessoa.builder()
                .nome(dto.nome())
                .sobrenome(dto.sobrenome())
                .email(dto.email())
                .nascimento(dto.nascimento())
                .tipo(dto.tipo())
                .documento(documento)
                .build();
    }

    @Override
    public PessoaResponse toResponse(Pessoa e) {

        DocumentoResponse documento = docService.toResponse(e.getDocumento());

        Collection<EnderecoResponse> enderecos = null;
        if (Objects.nonNull(e.getEnderecos()) && !e.getEnderecos().isEmpty())
            enderecos = e.getEnderecos().stream().map(enderecoService::toResponse).toList();

        return PessoaResponse.builder()
                .nome(e.getNome())
                .sobrenome(e.getSobrenome())
                .email(e.getEmail())
                .nascimento(e.getNascimento())
                .tipo(e.getTipo())
                .enderecos(enderecos)
                .documento(documento)
                .fotos(e.getFotos())
                .build();
    }
}
