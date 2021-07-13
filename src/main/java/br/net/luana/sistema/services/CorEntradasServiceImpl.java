package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.CorEntradas;
import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.repositories.CorEntradasRepository;
import br.net.luana.sistema.repositories.corRepositories.CorRepository;
import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CorEntradasServiceImpl extends MasterServiceImpl<CorEntradas, Integer>
        implements CorEntradasService {

    @Autowired
    private CorEntradasRepository corEntradasRepository;
    @Autowired
    private CorRepository corRepository;

    public CorEntradasServiceImpl(CorEntradasRepository corEntradasRepository) {
        super(corEntradasRepository);
    }

    public Cor buscarCor(Integer id) {
        Optional<Cor> cor = corRepository.findById(id);
        return cor.orElseThrow(
                () -> new ObjectNotFoundException(id));
    }

    public void acrescentarQuantidadeCorEstoque(Cor cor, Double quantidade) {
        cor.acrescentarQuantidade(quantidade);
        corRepository.save(cor);
    }

    public void diminuirQuantidadeCorEstoque(Cor cor, Double quantidade) {
        cor.diminuirQuantidade(quantidade);
        corRepository.save(cor);
    }

    @Override
    public CorEntradas save(CorEntradas entity) {
        acrescentarQuantidadeCorEstoque(buscarCor(entity.getCor().getId()), entity.getQuantidade());
        return corEntradasRepository.save(entity);
    }

    @Override
    protected void updateData(CorEntradas updateEntity, CorEntradas entity) {
        updateEntity.setDataEntrada(entity.getDataEntrada());
        updateEntity.setDataFim(entity.getDataFim());
        updateEntity.setPreco(entity.getPreco());

        if (updateEntity.getQuantidade() != entity.getQuantidade()
                && updateEntity.getCor().getId() != entity.getCor().getId()) {
            diminuirQuantidadeCorEstoque(buscarCor(updateEntity.getCor().getId()), updateEntity.getQuantidade());
            acrescentarQuantidadeCorEstoque(buscarCor(entity.getCor().getId()), entity.getQuantidade());

        } else {
            if (updateEntity.getQuantidade() > entity.getQuantidade()) {
                diminuirQuantidadeCorEstoque(buscarCor(updateEntity.getCor().getId()),
                        (updateEntity.getQuantidade() - entity.getQuantidade()));
            } else if (updateEntity.getQuantidade() < entity.getQuantidade()) {
                acrescentarQuantidadeCorEstoque(buscarCor(entity.getCor().getId()),
                        (entity.getQuantidade() - updateEntity.getQuantidade()));
            }
            if (updateEntity.getCor().getId() != entity.getCor().getId()) {
                diminuirQuantidadeCorEstoque(buscarCor(updateEntity.getCor().getId()), updateEntity.getQuantidade());
                acrescentarQuantidadeCorEstoque(buscarCor(entity.getCor().getId()), entity.getQuantidade());
            }
        }
        updateEntity.setQuantidade(entity.getQuantidade());
        updateEntity.setCor(entity.getCor());
    }
}
