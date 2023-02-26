package cm.cti.utilisateur.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cm.cti.utilisateur.models.Autorisation;

@Repository
@RepositoryRestResource(exported = false)
public interface AutorisationRepository extends JpaRepository<Autorisation, Long> {
	Optional<Autorisation> findByName(String name);
}
