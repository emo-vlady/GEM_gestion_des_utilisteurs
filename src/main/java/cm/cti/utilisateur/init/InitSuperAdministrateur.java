package cm.cti.utilisateur.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cm.cti.utilisateur.enums.RoleEnum;
import cm.cti.utilisateur.models.Autorisation;
import cm.cti.utilisateur.service.impl.AutorisationService;


@Order(2)
@Component
public class InitSuperAdministrateur  implements ApplicationRunner{
	
	@Autowired
	private AutorisationService autorisationService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Initialisation des roles...");
		
		Autorisation gestionVisiteur = autorisationService.findByName(RoleEnum.ROLE_GESTION_VISITEUR);
		Autorisation gestionAutorisation = autorisationService.findByName(RoleEnum.ROLE_GESTION_AUTORISATION);
		Autorisation gestionEmploye = autorisationService.findByName(RoleEnum.ROLE_GESTION_EMPLOYER);
		Autorisation gestionAdministration = autorisationService.findByName(RoleEnum.ROLE_GESTION_ADMINISTRATEUR);
		
		
		if(gestionVisiteur == null) {
			autorisationService.add(new Autorisation(null, RoleEnum.ROLE_GESTION_VISITEUR));
		}
		
		if(gestionAutorisation == null) {
			autorisationService.add(new Autorisation(null, RoleEnum.ROLE_GESTION_AUTORISATION));
			
		}
		if(gestionEmploye == null) {
			autorisationService.add(new Autorisation(null, RoleEnum.ROLE_GESTION_EMPLOYER));
		}
		if(gestionAdministration == null) {
			autorisationService.add(new Autorisation(null, RoleEnum.ROLE_GESTION_ADMINISTRATEUR));
		}
		
		
	}

}
