package cm.cti.utilisateur.service;

import java.util.List;

import cm.cti.utilisateur.models.Visiteur;

public interface VisiteurIService extends ICrudService<Visiteur, Long>{
	List<Visiteur> findByNom(String nom);
	List<Visiteur> findByPrenom(String prenom);
	List<Visiteur> findByCni(String cni);
	

}

