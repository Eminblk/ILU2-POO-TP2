package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
		boolean vendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if(!vendeurConnu) {
			System.out.println("Je suis désolé " + nomVendeur + "mais il faut être un habitant de notre village pour commencer ici");
		}else {
			
			System.out.println("Bonjour" + nomVendeur + "je vais regarder si je peux vous trouver un étal");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Désolée" + nomVendeur + "je n'ai plus d'étal qui ne soit pas déjà occupé");
			} else {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un étal pour vous \n Il me faudrait quelques renseignements\n Quel produit souhaitez vous vendre ?");
				String produit = Clavier.entrerChaine("");
				int nbProduit = Clavier.entrerEntier("");
				int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				
				if(numeroEtal != -1) {
					System.out.println("Le vendeur " + nomVendeur + "s'est installé à l'étal n°" + numeroEtal);
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
