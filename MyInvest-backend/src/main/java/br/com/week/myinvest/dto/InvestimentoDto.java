package br.com.week.myinvest.dto;

import br.com.week.myinvest.domain.Investimento;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class InvestimentoDto {

    private Long codigo;
    private String codigoAtivo;
    private Double valorCota;
    private Integer quantidadeCotas;
    private LocalDate dataCompra;
    private String nomeCategoria;

    public InvestimentoDto(@NonNull Investimento investimento) {
        this.codigo = investimento.getCodigo();
        this.codigoAtivo = investimento.getCodigoAtivo();
        this.valorCota = investimento.getValorCota();
        this.quantidadeCotas = investimento.getQuantidadeCotas();
        this.dataCompra = investimento.getDataCompra();
        this.nomeCategoria = investimento.getCategoria().getNome();
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

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public static List<InvestimentoDto> converter(@NonNull List<Investimento> listaInvestimentos) {
        return listaInvestimentos.stream().map(InvestimentoDto::new).collect(Collectors.toList());

    }

    public static InvestimentoDto converterCadastro(@NonNull Investimento investimento) {
        return new InvestimentoDto(investimento);
    }
}
