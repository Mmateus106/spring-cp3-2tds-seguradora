package br.com.fiap.seguradora.service;

import br.com.fiap.seguradora.dto.request.EnderecoRequest;
import br.com.fiap.seguradora.dto.response.EnderecoResponse;
import br.com.fiap.seguradora.entity.Endereco;
import br.com.fiap.seguradora.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EnderecoService implements ServiceDTO<Endereco, EnderecoRequest, EnderecoResponse>{

    @Autowired
    private EnderecoRepository repo;


    @Override
    public Collection<Endereco> findAll(Example<Endereco> example) {
        return repo.findAll(example);
    }

    @Override
    public Optional<Endereco> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Endereco save(Endereco e) {
        return repo.save(e);
    }

    @Override
    public Endereco toEntity(EnderecoRequest dto) {
        return Endereco.builder()
                .logradouro(dto.logradouro())
                .numero(dto.numero())
                .complemento(dto.complemento())
                .cep(dto.cep())
                .build();
    }

    @Override
    public EnderecoResponse toResponse(Endereco e) {
        return EnderecoResponse.builder()
                .logradouro(e.getLogradouro())
                .numero(e.getNumero())
                .complemento(e.getComplemento())
                .cep(e.getCep())
                .build();
    }
}

