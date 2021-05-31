package br.com.week.myinvest.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo;

    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "categoria",fetch = FetchType.LAZY)
    private List<Investimento> investimento;

    public List<Investimento> getInvestimento() {
        return investimento;
    }

    public void setInvestimento(List<Investimento> investimento) {
        this.investimento = investimento;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(codigo, categoria.codigo) && Objects.equals(nome, categoria.nome) && Objects.equals(descricao, categoria.descricao) && Objects.equals(investimento, categoria.investimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, descricao, investimento);
    }
}
