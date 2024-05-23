package br.com.fiap.seguradora.resource;

import br.com.fiap.seguradora.dto.request.DocumentoRequest;
import br.com.fiap.seguradora.dto.response.DocumentoResponse;
import br.com.fiap.seguradora.service.ServiceDTO;
import org.springframework.http.ResponseEntity;

public class DocumentoResource implements ResourceDTO<DocumentoRequest, DocumentoResponse> {

    @Override
    public ResponseEntity<DocumentoResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DocumentoResponse> save(DocumentoRequest r) {
        return null;
    }
}
