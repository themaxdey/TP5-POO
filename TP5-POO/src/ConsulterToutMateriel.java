/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : ConsulterToutMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterToutMateriel permet de faire la consultation de tout le
 * mat�riel informatique, pour le programme de r�emploi de mat�riel informatique
 * de l'entreprise MomoTech. Cette classe impl�mente l'interface
 * OutilsConstantes.
 */

public class ConsulterToutMateriel implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterToutMateriel() permet de consulter tout le mat�riel
	 * informatique, pour le programme de r�emploi de mat�riel informatique de
	 * l'entreprise MomoTech. On peut consulter tout le mat�riel, uniquement les
	 * ordinateurs, uniquement les �crans ou uniquement les imprimantes.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public ConsulterToutMateriel(MomoTech momoTech) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter tout le mat�riel informatique. "
				+ "Il n'y a aucun mat�riel destin� au r�emploi de disponible.";
		final String TITRE = "\nVoici les informations de tout le mat�riel informatique s�lectionn�.";

		if (momoTech.getTabMateriel().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			int nbElements = momoTech.getTabMateriel().taille();

			char type = OutilsLecture.lireCaractereDisparate(MaterielInfo.QUEST_TYPE_CONSULTER,
					MaterielInfo.TYPES_MATERIEL_CONSULTER);

			System.out.println(TITRE);

			int compteurMat = 0;

			for (int i = 0; i < nbElements; i++) {

				MaterielInfo matCourant = (MaterielInfo) momoTech.getTabMateriel().obtenirObjet(i);

				if (type == MaterielInfo.TOUS || type == matCourant.obtenirType()) {
					compteurMat++;
					matCourant.afficher();
					OutilsLecture.lireEntree(QUEST_CONTINUER);
				}
			}
	
			System.out.println("\nNombre d'items consult�s : " + compteurMat);

		}

	}
}