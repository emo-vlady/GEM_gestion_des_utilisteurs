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
import cm.cti.utilisateur.models.Visiteur;
import cm.cti.utilisateur.service.impl.VisiteurService;
 
@RestController
@RequestMapping("api/visiteur")
public class VisiteurControleur {
	@Autowired
	private VisiteurService visiteurService;
	
	@GetMapping
	public List<Visiteur> findAllClient(){
		return visiteurService.getAll();
	}
	
	@GetMapping("nom/{nom}")
	public List<Visiteur> findByNom(
	 @PathVariable("nom") String nom){
		return visiteurService.findByNom(nom);
	}
	
	@GetMapping("pernom/{prenom}")
	public List<Visiteur> findByPrenom(
	 @PathVariable("prenom") String prenom){
		return visiteurService.findByNom(prenom);
	}
	
	@GetMapping("cni/{cni}")
	public List<Visiteur> findByCni(
	 @PathVariable("cni") String cni){
		return visiteurService.findByNom(cni);
	}
	
	@PostMapping
	public Visiteur create(
			@RequestBody Visiteur visiteur
			) {
		if(visiteur.getNom() == null) return null;
		if(visiteur.getCni() == null) return null;
		visiteurService.add(visiteur);
		return visiteur;
		
			}

	@PutMapping
	public Visiteur update(
			@RequestBody Visiteur visiteur
			) {	
		visiteurService.add(visiteur);
		return visiteur;
			}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
		visiteurService.delete(id);
		return "Ok";
	}
}
