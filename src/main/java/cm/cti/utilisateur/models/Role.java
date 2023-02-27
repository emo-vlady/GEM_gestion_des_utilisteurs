package cm.cti.utilisateur.models;


import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "ROLE")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	//valeur = {admin, employer}
	@Column(nullable = false)
	private  String type;
	
	private String fonction;
	
	@Column(nullable = true)
	private Long idEntreprise;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "ROLE_AUTORISATION")
	private List<Autorisation> autorisations;
	

}
