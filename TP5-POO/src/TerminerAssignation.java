/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : TerminerAssignation.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe TerminerAssignation permet de terminer une assignation de matériel
 * informatique, à des participants au programme de réemploi de matériel
 * informatique de l'entreprise MomoTech. Cette classe implémente l'interface
 * OutilsConstantes.
 */

public class TerminerAssignation implements OutilsConstantes {

	/**
	 * Le constructeur TerminerAssignation() permet de terminer une assignation
	 * de matériel informatique, à des participants au programme de réemploi de
	 * matériel informatique de l'entreprise MomoTech. On termine une
	 * assignation uniquement sur du matériel informatique qui a préalablement
	 * été assigné à un participant. Le matériel assigné est lui aussi supprimé,
	 * puisqu'il est maintenant prêt à être réutilisé.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
	 */

	public TerminerAssignation( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_MATERIEL_VIDE = "\nImpossible de terminer une assignation. "
				+ "Il n'y a aucun matériel destiné au réemploi de disponible.";
		final String MESS_AUCUNE_ASSIGNATION = "\nImpossible de terminer une assignation. "
				+ "Aucun matériel destiné au réemploi est présentement assigné.";
		final String TITRE = "\nTerminer une assignation de matériel informatique.";
		final String MESS_FIN_TERMINER = "\nIl ne reste plus d'assignations de matériel informatique.";
		final String QUEST_TERMINER_AUTRE_ASSIGN = "\nVoulez-vous terminer une autre assignation de matériel "
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
					System.out.println( "Le matériel informatique numéro " + indMateriel + " n'existe pas." );
				} else {
					assignation = new Assignation( materiel.getNoMateriel() );

					indAssignation = momoTech.getTabAssignations().chercher( assignation );

					if ( indAssignation == -1 ) {
						System.out.println( "\nLe matériel informatique numéro " + assignation.getNoMateriel()
								+ " n'est pas assigné à un participant" );
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
								"\nLe matériel numéro " + indMateriel + " qui était assigné au participant numéro "
										+ indParticipant + " est prêt à être réutilisé." );
					}

				}

				// -------------------------------------------------------
				// Reste-t-il des assignations de matériel informatique ?

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