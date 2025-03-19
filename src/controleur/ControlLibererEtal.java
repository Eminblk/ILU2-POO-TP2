package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Etal etal) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */ 	
	
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		Etal[] donneesEtal;
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		donneesEtal[0] = etal.isEtalOccupe();
		donneesEtal = etal.etatEtal(); 
		
		
		return donneesEtal;
	}
	
	public boolean isVendeur (String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
		
		
	}
	

}
