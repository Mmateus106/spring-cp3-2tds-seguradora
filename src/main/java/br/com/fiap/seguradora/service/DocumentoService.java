package br.com.fiap.seguradora.service;

import br.com.fiap.seguradora.dto.request.DocumentoRequest;
import br.com.fiap.seguradora.dto.response.DocumentoResponse;
import br.com.fiap.seguradora.entity.Documento;
import br.com.fiap.seguradora.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class DocumentoService implements ServiceDTO<Documento, DocumentoRequest, DocumentoResponse>{

    @Autowired
    private DocumentoRepository repo;


    @Override
    public Collection<Documento> findAll(Example<Documento> example) {
        return repo.findAll(example);
    }

    @Override
    public Optional<Documento> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Documento save(Documento e) {
        return repo.save(e);
    }

    @Override
    public Documento toEntity(DocumentoRequest dto) {

        return Documento.builder()
                .tipo(dto.tipo())
                .numero(dto.numero())
                .build();
    }

    @Override
    public DocumentoResponse toResponse(Documento e) {
        return DocumentoResponse.builder()
                .tipo(e.getTipo())
                .fotos(e.getFotos())
                .numero(e.getNumero())
                .build();
    }
}
