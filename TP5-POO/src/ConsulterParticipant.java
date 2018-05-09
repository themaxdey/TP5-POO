/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : ConsulterParticipant.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterParticipant permet de faire des consultations de participants au programme de réemploi
 * de matériel informatique de MomoTech. Cette classe implémente l'interface OutilsConstantes.
 */

public class ConsulterParticipant implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterParticipant() permet de gérer les consultations de participants
	 * au programme de réemploi de matériel informatique de MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
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

				participant = new Participant();
				
				participant.lireNoParticipant();
				
				indParticipant = momoTech.getTabParticipants().chercher(participant);
				
				if ( indParticipant == -1) {
					System.out.println(MESS_VIDE);
				} else {
					participant = (Participant) momoTech.getTabParticipants().obtenirObjet(indParticipant);
					
					participant.afficher();
				}


				//--------------------------------------------------------
				rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_PARTICIPANT );
				
			} while ( rep == OUI );
		}
	}
}