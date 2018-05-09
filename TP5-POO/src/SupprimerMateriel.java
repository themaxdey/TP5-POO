/**
 * Auteurs : Jean-S�bastien Beaulne et Maxime D�ry et Christian Mongeon
 * Fichier : SupprimerMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe SupprimerMateriel permet de faire des suppressions de mat�riel
 * informatique, pour le programme de r�emploi de mat�riel informatique de
 * l'entreprise MomoTech. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class SupprimerMateriel implements OutilsConstantes {

	/**
	 * Le constructeur SupprimerMateriel() permet de g�rer les suppressions de
	 * mat�riel informatique, pour le programme de r�emploi de mat�riel
	 * informatique de l'entreprise MomoTech. On ne peut pas supprimer un
	 * mat�riel informatique qui est assign� � un participant.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public SupprimerMateriel( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de supprimer du mat�riel informatique. "
				+ "Il n'y a aucun mat�riel destin� au r�emploi de disponible.";
		final String TITRE = "\nSuppression de mat�riel informatique.";
		final String QUEST_CONF_SUPP = "\nVoulez-vous supprimer ce mat�riel informatique (O ou N) ? ";
		final String MESS_DEVENU_VIDE = "\nSuppression termin�e. Il ne reste plus de mat�riel informatique.";
		final String QUEST_AUTRE_MATERIEL = "\nVoulez-vous supprimer un autre mat�riel informatique (O ou N) ? ";

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
							"\nLe mat�riel informatique num�ro " + materiel.getNoMateriel() + " n'existe pas." );

				} else {

					assignation = new Assignation( materiel.getNoMateriel() );
					indAssign = momoTech.getTabAssignations().chercher( assignation );

					if ( indAssign != -1 ) {

						System.out.println( "\nLa suppression est impossible, puisque le mat�riel num�ro "
								+ materiel.getNoMateriel() + " est assign� � un participant." );

					} else {
						char confirmation;

						materiel = (MaterielInfo) momoTech.getTabMateriel().obtenirObjet( indMat );

						materiel.afficher();

						confirmation = OutilsLecture.lireOuiNon( QUEST_CONF_SUPP );

						if ( confirmation == OUI ) {

							momoTech.getTabMateriel().supprimer( indMat );
							System.out.println( "\nLe mat�riel informatique num�ro " + materiel.getNoMateriel()
									+ " a �t� supprim�." );

						} else {

							System.out.println( "\nLa suppression du mat�riel informatique num�ro "
									+ materiel.getNoMateriel() + " a �t� annul�e." );

						}

					}

				}

				// --------------------------------------------------------------------
				// Reste-t-il du mat�riel informatique pour le programme de
				// r�emploi ?

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