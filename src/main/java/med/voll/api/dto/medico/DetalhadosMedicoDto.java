package med.voll.api.dto.medico;

import med.voll.api.model.Endereco;
import med.voll.api.model.medico.Especialidade;
import med.voll.api.model.medico.Medico;

public record DetalhadosMedicoDto(Long id,
                                  String nome,
                                  String email,
                                  String telefone,
                                  String crm,
                                  Especialidade especialidade,
                                  Endereco endereco) {
    public DetalhadosMedicoDto(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}
