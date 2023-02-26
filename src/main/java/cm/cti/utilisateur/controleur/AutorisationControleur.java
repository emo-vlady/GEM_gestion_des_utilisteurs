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

import cm.cti.utilisateur.models.Autorisation;
import cm.cti.utilisateur.service.impl.AutorisationService;

@RestController
@RequestMapping("api/autorisation")
public class AutorisationControleur {
	
	@Autowired
	private AutorisationService autorisationService;
	
	@GetMapping
	public List<Autorisation> findAllClient(){
		return autorisationService.getAll();
	}
	
	@GetMapping("/{id}")
	public Autorisation findById(
			@PathVariable("id") Long id
			) {
		return autorisationService.find(id);
	}
	@PostMapping
	public Autorisation create(
			@RequestBody Autorisation autorisation
			) {
		autorisation.setId(null);
		
		autorisationService.add(autorisation);
		return autorisation;
	}
	
	@PutMapping
	public Autorisation update(
			@RequestBody Autorisation autorisation
			) {	
		autorisationService.add(autorisation);
		return autorisation;
			}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
		autorisationService.delete(id);
		return "Ok";
	}


}
