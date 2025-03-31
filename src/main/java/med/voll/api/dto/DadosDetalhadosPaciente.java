package med.voll.api.dto;

import med.voll.api.model.Paciente;

public record DadosDetalhadosPaciente(Long id,
                                      String nome,
                                      String email,
                                      String telefone,
                                      String cpf) {
    public DadosDetalhadosPaciente(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf());
    }
}
