package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name="Funcionario.findAll", query="select f from Funcionario as f")

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String matricula;

    private String nome;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    List<Dependente> dependentes;

    public Funcionario() {
        dependentes = new ArrayList<>();
    }

    public Funcionario(String cpf, String matricula, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        dependentes = new ArrayList<>();
    }

    public void adicionaDependente(Dependente dependente) {
        if(dependentes != null){
            dependentes.add(dependente);
            return;
        }
        dependentes = new ArrayList<>();
        dependentes.add(dependente);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dependentes=" + dependentes.toString() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
