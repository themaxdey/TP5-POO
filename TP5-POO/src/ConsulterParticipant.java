/**
 * Auteurs : TODO et Christian Mongeon
 * Fichier : ConsulterParticipant.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterParticipant permet de faire des consultations de participants au programme de r�emploi
 * de mat�riel informatique de MomoTech. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class ConsulterParticipant implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterParticipant() permet de g�rer les consultations de participants
	 * au programme de r�emploi de mat�riel informatique de MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public ConsulterParticipant( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter un participant. Il n'y a aucun " + 
				 		         "participant dans l'entreprise MomoTech.";
		final String TITRE = "\nConsultation d'un participant.";
		final String QUEST_AUTRE_PARTICIPANT = "\nVoulez-vous consulter un autre participant (O ou N) ? ";

		char rep = NON;

		if ( momoTech.getTabParticipants().estVide() ) {
			System.out.println( MESS_VIDE );
		} else {
			Participant participant;
			int indParticipant;

			do {
				System.out.println( TITRE );

				/**
				 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP5.
				 */


				//--------------------------------------------------------
				rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_PARTICIPANT );
				
			} while ( rep == OUI );
		}
	}
}