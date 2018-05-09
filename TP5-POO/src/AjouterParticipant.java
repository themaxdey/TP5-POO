/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : AjouterParticipant.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AjouterParticipant permet de faire des ajouts de participants au programme de r�emploi
 * de mat�riel informatique de MomoTech. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class AjouterParticipant implements OutilsConstantes {

	/**
	 * Le constructeur AjouterParticipant() permet de g�rer les ajouts de participants
	 * au programme de r�emploi de mat�riel informatique de MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public AjouterParticipant( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_PLEIN = "\nImpossible d'ajouter un participant. Le nombre maximum " +
								  "de participants est atteint.";
		final String TITRE = "\nAjout d'un participant.";
		final String MESS_DEVENU_PLEIN = "\nAjout termin�. Le nombre maximum de participants est atteint.";
		final String QUEST_AUTRE_PARTICIPANT = "\nVoulez-vous ajouter un autre participant (O ou N) ? ";

		char rep = NON;

		if ( momoTech.getTabParticipants().estPlein() ) {
			System.out.println( MESS_PLEIN );
		} else {
			Participant participant;
			int indParticipant;

			do {
				System.out.println( TITRE );

				/**
				 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP5.
				 */
				

				//-------------------------------------------------
				// Avons-nous atteint le maximum des participants ?

				if ( momoTech.getTabParticipants().estPlein() ) {
					System.out.println( MESS_DEVENU_PLEIN );
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_PARTICIPANT );
				}
			} while ( rep == OUI );
		}
	}
}