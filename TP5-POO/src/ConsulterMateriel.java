/**
 * Auteurs : TODO et Christian Mongeon
 * Fichier : ConsulterMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterMateriel permet de faire des consultations de mat�riel informatique, pour le programme de
 * r�emploi de mat�riel informatique de l'entreprise MomoTech. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class ConsulterMateriel implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterMateriel() permet de g�rer les consultations de mat�riel informatique, pour le
	 * programme de r�emploi de mat�riel informatique de l'entreprise MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public ConsulterMateriel( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter du mat�riel informatique. " +
				 				 "Il n'y a aucun mat�riel destin� au r�emploi de disponible.";
		final String TITRE = "\nConsultation de mat�riel informatique.";
		final String QUEST_AUTRE_MATERIEL = "\nVoulez-vous consulter un autre mat�riel informatique (O ou N) ? ";

		char rep = NON;

		if ( momoTech.getTabMateriel().estVide() ) {
			System.out.println( MESS_VIDE );
		} else {
			MaterielInfo materiel;
			int indiceMat;

			do {
				System.out.println( TITRE );

				/**
				 * TODO (� COMPL�TER). Voir page 12 de l'�nonc� du TP5.
				 */


				//-----------------------------------------------------
				rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_MATERIEL );

			} while ( rep == OUI );
		}
	}
}