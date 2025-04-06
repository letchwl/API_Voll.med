package med.voll.api.dto.medico;

import med.voll.api.model.medico.Especialidade;
import med.voll.api.model.medico.Medico;

public record MedicoDto(Long id,
                        String nome,
                        String email,
                        String crm,
                        Especialidade especialidade) {

    public MedicoDto(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade());
    }
}
