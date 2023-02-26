package cm.cti.utilisateur.controleur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cm.cti.utilisateur.models.Role;
import cm.cti.utilisateur.service.impl.RoleService;


@RestController
@RequestMapping
public class RoleControleur {
	
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public List<Role> findAllClient(){
		return roleService.getAll();
	}
	
	@GetMapping ("fonction/{fonction}")
	public List<Role> findByFonctionList(
	 @PathVariable("fonction") String fonction){
		return roleService.findByFonction(fonction);
	}
	@PostMapping
	public Role create(
			@RequestBody Role role
			) {
		role.setId(null);
		
		roleService.add(role);
		return role;
	}
	
	@PutMapping
	public Role update(
			@RequestBody Role role
			) {	
		roleService.add(role);
		return role;
			}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
		roleService.delete(id);
		return "Ok";
	}



}
