/**
 * Auteurs : TODO et Christian Mongeon
 * Fichier : ConsulterAssignation.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterAssignation permet de consulter des assignations de mat�riel informatique,
 * � des participants au programme de r�emploi de mat�riel informatique de l'entreprise
 * MomoTech. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class ConsulterAssignation implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterAssignation() permet de consulter des assignations de mat�riel informatique,
     * � des participants au programme de r�emploi de mat�riel informatique de l'entreprise MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public ConsulterAssignation( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter une assignation. Il n'y a aucune " + 
		         				 "assignation de mat�riel informatique dans l'entreprise MomoTech.";
		final String TITRE = "\nConsultation d'une assignation de mat�riel informatique.";
		final String QUEST_AUTRE_ASSIGNATION = "\nVoulez-vous consulter une autre assignation de mat�riel " +
		                                       "informatique (O ou N) ? ";
		char rep = NON;

		if ( momoTech.getTabAssignations().estVide() ) {

			System.out.println( MESS_VIDE );

		} else {
			MaterielInfo materiel;
			Assignation assignation;
			int indMateriel, indAssignation;

			do {
				System.out.println( TITRE );

				/**
				 * TODO (� COMPL�TER). Voir page 14 de l'�nonc� du TP5.
				 */


				//--------------------------------------------------------
				rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_ASSIGNATION );
				
			} while ( rep == OUI );
		}
	}
}