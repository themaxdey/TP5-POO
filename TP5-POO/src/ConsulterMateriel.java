/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : ConsulterMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterMateriel permet de faire des consultations de matériel
 * informatique, pour le programme de réemploi de matériel informatique de
 * l'entreprise MomoTech. Cette classe implémente l'interface OutilsConstantes.
 */

public class ConsulterMateriel implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterMateriel() permet de gérer les consultations de
	 * matériel informatique, pour le programme de réemploi de matériel informatique
	 * de l'entreprise MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
	 */

	public ConsulterMateriel(MomoTech momoTech) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter du matériel informatique. "
				+ "Il n'y a aucun matériel destiné au réemploi de disponible.";
		final String TITRE = "\nConsultation de matériel informatique.";
		final String QUEST_AUTRE_MATERIEL = "\nVoulez-vous consulter un autre matériel informatique (O ou N) ? ";

		char rep = NON;

		if (momoTech.getTabMateriel().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			MaterielInfo materiel;
			int indiceMat;

			do {
				System.out.println(TITRE);

				materiel = MaterielInfo.creerMaterielInfo();

				materiel.lireNoMateriel();

				indiceMat = momoTech.getTabMateriel().chercher(materiel);

				if (indiceMat == -1) {
					System.out.println(MESS_VIDE);
				} else {
					materiel = (MaterielInfo) momoTech.getTabMateriel().obtenirObjet(indiceMat);

					materiel.afficher();
				}

				// -----------------------------------------------------
				rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_MATERIEL);

			} while (rep == OUI);
		}
	}
}