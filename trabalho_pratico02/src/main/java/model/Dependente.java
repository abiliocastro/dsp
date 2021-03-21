package model;

import javax.persistence.*;

@NamedQuery(name="Dependente.findByIniciadosPorNome", query="select d from Dependente as d where lower(d.nome) like :nome")

@Entity
@Table(name = "dependentes")
public class Dependente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String cpf;

    private String nome;

    @ManyToOne
    private Funcionario funcionario;

    public Dependente() {

    }

    public Dependente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", funcionario=" + funcionario.getNome() +
                '}';
    }
}
