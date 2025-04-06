package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.paciente.AtualizarPacienteDto;
import med.voll.api.dto.paciente.CadastroPacienteDto;
import med.voll.api.dto.paciente.DetalhadosPacienteDto;
import med.voll.api.dto.paciente.PacienteDto;
import med.voll.api.model.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroPacienteDto dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        repository.save(paciente);

        var uri = uriBuilder.path("paciente/{id}").buildAndExpand(-paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhadosPacienteDto(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(PacienteDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarPacienteDto dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhadosPacienteDto(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhadosPacienteDto(paciente));
    }
}
