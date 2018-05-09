/**
 * Auteurs : Jean-S�bastien Beaulne et Maxime D�ry et Christian Mongeon
 * Fichier : ConsulterTousParticipants.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe ConsulterTousParticipants permet de faire la consultation de tous
 * les participants au programme de r�emploi de mat�riel informatique de
 * MomoTech. Cette classe impl�mente l'interface OutilsConstantes.
 */

public class ConsulterTousParticipants implements OutilsConstantes {

	/**
	 * Le constructeur ConsulterTousParticipants() permet de consulter tous les
	 * participants au programme de r�emploi de mat�riel informatique de MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui g�re l'entreprise MomoTech.
	 */

	public ConsulterTousParticipants(MomoTech momoTech) {
		// Constantes locales.
		final String MESS_VIDE = "\nImpossible de consulter tous les participants. Il n'y a aucun "
				+ "participant dans l'entreprise MomoTech.";
		final String TITRE = "\nVoici les informations de tous les participants.";

		int nbElements;
		Participant participant;

		if (momoTech.getTabParticipants().estVide()) {

			System.out.println(MESS_VIDE);

		} else {

			nbElements = momoTech.getTabParticipants().taille();

			System.out.println(TITRE);

			for (int i = 0; i < nbElements; i++) {

				participant = (Participant) momoTech.getTabParticipants().obtenirObjet(i);
				participant.afficher();
				OutilsLecture.lireEntree(QUEST_CONTINUER);

			}

			System.out.println(nbElements + " participants consult�s.");

		}

	}
}