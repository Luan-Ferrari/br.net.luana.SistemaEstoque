package br.net.luana.sistema.domain.cores;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Renda;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CorRenda extends Cor {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id")
    private Renda renda;

    public CorRenda() {
    }

    public CorRenda(Integer id,
                    String referenciaNaFabrica,
                    String nome,
                    String observacoes,
                    Double quantidadeEstoque,
                    Double quantidadeKanBan,
                    UnidadeMedida unidadeMedida,
                    Renda renda) {
        super(id, referenciaNaFabrica, nome, observacoes, quantidadeEstoque,
                quantidadeKanBan, unidadeMedida);
        this.renda = renda;
    }

    public Renda getRenda() {
        return renda;
    }

    public void setRenda(Renda renda) {
        this.renda = renda;
    }
}
