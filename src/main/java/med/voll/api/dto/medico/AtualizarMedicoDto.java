package med.voll.api.dto.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.DadosEndereco;

public record AtualizarMedicoDto(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
