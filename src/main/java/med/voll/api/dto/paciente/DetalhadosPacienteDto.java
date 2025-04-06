package med.voll.api.dto.paciente;

import med.voll.api.model.paciente.Paciente;

public record DetalhadosPacienteDto(Long id,
                                    String nome,
                                    String email,
                                    String telefone,
                                    String cpf) {
    public DetalhadosPacienteDto(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf());
    }
}
