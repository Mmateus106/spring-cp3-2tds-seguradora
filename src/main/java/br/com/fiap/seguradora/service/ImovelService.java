package br.com.fiap.seguradora.service;

import br.com.fiap.seguradora.dto.request.ImovelRequest;
import br.com.fiap.seguradora.dto.response.EnderecoResponse;
import br.com.fiap.seguradora.dto.response.ImovelResponse;
import br.com.fiap.seguradora.entity.Endereco;
import br.com.fiap.seguradora.entity.Imovel;
import br.com.fiap.seguradora.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ImovelService implements ServiceDTO<Imovel, ImovelRequest, ImovelResponse>{

    @Autowired
    private ImovelRepository repo;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public Collection<Imovel> findAll(Example<Imovel> example) {
        return repo.findAll(example);
    }

    @Override
    public Optional<Imovel> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Imovel save(Imovel e) {
        return repo.save(e);
    }

    @Override
    public Imovel toEntity(ImovelRequest dto) {

        Endereco endereco = enderecoService.toEntity(dto.endereco());

        return Imovel.builder()
                .quartos(dto.quartos())
                .descricao(dto.descricao())
                .banheiros(dto.banheiros())
                .vagasGaragem(dto.vagasGaragem())
                .metrosQuadrados(dto.metrosQuadrados())
                .endereco(endereco)
                .build();
    }

    @Override
    public ImovelResponse toResponse(Imovel e) {

        EnderecoResponse endereco = enderecoService.toResponse(e.getEndereco());

        return ImovelResponse.builder()
                .valor(e.getValor())
                .banheiros(e.getBanheiros())
                .descricao(e.getDescricao())
                .vagasGaragem(e.getVagasGaragem())
                .quartos(e.getQuartos())
                .fotos(e.getFotos())
                .endereco(endereco)
                .id(e.getId())
                .metrosQuadrados(e.getMetrosQuadrados())
                .build();
    }
}

