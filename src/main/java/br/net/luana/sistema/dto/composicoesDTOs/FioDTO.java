package br.net.luana.sistema.dto.composicoesDTOs;

import br.net.luana.sistema.domain.composicoes.Fio;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.dto.ValidationsValues;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class FioDTO extends MasterDTOImpl<Fio, FioDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private String nome;

    public FioDTO() {
    }

    public FioDTO(Fio entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    @Override
    public FioDTO makeDTO(Fio entity) {
        return new FioDTO(entity);
    }

    @Override
    public Fio makeEntityfromDTO(FioDTO dto) {
        return new Fio(dto.getId(), dto.getNome());
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
}
