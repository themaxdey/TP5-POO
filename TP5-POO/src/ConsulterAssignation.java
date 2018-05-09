/**
 * Auteurs : TODO et Christian Mongeon
 * Fichier : ConsulterAssignation.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterAssignation permet de consulter des assignations de matériel informatique,
 * à des participants au programme de réemploi de matériel informatique de l'entreprise
 * MomoTech. Cette classe implémente l'interface OutilsConstantes.
 */

public class ConsulterAssignation implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterAssignation() permet de consulter des assignations de matériel informatique,
     * à des participants au programme de réemploi de matériel informatique de l'entreprise MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
	 */

	public ConsulterAssignation( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter une assignation. Il n'y a aucune " + 
		         				 "assignation de matériel informatique dans l'entreprise MomoTech.";
		final String TITRE = "\nConsultation d'une assignation de matériel informatique.";
		final String QUEST_AUTRE_ASSIGNATION = "\nVoulez-vous consulter une autre assignation de matériel " +
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
				 * TODO (À COMPLÉTER). Voir page 14 de l'énoncé du TP5.
				 */


				//--------------------------------------------------------
				rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_ASSIGNATION );
				
			} while ( rep == OUI );
		}
	}
}