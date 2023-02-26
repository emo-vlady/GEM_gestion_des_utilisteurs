package cm.cti.utilisateur.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Entreprise {
	private Long id;
	private String nom;
	private Long idAdress;
	private Long idAdministrateur;
}
