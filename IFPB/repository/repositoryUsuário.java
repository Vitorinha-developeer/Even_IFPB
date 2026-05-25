package Even.IFPB.repository;

import Even.IFPB.model.Usuário;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryUsuário extends JpaRepository<Usuário,Long> { // Tipo do atributo do id da classe

}
