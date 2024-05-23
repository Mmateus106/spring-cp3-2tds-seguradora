package br.com.fiap.seguradora.resource;

import br.com.fiap.seguradora.dto.request.PessoaRequest;
import br.com.fiap.seguradora.dto.response.PessoaResponse;
import br.com.fiap.seguradora.entity.Pessoa;
import br.com.fiap.seguradora.service.PessoaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource implements ResourceDTO<PessoaRequest, PessoaResponse>{

    @Autowired
    private PessoaService service;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable Long id) {

        var entity = service.findById(id);
        if (entity.isEmpty()) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity.orElse(null));
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<PessoaResponse> save(@RequestBody @Valid PessoaRequest r) {
        var entity = service.toEntity(r);
        entity = service.save(entity);

        var response = service.toResponse(entity);

        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Collection<PessoaResponse>> findAll(

            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "sobrenome", required = false) String sobrenome,
            @RequestParam(name = "email", required = false) String email


            ) {

        var pessoas = Pessoa.builder()
                .nome(nome)
                .sobrenome(sobrenome)
                .email(email)
                .build();

        var matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Pessoa> example = Example.of(pessoas, matcher);

        var entities = service.findAll(example);

        if (entities.isEmpty()) return ResponseEntity.notFound().build();

        var response = entities.stream().map(service::toResponse).toList();

        return ResponseEntity.ok(response);

    }
}
