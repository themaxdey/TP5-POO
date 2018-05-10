/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : TerminerAssignation.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe TerminerAssignation permet de terminer une assignation de mat�riel
 * informatique, � des participants au programme de r�emploi de mat�riel
 * informatique de l'entreprise MomoTech. Cette classe impl�mente l'interface
 * OutilsConstantes.
 */

public class TerminerAssignation implements OutilsConstantes {

	/**
	 * Le constructeur TerminerAssignation() permet de terminer une assignation
	 * de mat�riel informatique, � des participants au programme de r�emploi de
	 * mat�riel informatique de l'entreprise MomoTech. On termine une
	 * assignation uniquement sur du mat�riel informatique qui a pr�alablement
	 * �t� assign� � un participant. Le mat�riel assign� est lui aussi supprim�,
	 * puisqu'il est maintenant pr�t � �tre r�utilis�.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public TerminerAssignation( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_MATERIEL_VIDE = "\nImpossible de terminer une assignation. "
				+ "Il n'y a aucun mat�riel destin� au r�emploi de disponible.";
		final String MESS_AUCUNE_ASSIGNATION = "\nImpossible de terminer une assignation. "
				+ "Aucun mat�riel destin� au r�emploi est pr�sentement assign�.";
		final String TITRE = "\nTerminer une assignation de mat�riel informatique.";
		final String MESS_FIN_TERMINER = "\nIl ne reste plus d'assignations de mat�riel informatique.";
		final String QUEST_TERMINER_AUTRE_ASSIGN = "\nVoulez-vous terminer une autre assignation de mat�riel "
				+ "informatique (O ou N) ? ";

		char rep = NON;

		if ( momoTech.getTabMateriel().estVide() ) {

			System.out.println( MESS_MATERIEL_VIDE );

		} else if ( momoTech.getTabAssignations().estVide() ) {

			System.out.println( MESS_AUCUNE_ASSIGNATION );

		} else {
			MaterielInfo materiel;
			Assignation assignation;
			Participant participant;
			int indMateriel, indAssignation, indParticipant;

			do {

				System.out.println( TITRE );

				materiel = MaterielInfo.creerMaterielInfo();

				materiel.lireNoMateriel();

				indMateriel = momoTech.getTabMateriel().chercher( materiel );

				if ( indMateriel == -1 ) {
					System.out.println( "Le mat�riel informatique num�ro " + indMateriel + " n'existe pas." );
				} else {
					assignation = new Assignation( materiel.getNoMateriel() );

					indAssignation = momoTech.getTabAssignations().chercher( assignation );

					if ( indAssignation == -1 ) {
						System.out.println( "\nLe mat�riel informatique num�ro " + assignation.getNoMateriel()
								+ " n'est pas assign� � un participant" );
					} else {
						assignation = (Assignation) momoTech.getTabAssignations().obtenirObjet( indAssignation );

						momoTech.getTabAssignations().supprimer( assignation );

						participant = new Participant();

						participant.setNoParticipant( assignation.getNoParticipant() );

						indParticipant = momoTech.getTabParticipants().chercher( participant );

						participant = (Participant) momoTech.getTabParticipants().obtenirObjet( indParticipant );

						participant.getTabAssignMat().supprimer( materiel );

						momoTech.getTabMateriel().supprimer( indMateriel );

						System.out.println(
								"\nLe mat�riel num�ro " + indMateriel + " qui �tait assign� au participant num�ro "
										+ indParticipant + " est pr�t � �tre r�utilis�." );
					}

				}

				// -------------------------------------------------------
				// Reste-t-il des assignations de mat�riel informatique ?

				if ( momoTech.getTabAssignations().estVide() ) {

					System.out.println( MESS_FIN_TERMINER );
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon( QUEST_TERMINER_AUTRE_ASSIGN );
				}
			} while ( rep == OUI );
		}
	}
}