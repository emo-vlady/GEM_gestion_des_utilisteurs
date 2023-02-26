package cm.cti.utilisateur.service;

import java.util.List;

import cm.cti.utilisateur.models.Adress;

public interface AdressIService extends ICrudService<Adress, Long>{
	List<Adress> findByVille(String ville);
	List<Adress> findByQuartier(String quartier);
	List<Adress> findByEmail(String email);
}
