package br.com.week.myinvest.dto;

import br.com.week.myinvest.domain.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDto {

    private Long codigo;
    private String nome;
    private String descricao;

    public CategoriaDto(Categoria categoria) {
        this.codigo = categoria.getCodigo();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
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

    public static List<CategoriaDto> converter(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }
}
