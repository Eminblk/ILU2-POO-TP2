package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question2 = new StringBuilder();
					question2.append("Bienvenue villageois" + nomVisiteur + "\n");
					question2.append("Quelle est votre force ? \n");
					//TODO a completer
					int forceUtilisateur=-1;
					forceUtilisateur = Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceUtilisateur);
					break;
				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue druide \n" + nomVisiteur);
		question.append("Quelle est votre force ? \n");
		int force = Clavier.entrerEntier(question.toString());
		int effetPotionMin=-1;
		int effetPotionMax=-1;
		do {
	        System.out.println("Quelle est la force minimum de votre potion ?");
	        effetPotionMin = Clavier.entrerEntier("");

	        System.out.println("Quelle est la force maximum de votre potion ?");
	        effetPotionMax = Clavier.entrerEntier("");

	        if (effetPotionMin > effetPotionMax) {
	            System.out.println("Attention Druide, vous vous êtes trompé entre le maxiumm et le minimum");
	        }
	    } while (effetPotionMin > effetPotionMax);
		
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
	
	
	
}
