package Even.IFPB.repository;
import Even.IFPB.model.Inscrição;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryInscricao extends JpaRepository<Inscrição,Long> { // Tipo do atributo do id da classe

}
