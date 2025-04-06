package med.voll.api.model.medico;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.voll.api.dto.medico.AtualizarMedicoDto;
import med.voll.api.dto.medico.CadastroMedicoDto;
import med.voll.api.model.Endereco;

@Entity(name = "Medico")
@Table(name = "medicos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico() {}

    public Medico(CadastroMedicoDto dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone =dados.telefone();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void atualizarInformacoes(AtualizarMedicoDto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }
}