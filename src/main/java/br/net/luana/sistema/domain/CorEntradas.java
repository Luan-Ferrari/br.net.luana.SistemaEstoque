package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.cores.Cor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class CorEntradas implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataFim;
    private Double preco;
    private Double quantidade;

    private Integer qtdeKanBanCriados;
    private Integer qtdeKanBanBaixados;

    @ManyToOne
    @JoinColumn(name = "cor_id")
    private Cor cor;

    @OneToMany(mappedBy = "corEntrada")
    private List<CartaoKanBan> cartoesCanKan = new ArrayList<>();

    public CorEntradas() {
    }

    public CorEntradas(Integer id,
                       LocalDate dataEntrada,
                       Double preco,
                       Double quantidade,
                       Cor cor)
    {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.preco = preco;
        this.quantidade = quantidade;
        this.cor = cor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public List<CartaoKanBan> getCartoesCanKan() {
        return cartoesCanKan;
    }

    public void setCartoesCanKan(List<CartaoKanBan> cartoesCanKan) {
        this.cartoesCanKan = cartoesCanKan;
    }

    public Integer getQtdeKanBanCriados() {
        return qtdeKanBanCriados;
    }

    public void setQtdeKanBanCriados(Integer qtdeKanBanCriados) {
        this.qtdeKanBanCriados = qtdeKanBanCriados;
    }

    public Integer getQtdeKanBanBaixados() {
        return qtdeKanBanBaixados;
    }

    public void setQtdeKanBanBaixados(Integer qtdeKanBanBaixados) {
        this.qtdeKanBanBaixados = qtdeKanBanBaixados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorEntradas that = (CorEntradas) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
