package br.com.fiap.seguradora.service;

import br.com.fiap.seguradora.dto.request.SeguroRequest;
import br.com.fiap.seguradora.dto.response.PessoaResponse;
import br.com.fiap.seguradora.dto.response.SeguroResponse;
import br.com.fiap.seguradora.entity.Asseguravel;
import br.com.fiap.seguradora.entity.Seguro;
import br.com.fiap.seguradora.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SeguroService implements ServiceDTO<Seguro, SeguroRequest, SeguroResponse> {

    @Autowired
    private SeguroRepository repo;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private VeiculoService veiculoService;

    @Override
    public Collection<Seguro> findAll(Example<Seguro> example) {
        return repo.findAll(example);
    }

    @Override
    public Optional<Seguro> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Seguro save(Seguro e) {
        return repo.save(e);
    }

    @Override
    public Seguro toEntity(SeguroRequest dto) {

        var contratante = pessoaService.findById(dto.contratante().id()).orElse(null);

        Asseguravel objeto = null;

        if (veiculoService.findById(dto.objeto().id()).isPresent()) {
            objeto = veiculoService.findById(dto.objeto().id()).orElse(null);
            if(objeto == null) {
                if (imovelService.findById(dto.objeto().id()).isPresent()) {
                    objeto = imovelService.findById(dto.objeto().id()).orElse(null);
                } else {
                    return null;
                }
            }
        }

        return Seguro.builder()
                .premio(dto.premio())
                .valor(dto.valor())
                .inico(dto.inicio())
                .fim(dto.fim())
                .contratante(contratante)
                .objeto(objeto)
                .build();
    }

    @Override
    public SeguroResponse toResponse(Seguro e) {
        return null;
    }
}