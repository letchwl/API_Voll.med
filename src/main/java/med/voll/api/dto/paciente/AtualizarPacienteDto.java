package med.voll.api.dto.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.DadosEndereco;

public record AtualizarPacienteDto(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
