/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : ConsulterToutesAssignations.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterToutesAssignations permet de consulter toutes les
 * assignations de mat�riel informatique, � des participants au programme de
 * r�emploi de mat�riel informatique de l'entreprise MomoTech. Cette classe
 * impl�mente l'interface OutilsConstantes.
 */

public class ConsulterToutesAssignations implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterToutesAssignations() permet de consulter toutes les
	 * assignations de mat�riel informatique, � des participants au programme de
	 * r�emploi de mat�riel informatique de l'entreprise MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public ConsulterToutesAssignations(MomoTech momoTech) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter toutes les assignations. Il n'y a aucune "
				+ "assignation de mat�riel informatique dans l'entreprise MomoTech.";
		final String TITRE = "\nVoici les informations de toutes les assignations de mat�riel informatique.";

		if (momoTech.getTabAssignations().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			int nbElements = momoTech.getTabAssignations().taille();

			System.out.println(TITRE);

			for (int i = 0; i < nbElements; i++) {
				Assignation assignation = (Assignation) momoTech.getTabAssignations().obtenirObjet(i);

				assignation.afficher();

				OutilsLecture.lireEntree(QUEST_CONTINUER);
			}

			System.out.println("\nLe nombre d'assignations consult�es : " + nbElements);

		}

	}
}