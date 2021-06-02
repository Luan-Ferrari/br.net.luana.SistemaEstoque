package br.net.luana.sistema.repositories;

import br.net.luana.sistema.domain.materiasprimas.Tecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecidoRepository extends JpaRepository<Tecido, Integer> {

}
