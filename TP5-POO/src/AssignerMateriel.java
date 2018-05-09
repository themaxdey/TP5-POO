/**
 * Auteurs : Jean-Sébastien Beaulne et Maxime Déry et Christian Mongeon
 * Fichier : AssignerMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AssignerMateriel permet d'assigner du matériel informatique, à des
 * participants au programme de réemploi de matériel informatique de
 * l'entreprise MomoTech. Cette classe implémente l'interface OutilsConstantes.
 */

public class AssignerMateriel implements OutilsConstantes {

	/**
	 * Le constructeur AssignerMateriel() permet d'assigner du matériel
	 * informatique, à des participants au programme de réemploi de matériel
	 * informatique de l'entreprise MomoTech. On assigne uniquement du matériel
	 * informatique qui n'est pas déjà assigné à un participant.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
	 */

	public AssignerMateriel( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_MATERIEL_VIDE = "\nImpossible d'assigner du matériel informatique. "
				+ "Il n'y a aucun matériel destiné au réemploi de disponible.";
		final String MESS_TOUT_ASSIGNE = "\nImpossible d'assigner du matériel informatique. Tout le matériel "
				+ "destiné au réemploi est déjà assigné.";
		final String MESS_PARTICIP_VIDE = "\nImpossible d'assigner du matériel informatique. Il n'y a aucun "
				+ "participant dans l'entreprise MomoTech.";
		final String TITRE = "\nAssigner du matériel informatique.";
		final String MESS_FIN_ASSIGNATION = "\nIl ne reste plus de matériel informatique à assigner.";
		final String QUEST_AUTRE_ASSIGN = "\nVoulez-vous assigner un autre matériel informatique (O ou N) ? ";

		char rep = NON;

		if ( momoTech.getTabMateriel().estVide() ) {

			System.out.println( MESS_MATERIEL_VIDE );

		} else if ( momoTech.getTabAssignations().taille() == momoTech.getTabMateriel().taille() ) {

			System.out.println( MESS_TOUT_ASSIGNE );

		} else if ( momoTech.getTabParticipants().estVide() ) {

			System.out.println( MESS_PARTICIP_VIDE );

		} else {
			MaterielInfo materiel;
			Assignation assignation;
			Participant participant;
			int indMateriel, indAssignation, indParticipant;

			do {
				System.out.println( TITRE );

				/**
				 * TODO (À COMPLÉTER). Voir pages 15 et 16 de l'énoncé du TP5.
				 */

				materiel = MaterielInfo.creerMaterielInfo();
				materiel.lireNoMateriel();

				indMateriel = momoTech.getTabMateriel().chercher( materiel );

				if ( indMateriel == -1 ) {

					System.out.println(
							"\nLe matériel informatique numéro " + materiel.getNoMateriel() + " n'existe pas." );

				} else {

					assignation = new Assignation( materiel.getNoMateriel() );
					indAssignation = momoTech.getTabAssignations().chercher( assignation );

					if ( indAssignation != -1 ) {

						System.out.println( "\nLe matériel informatique numéro " + materiel.getNoMateriel()
								+ " est déjà assigné à un participant." );

					} else {

						participant = new Participant();
						participant.lireNoParticipant();

						indParticipant = momoTech.getTabParticipants().chercher( participant );

						if ( indParticipant == -1 ) {

							System.out.println(
									"\nLe participant numéro " + participant.getNoParticipant() + " n'existe pas." );

						} else {

							participant = (Participant) momoTech.getTabParticipants().obtenirObjet( indParticipant );

							if ( participant.getTabAssignMat().estPlein() ) {

								System.out.println( "\nL'assignation est impossible, car le participant numéro "
										+ participant.getNoParticipant() + " a atteint le maximum d'assignations" );

							} else {

								assignation.setNoParticipant( participant.getNoParticipant() );
								momoTech.getTabAssignations().ajouter( assignation );

								materiel = (MaterielInfo) momoTech.getTabMateriel().obtenirObjet( indMateriel );

								materiel.setAssigne( true );
								participant.getTabAssignMat().ajouter( materiel );

								System.out.println( "\nLe matériel informatique numéro " + materiel.getNoMateriel()
										+ " est assigné au participant numéro " + participant.getNoParticipant()
										+ "." );

							}

						}

					}

				}

				// ------------------------------------------------------------
				// Reste-t-il du matériel informatique qui n'est pas assigné ?

				if ( momoTech.getTabAssignations().taille() == momoTech.getTabMateriel().taille() ) {

					System.out.println( MESS_FIN_ASSIGNATION );
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_ASSIGN );
				}
			} while ( rep == OUI );
		}
	}
}