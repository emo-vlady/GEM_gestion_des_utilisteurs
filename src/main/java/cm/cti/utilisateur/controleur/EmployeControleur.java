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


import cm.cti.utilisateur.models.Employe;
import cm.cti.utilisateur.service.impl.EmployeService;


@RestController
@RequestMapping("api/employe")
public class EmployeControleur {
	@Autowired
	private EmployeService employeService;
	
	@GetMapping
	public List<Employe> findAllClient(){
		return employeService.getAll();
	}
	
	@GetMapping("/{id}")
	public Employe findById(
			@PathVariable("id") Long id
			) {
		return employeService.find(id);
	}
	@PostMapping
	public Employe create(
			@RequestBody Employe employe
			) {
		employe.setId(null);
		
		employeService.add(employe);
		return employe;
	}
	
	@PutMapping
	public Employe update(
			@RequestBody Employe employe
			) {	
		employeService.add(employe);
		return employe;
			}
	
	@DeleteMapping("/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
		employeService.delete(id);
		return "Ok";
	}


}
