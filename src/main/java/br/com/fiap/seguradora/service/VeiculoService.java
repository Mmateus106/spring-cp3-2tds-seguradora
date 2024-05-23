package br.com.fiap.seguradora.service;

import br.com.fiap.seguradora.dto.request.VeiculoRequest;
import br.com.fiap.seguradora.dto.response.VeiculoResponse;
import br.com.fiap.seguradora.entity.Veiculo;
import br.com.fiap.seguradora.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class VeiculoService implements ServiceDTO<Veiculo, VeiculoRequest, VeiculoResponse> {

    @Autowired
    private VeiculoRepository repo;

    @Override
    public Collection<Veiculo> findAll(Example<Veiculo> example) {
        return repo.findAll(example);
    }

    @Override
    public Optional<Veiculo> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Veiculo save(Veiculo e) {
        return repo.save(e);
    }

    @Override
    public Veiculo toEntity(VeiculoRequest dto) {
        return Veiculo.builder()
                .chassis(dto.chassis())
                .ano(dto.ano())
                .modelo(dto.modelo())
                .placa(dto.placa())
                .marca(dto.marca())
                .cor(dto.cor())
                .build();
    }

    @Override
    public VeiculoResponse toResponse(Veiculo e) {
        return VeiculoResponse.builder()
                .placa(e.getPlaca())
                .id(e.getId())
                .fotos(e.getFotos())
                .marca(e.getMarca())
                .modelo(e.getModelo())
                .cor(e.getCor())
                .ano(e.getAno())
                .valor(e.getValor())
                .build();
    }
}
