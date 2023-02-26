package cm.cti.utilisateur.service;

import cm.cti.utilisateur.models.Autorisation;

public interface AutorisationIService  extends ICrudService<Autorisation, Long>{
	Autorisation findByName(String name);
}
