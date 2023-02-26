package cm.cti.utilisateur.service;

import java.util.List;

import cm.cti.utilisateur.models.Role;

public interface RoleIService extends ICrudService<Role, Long>  {
	List<Role> findByFonction(String fonction);

}
