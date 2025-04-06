package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.medico.AtualizarMedicoDto;
import med.voll.api.dto.medico.CadastroMedicoDto;
import med.voll.api.dto.medico.MedicoDto;
import med.voll.api.dto.medico.DetalhadosMedicoDto;
import med.voll.api.model.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroMedicoDto dados, UriComponentsBuilder uriBuilder) {
        Medico medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhadosMedicoDto(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDto>> listar(@PageableDefault(size = 10, sort = {"nome",}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(MedicoDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarMedicoDto dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhadosMedicoDto(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhadosMedicoDto(medico));
    }
}