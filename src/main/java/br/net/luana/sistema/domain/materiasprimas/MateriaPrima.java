package br.net.luana.sistema.domain.materiasprimas;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.domain.enums.UnidadeMedida;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MateriaPrima implements MasterDomain, MateriaPrimaInterface, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String referenciaNaFabrica;
    private String observacoes = null;
    private Boolean desuso = false;
    private Integer unidadeMedida;
    private Double quantidadeKanBan;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer id,
                        String referenciaNaFabrica,
                        String observacoes,
                        Boolean desuso,
                        UnidadeMedida unidadeMedida,
                        Double quantidadeKanBan,
                        Fornecedor fornecedor) {
        this.id = id;
        this.referenciaNaFabrica = referenciaNaFabrica;
        this.observacoes = observacoes;
        this.desuso = desuso;
        this.unidadeMedida = (unidadeMedida==null) ? null : unidadeMedida.getCodigo();
        this.quantidadeKanBan = quantidadeKanBan;
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenciaNaFabrica() {
        return referenciaNaFabrica;
    }

    public void setReferenciaNaFabrica(String referenciaNaFabrica) {
        this.referenciaNaFabrica = referenciaNaFabrica;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getDesuso() {
        return desuso;
    }

    public void setDesuso(Boolean desuso) {
        this.desuso = desuso;
    }

    public UnidadeMedida getUnidadeMedida() {
        return UnidadeMedida.toEnum(unidadeMedida);
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida.getCodigo();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getQuantidadeKanBan() {
        return quantidadeKanBan;
    }

    public void setQuantidadeKanBan(Double quantidadeKanBan) {
        this.quantidadeKanBan = quantidadeKanBan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MateriaPrima that = (MateriaPrima) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void gerarRelatorios() {

    }

    @Override
    public Colecao gerarColecao(List<MateriaPrima> materiasPrima, int ano) {
        return null;
    }
}
