/**
 * Auteurs : Jean-Sébastien Beaulne et Maxime Déry et Christian Mongeon
 * Fichier : SupprimerMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe SupprimerMateriel permet de faire des suppressions de matériel
 * informatique, pour le programme de réemploi de matériel informatique de
 * l'entreprise MomoTech. Cette classe implémente l'interface OutilsConstantes.
 */

public class SupprimerMateriel implements OutilsConstantes {

	/**
	 * Le constructeur SupprimerMateriel() permet de gérer les suppressions de
	 * matériel informatique, pour le programme de réemploi de matériel
	 * informatique de l'entreprise MomoTech. On ne peut pas supprimer un
	 * matériel informatique qui est assigné à un participant.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
	 */

	public SupprimerMateriel( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de supprimer du matériel informatique. "
				+ "Il n'y a aucun matériel destiné au réemploi de disponible.";
		final String TITRE = "\nSuppression de matériel informatique.";
		final String QUEST_CONF_SUPP = "\nVoulez-vous supprimer ce matériel informatique (O ou N) ? ";
		final String MESS_DEVENU_VIDE = "\nSuppression terminée. Il ne reste plus de matériel informatique.";
		final String QUEST_AUTRE_MATERIEL = "\nVoulez-vous supprimer un autre matériel informatique (O ou N) ? ";

		char rep = NON;

		if ( momoTech.getTabMateriel().estVide() ) {
			System.out.println( MESS_VIDE );
		} else {
			MaterielInfo materiel;
			Assignation assignation;
			int indMat, indAssign;

			do {

				System.out.println( TITRE );

				materiel = MaterielInfo.creerMaterielInfo();
				materiel.lireNoMateriel();

				indMat = momoTech.getTabMateriel().chercher( materiel );

				if ( indMat == -1 ) {

					System.out.println(
							"\nLe matériel informatique numéro " + materiel.getNoMateriel() + " n'existe pas." );

				} else {

					assignation = new Assignation( materiel.getNoMateriel() );
					indAssign = momoTech.getTabAssignations().chercher( assignation );

					if ( indAssign != -1 ) {

						System.out.println( "\nLa suppression est impossible, puisque le matériel numéro "
								+ materiel.getNoMateriel() + " est assigné à un participant." );

					} else {
						char confirmation;

						materiel = (MaterielInfo) momoTech.getTabMateriel().obtenirObjet( indMat );

						materiel.afficher();

						confirmation = OutilsLecture.lireOuiNon( QUEST_CONF_SUPP );

						if ( confirmation == OUI ) {

							momoTech.getTabMateriel().supprimer( indMat );
							System.out.println( "\nLe matériel informatique numéro " + materiel.getNoMateriel()
									+ " a été supprimé." );

						} else {

							System.out.println( "\nLa suppression du matériel informatique numéro "
									+ materiel.getNoMateriel() + " a été annulée." );

						}

					}

				}

				// --------------------------------------------------------------------
				// Reste-t-il du matériel informatique pour le programme de
				// réemploi ?

				if ( momoTech.getTabMateriel().estVide() ) {

					System.out.println( MESS_DEVENU_VIDE );
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_MATERIEL );
				}
			} while ( rep == OUI );
		}
	}
}