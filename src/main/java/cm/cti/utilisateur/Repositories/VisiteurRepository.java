package cm.cti.utilisateur.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cm.cti.utilisateur.models.Visiteur;



@Repository
@RepositoryRestResource(exported = false)
public interface VisiteurRepository extends JpaRepository<Visiteur, Long>{
	
	List<Visiteur> findByNom(String nom);
	List<Visiteur> findByPrenom(String prenom);
	List<Visiteur> findByCni(String cni);
	

}
