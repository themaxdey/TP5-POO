/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : SupprimerParticipant.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe SupprimerParticipant permet de faire des suppressions de
 * participants au programme de r�emploi de mat�riel informatique de MomoTech.
 * Cette classe impl�mente l'interface OutilsConstantes.
 */

public class SupprimerParticipant implements OutilsConstantes {

	/**
	 * Le constructeur SupprimerParticipant() permet de g�rer les suppressions de
	 * participants au programme de r�emploi de mat�riel informatique de MomoTech.
	 * On ne peut pas supprimer un participant � qui du mat�riel informatique a �t�
	 * assign�.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public SupprimerParticipant(MomoTech momoTech) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de supprimer un participant. Il n'y a aucun "
				+ "participant dans l'entreprise MomoTech.";
		final String TITRE = "\nSuppression d'un participant.";
		final String QUEST_CONF_SUPP = "\nVoulez-vous supprimer ce participant (O ou N) ? ";
		final String MESS_DEVENU_VIDE = "\nSuppression termin�e. Il ne reste plus de participants "
				+ "dans l'entreprise MomoTech.";
		final String QUEST_AUTRE_PARTICIPANT = "\nVoulez-vous supprimer un autre participant (O ou N) ? ";

		char rep = NON;

		if (momoTech.getTabParticipants().estVide()) {
			System.out.println(MESS_VIDE);
		} else {
			Participant participant;
			int indParticipant;

			do {
				System.out.println(TITRE);

				participant = new Participant();

				participant.lireNoParticipant();

				indParticipant = momoTech.getTabParticipants().chercher(participant);

				if (indParticipant == -1) {
					System.out.println(MESS_VIDE);
				} else {
					participant.afficher();

					char confirmation = OutilsLecture.lireOuiNon(QUEST_CONF_SUPP);

					if (confirmation == OUI) {
						momoTech.getTabParticipants().supprimer(indParticipant);

						System.out.println("Le participant #" + indParticipant + " a �t� supprim�.");
					} else {
						System.out.println("La suppression du participant #" + indParticipant + " a �t� annul�e.");
					}
				}

				// ---------------------------------------------------------
				// Reste-t-il des participants dans l'entreprise MomoTech ?

				if (momoTech.getTabParticipants().estVide()) {

					System.out.println(MESS_DEVENU_VIDE);
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon(QUEST_AUTRE_PARTICIPANT);
				}
			} while (rep == OUI);
		}
	}
}