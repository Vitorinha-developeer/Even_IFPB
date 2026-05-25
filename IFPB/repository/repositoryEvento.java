package Even.IFPB.repository;

import Even.IFPB.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryEvento extends JpaRepository<Evento,Long> { // Tipo do atributo do id da classe

}