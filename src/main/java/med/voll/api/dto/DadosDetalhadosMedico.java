package med.voll.api.dto;

import med.voll.api.model.Endereco;
import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record DadosDetalhadosMedico(Long id,
                                    String nome,
                                    String email,
                                    String telefone,
                                    String crm,
                                    Especialidade especialidade,
                                    Endereco endereco) {
    public DadosDetalhadosMedico(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}
