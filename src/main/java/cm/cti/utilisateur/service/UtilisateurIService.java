package cm.cti.utilisateur.service;

import cm.cti.utilisateur.models.Utilisateur;

public interface UtilisateurIService extends ICrudService<Utilisateur, Long> {
	Utilisateur findByUsername(String username);
}
