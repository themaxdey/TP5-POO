/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : ConsulterToutMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterToutMateriel permet de faire la consultation de tout le matériel informatique, pour le programme 
 * de réemploi de matériel informatique de l'entreprise MomoTech. Cette classe implémente l'interface OutilsConstantes.
 */

public class ConsulterToutMateriel implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterToutMateriel() permet de consulter tout le matériel informatique, pour le programme 
     * de réemploi de matériel informatique de l'entreprise MomoTech. On peut consulter tout le matériel,
	 * uniquement les ordinateurs, uniquement les écrans ou uniquement les imprimantes.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
	 */

	public ConsulterToutMateriel( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter tout le matériel informatique. " +
				 				 "Il n'y a aucun matériel destiné au réemploi de disponible.";
		final String TITRE = "\nVoici les informations de tout le matériel informatique sélectionné.";
		
		/**
		 * TODO (À COMPLÉTER). Voir page 12 de l'énoncé du TP5.
		 */

	}
}