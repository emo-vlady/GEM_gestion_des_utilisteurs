package cm.cti.utilisateur.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cm.cti.utilisateur.models.Adress;

@Repository
@RepositoryRestResource(exported = false)
public interface AdressRepository  extends JpaRepository<Adress, Long>{
	
	List<Adress> findByVille(String ville);
	List<Adress> findByQuartier(String quartier);
	List<Adress> findByEmail(String email);
	

}
