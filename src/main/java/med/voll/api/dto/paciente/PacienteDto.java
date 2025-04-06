package med.voll.api.dto.paciente;

import med.voll.api.model.paciente.Paciente;

public record PacienteDto(Long id,
                          String nome,
                          String email,
                          String cpf) {

    public PacienteDto(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf()
        );
    }
}
