package cm.cti.utilisateur.service;

import java.util.List;

import cm.cti.utilisateur.models.Personne;

public interface PersonneIService extends ICrudService<Personne, Long> {

	List<Personne> findByNom (String nom);
	List<Personne> findByPrenom (String prenom);
}
