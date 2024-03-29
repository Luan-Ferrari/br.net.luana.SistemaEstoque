package br.net.luana.sistema.services.materiaPrimaService;

import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.ColcheteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ColcheteServiceImpl extends MateriaPrimaServiceImpl<Colchete, Integer>
        implements ColcheteService {

    private ColcheteRepository colcheteRepository;

    public ColcheteServiceImpl(ColcheteRepository colcheteRepository) {
        super(colcheteRepository);
    }
}
