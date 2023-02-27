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
import cm.cti.utilisateur.models.Administrateur;
import cm.cti.utilisateur.service.impl.AdministrateurService;


@RestController
@RequestMapping("api/administrateur")
public class AdministrateurControleur {
	
	@Autowired
	private AdministrateurService administrateurService;
	
	@GetMapping
	public List<Administrateur> findAllClient(){
		return administrateurService.getAll();
	}
	
	@GetMapping("/{id}")
	public Administrateur findById(
			@PathVariable("id") Long id
			) {
		return administrateurService.find(id);
	}
	@PostMapping
	public Administrateur create(
			@RequestBody Administrateur administrateur
			) {
		administrateur.setId(null);
		
		administrateurService.add(administrateur);
		return administrateur;
	}
	
	@PutMapping
	public Administrateur update(
			@RequestBody Administrateur administrateur
			) {	
		administrateurService.add(administrateur);
		return administrateur;
			}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
		administrateurService.delete(id);
		return "Ok";
	}
}
