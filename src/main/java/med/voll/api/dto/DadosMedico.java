package med.voll.api.dto;

import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record DadosMedico(Long id,
                          String nome,
                          String email,
                          String crm,
                          Especialidade especialidade) {

    public DadosMedico(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade());
    }
}
