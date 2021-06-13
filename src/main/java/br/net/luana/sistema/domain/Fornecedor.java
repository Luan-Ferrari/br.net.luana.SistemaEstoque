package br.net.luana.sistema.domain;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Fornecedor implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;
    private String email;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "fornecedor_tipo_fornecedor",
    joinColumns = @JoinColumn(name = "fornecedor_id"),
    inverseJoinColumns = @JoinColumn(name = "tipo_fornecedor_id"))
    private List<TipoFornecedor> tipoFornecedor = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor")
    private List<MateriaPrima> materiasPrimas = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "fornecedor_contato",
    joinColumns = @JoinColumn(name = "fornecedor_id"),
    inverseJoinColumns = @JoinColumn(name = "contato_id"))
    private List<Contato> contatos = new ArrayList<>();

    public Fornecedor() {
    }

    public Fornecedor(Integer id, String nome, String cnpj, String email) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TipoFornecedor> getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(List<TipoFornecedor> tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }

    public List<MateriaPrima> getMateriasPrimas() {
        return materiasPrimas;
    }

    public void setMateriasPrimas(List<MateriaPrima> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
