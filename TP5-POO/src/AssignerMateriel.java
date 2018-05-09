/**
 * Auteurs : Jean-S�bastien Beaulne et Maxime D�ry et Christian Mongeon
 * Fichier : AssignerMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AssignerMateriel permet d'assigner du mat�riel informatique, � des
 * participants au programme de r�emploi de mat�riel informatique de
 * l'entreprise MomoTech. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class AssignerMateriel implements OutilsConstantes {

	/**
	 * Le constructeur AssignerMateriel() permet d'assigner du mat�riel
	 * informatique, � des participants au programme de r�emploi de mat�riel
	 * informatique de l'entreprise MomoTech. On assigne uniquement du mat�riel
	 * informatique qui n'est pas d�j� assign� � un participant.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public AssignerMateriel( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_MATERIEL_VIDE = "\nImpossible d'assigner du mat�riel informatique. "
				+ "Il n'y a aucun mat�riel destin� au r�emploi de disponible.";
		final String MESS_TOUT_ASSIGNE = "\nImpossible d'assigner du mat�riel informatique. Tout le mat�riel "
				+ "destin� au r�emploi est d�j� assign�.";
		final String MESS_PARTICIP_VIDE = "\nImpossible d'assigner du mat�riel informatique. Il n'y a aucun "
				+ "participant dans l'entreprise MomoTech.";
		final String TITRE = "\nAssigner du mat�riel informatique.";
		final String MESS_FIN_ASSIGNATION = "\nIl ne reste plus de mat�riel informatique � assigner.";
		final String QUEST_AUTRE_ASSIGN = "\nVoulez-vous assigner un autre mat�riel informatique (O ou N) ? ";

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
				 * TODO (� COMPL�TER). Voir pages 15 et 16 de l'�nonc� du TP5.
				 */

				materiel = MaterielInfo.creerMaterielInfo();
				materiel.lireNoMateriel();

				indMateriel = momoTech.getTabMateriel().chercher( materiel );

				if ( indMateriel == -1 ) {

					System.out.println(
							"\nLe mat�riel informatique num�ro " + materiel.getNoMateriel() + " n'existe pas." );

				} else {

					assignation = new Assignation( materiel.getNoMateriel() );
					indAssignation = momoTech.getTabAssignations().chercher( assignation );

					if ( indAssignation != -1 ) {

						System.out.println( "\nLe mat�riel informatique num�ro " + materiel.getNoMateriel()
								+ " est d�j� assign� � un participant." );

					} else {

						participant = new Participant();
						participant.lireNoParticipant();

						indParticipant = momoTech.getTabParticipants().chercher( participant );

						if ( indParticipant == -1 ) {

							System.out.println(
									"\nLe participant num�ro " + participant.getNoParticipant() + " n'existe pas." );

						} else {

							participant = (Participant) momoTech.getTabParticipants().obtenirObjet( indParticipant );

							if ( participant.getTabAssignMat().estPlein() ) {

								System.out.println( "\nL'assignation est impossible, car le participant num�ro "
										+ participant.getNoParticipant() + " a atteint le maximum d'assignations" );

							} else {

								assignation.setNoParticipant( participant.getNoParticipant() );
								momoTech.getTabAssignations().ajouter( assignation );

								materiel = (MaterielInfo) momoTech.getTabMateriel().obtenirObjet( indMateriel );

								materiel.setAssigne( true );
								participant.getTabAssignMat().ajouter( materiel );

								System.out.println( "\nLe mat�riel informatique num�ro " + materiel.getNoMateriel()
										+ " est assign� au participant num�ro " + participant.getNoParticipant()
										+ "." );

							}

						}

					}

				}

				// ------------------------------------------------------------
				// Reste-t-il du mat�riel informatique qui n'est pas assign� ?

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