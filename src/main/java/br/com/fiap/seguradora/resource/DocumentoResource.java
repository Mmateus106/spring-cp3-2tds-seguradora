package br.com.fiap.seguradora.resource;

import br.com.fiap.seguradora.dto.request.DocumentoRequest;
import br.com.fiap.seguradora.dto.response.DocumentoResponse;
import br.com.fiap.seguradora.entity.Documento;
import br.com.fiap.seguradora.entity.Foto;
import br.com.fiap.seguradora.service.DocumentoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/documentos")
public class DocumentoResource {

    @Autowired
    private DocumentoService documentoService;

    // POST /documentos
    @Transactional
    @PostMapping
    public ResponseEntity<DocumentoResponse> createDocumento(@RequestBody DocumentoRequest documentoRequest) {
        Documento documento = documentoService.toEntity(documentoRequest);
        Documento savedDocumento = documentoService.save(documento);
        DocumentoResponse response = documentoService.toResponse(savedDocumento);
        return ResponseEntity.ok(response);
    }

    // GET /documentos (by example)
    @GetMapping
    public ResponseEntity<Collection<DocumentoResponse>> getDocumentosByExample(DocumentoRequest exampleRequest) {
        Documento exampleDocumento = documentoService.toEntity(exampleRequest);
        Example<Documento> example = Example.of(exampleDocumento);
        Collection<Documento> documentos = documentoService.findAll(example);
        Collection<DocumentoResponse> response = documentos.stream().map(documentoService::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    // GET /documentos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DocumentoResponse> getDocumentoById(@PathVariable Long id) {
        Optional<Documento> documento = documentoService.findById(id);
        return documento.map(doc -> ResponseEntity.ok(documentoService.toResponse(doc)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

