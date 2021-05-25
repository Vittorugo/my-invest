package br.com.week.myinvest.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "investimentos")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo;

    private String codigoAtivo;

    private Double valorCota;

    private Integer quantidadeCotas;

    private LocalDate dataCompra;

    @ManyToOne
    @JoinColumn(name = "fk_codigo_categoria")
    public Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCodigoAtivo() {
        return codigoAtivo;
    }

    public void setCodigoAtivo(String codigoAtivo) {
        this.codigoAtivo = codigoAtivo;
    }

    public Double getValorCota() {
        return valorCota;
    }

    public void setValorCota(Double valorCota) {
        this.valorCota = valorCota;
    }

    public Integer getQuantidadeCotas() {
        return quantidadeCotas;
    }

    public void setQuantidadeCotas(Integer quantidadeCotas) {
        this.quantidadeCotas = quantidadeCotas;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Investimento that = (Investimento) o;
        return Objects.equals(codigo, that.codigo) && Objects.equals(codigoAtivo, that.codigoAtivo) && Objects.equals(valorCota, that.valorCota) && Objects.equals(quantidadeCotas, that.quantidadeCotas) && Objects.equals(dataCompra, that.dataCompra) && Objects.equals(categoria, that.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, codigoAtivo, valorCota, quantidadeCotas, dataCompra, categoria);
    }
}
