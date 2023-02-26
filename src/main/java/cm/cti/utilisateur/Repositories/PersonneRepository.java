package cm.cti.utilisateur.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cm.cti.utilisateur.models.Personne;

@Repository
@RepositoryRestResource(exported = false)
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	
	List<Personne> findByNom (String nom);
	List<Personne> findByPrenom (String prenom);
	

}
