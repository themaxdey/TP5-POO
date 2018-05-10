/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : PrincipalTp5.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Packages du système.
import java.io.*;
import java.nio.file.*;
import java.util.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe PrincipalTp5 permet de gérer un menu principal pour le TP5. Il
 * s'agit d'un programme de réemploi de matériel informatique par l'entreprise
 * MomoTech. Cette classe implémente l'interface OutilsConstantes.
 */

public class PrincipalTp5 implements OutilsConstantes {

	/**
	 * Le constructeur PrincipalTp5() permet de créer l'objet pour l'entreprise
	 * MomoTech et de préparer la gestion de l'entreprise.
	 */

	public PrincipalTp5() {
		// Constantes.
		final String MESS_BIENVENUE = "\nBienvenue au programme de réemploi de matériel informatique de MomoTech.";

		final String QUEST_FIC_MOMOTECH = "\nEntrez le nom du fichier qui contient les données "
				+ "de l'entreprise MomoTech : ";

		final String ERREUR_FIC_MOMOTECH = "\nUne erreur est survenue avec le fichier de MomoTech.";

		System.out.println( MESS_BIENVENUE );

		MomoTech momoTech = new MomoTech();

<<<<<<< HEAD
		// Nom physique du fichier.
		String nomFichier;

		// Nom logique du fichier binaire en lecture.
		ObjectInputStream ficLecture;

		nomFichier = OutilsFichier.lireNomFichier( QUEST_FIC_MOMOTECH );
		ficLecture = preparerOuvertureFichier( nomFichier, momoTech );

		if ( ficLecture == null ) {

			System.out.println( ERREUR_FIC_MOMOTECH );

		} else {

			momoTech = MomoTech.lireFicBin( ficLecture );

			OutilsFichier.fermerFicBinLecture( ficLecture, nomFichier );

			gererMenuPrincipal( momoTech );

			sauvegarderFichier( nomFichier, momoTech );

		}
=======
		String nomFichier;

		gererMenuPrincipal(momoTech);
>>>>>>> 651fa1284ec4f8b990f031a714d862cae5285d7c

		// ------------------------------------
		System.out.println( MESS_FIN_PROG );
	}

	/**
	 * La méthode privée gererMenuPrincipal() permet de traiter le menu
	 * principal pour la gestion de MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
	 */

	private void gererMenuPrincipal( MomoTech momoTech ) {
		// Constante pour les noms de mois.

		// Erreur au mot |o|ctobre.
<<<<<<< HEAD
		final String[] tabMois = { "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août",
				"septembre", "cctobre", "novembre", "décembre" };
=======
		final String[] tabMois = { "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre",
				"cctobre", "novembre", "décembre" };
>>>>>>> 651fa1284ec4f8b990f031a714d862cae5285d7c

		// Obtenir la date d'aujourd'hui.

		GregorianCalendar aujourdhui = new GregorianCalendar();

		int annee = aujourdhui.get( GregorianCalendar.YEAR );
		int mois = aujourdhui.get( GregorianCalendar.MONTH );
		int jour = aujourdhui.get( GregorianCalendar.DAY_OF_MONTH );

		// Constante pour le texte du menu principal.

		final String MENU_PRINCIPAL = "\nMenu principal pour la gestion de MomoTech.\n" + "Date : " + jour + " "
				+ tabMois[mois] + " " + annee + "\n\n" + "1. Gérer le matériel informatique\n"
				+ "2. Gérer les participants\n" + "3. Gérer les assignations\n" + "4. Quitter le programme";

		// Constantes pour les choix du menu principal.

		final char GERER_MATERIEL = '1';
		final char GERER_PARTICIPANTS = '2';
		final char GERER_ASSIGNATIONS = '3';
		final char QUITTER = '4';

		char choix;

		do {
			choix = OutilsAffichage.afficherChoisirMenu( MENU_PRINCIPAL, GERER_MATERIEL, QUITTER );

			switch ( choix ) {

			case GERER_MATERIEL:
				this.gererMateriel( momoTech );
				break;

			case GERER_PARTICIPANTS:
				this.gererParticipants( momoTech );
				break;

			case GERER_ASSIGNATIONS:
				this.gererAssignations( momoTech );
				break;
			}
		} while ( choix != QUITTER );
	}

	/**
	 * La méthode privée gererMateriel() permet de gérer tout le matériel
	 * informatique de MomoTech destiné au réemploi.
	 * 
	 * @param momoTech
	 *            L'objet qui gère MomoTech.
	 */

	private void gererMateriel( MomoTech momoTech ) {
		// Constante pour le texte du sous-menu pour gérer le matériel
		// informatique destiné au réemploi.

		final String MENU_MATERIEL = "\nSous-menu pour la gestion du matériel informatique\n\n"
				+ "1. Ajouter du matériel informatique\n" + "2. Supprimer du matériel informatique\n"
				+ "3. Consulter du matériel informatique\n" + "4. Consulter tout le matériel informatique\n"
				+ "5. Quitter ce sous-menu";

		// Constantes pour les choix du sous-menu pour gérer le matériel
		// informatique.

		final char AJOUTER_MATERIEL = '1';
		final char SUPPRIMER_MATERIEL = '2';
		final char CONSULTER_MATERIEL = '3';
		final char CONSULTER_TOUT_MATERIEL = '4';
		final char QUITTER_SOUS_MENU = '5';

		char choix;

		do {
			choix = OutilsAffichage.afficherChoisirMenu( MENU_MATERIEL, AJOUTER_MATERIEL, QUITTER_SOUS_MENU );

			switch ( choix ) {

			case AJOUTER_MATERIEL:
				new AjouterMateriel( momoTech );
				break;

			case SUPPRIMER_MATERIEL:
				new SupprimerMateriel( momoTech );
				break;

			case CONSULTER_MATERIEL:
				new ConsulterMateriel( momoTech );
				break;

			case CONSULTER_TOUT_MATERIEL:
				new ConsulterToutMateriel( momoTech );
				break;

			case QUITTER_SOUS_MENU:
				System.out.println( "\nFin du sous-menu pour la gestion du matériel informatique." );
				break;
			}
		} while ( choix != QUITTER_SOUS_MENU );
	}

	/**
	 * La méthode privée gererParticipants() permet de gérer tous les
	 * participants au programme de réemploi de matériel informatique de
	 * MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui gère MomoTech.
	 */

	private void gererParticipants( MomoTech momoTech ) {
		// Constante pour le texte du sous-menu pour gérer les participants.

		final String MENU_PARTICIPANTS = "\nSous-menu pour la gestion des participants\n\n"
				+ "1. Ajouter un participant\n" + "2. Supprimer un participant\n" + "3. Consulter un participant\n"
				+ "4. Consulter tous les participants\n" + "5. Quitter ce sous-menu";

		// Constantes pour les choix du sous-menu pour gérer les participants.

		final char AJOUTER_PARTICIPANT = '1';
		final char SUPPRIMER_PARTICIPANT = '2';
		final char CONSULTER_PARTICIPANT = '3';
		final char CONSULTER_TOUS_PARTICIPANTS = '4';
		final char QUITTER_SOUS_MENU = '5';

		char choix;

		do {
			choix = OutilsAffichage.afficherChoisirMenu( MENU_PARTICIPANTS, AJOUTER_PARTICIPANT, QUITTER_SOUS_MENU );

			switch ( choix ) {

			case AJOUTER_PARTICIPANT:
				new AjouterParticipant( momoTech );
				break;

			case SUPPRIMER_PARTICIPANT:
				new SupprimerParticipant( momoTech );
				break;

			case CONSULTER_PARTICIPANT:
				new ConsulterParticipant( momoTech );
				break;

			case CONSULTER_TOUS_PARTICIPANTS:
				new ConsulterTousParticipants( momoTech );
				break;

			case QUITTER_SOUS_MENU:
				System.out.println( "\nFin du sous-menu pour la gestion des participants." );
				break;
			}
		} while ( choix != QUITTER_SOUS_MENU );
	}

	/**
	 * La méthode privée gererAssignations() permet de gérer les assignations de
	 * tous les participants au programme de réemploi de matériel informatique
	 * de MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui gère MomoTech.
	 */

	private void gererAssignations( MomoTech momoTech ) {
		// Constante pour le texte du sous-menu pour gérer les assignations.

		final String MENU_ASSIGNATIONS = "\nSous-menu pour la gestion des assignations\n\n"
				+ "1. Assigner du matériel informatique\n" + "2. Fin d'une assignation\n"
				+ "3. Consulter une assignation\n" + "4. Consulter toutes les assignations\n"
				+ "5. Quitter ce sous-menu";

		// Constantes pour les choix du sous-menu pour gérer les assignations.

		final char ASSIGNER = '1';
		final char FIN_ASSIGNER = '2';
		final char CONSULTER_ASSIGNATION = '3';
		final char CONSULTER_TOUTES_ASSIGNATIONS = '4';
		final char QUITTER_SOUS_MENU = '5';

		char choix;

		do {
			choix = OutilsAffichage.afficherChoisirMenu( MENU_ASSIGNATIONS, ASSIGNER, QUITTER_SOUS_MENU );

			switch ( choix ) {

			case ASSIGNER:
				new AssignerMateriel( momoTech );
				break;

			case FIN_ASSIGNER:
				new TerminerAssignation( momoTech );
				break;

			case CONSULTER_ASSIGNATION:
				new ConsulterAssignation( momoTech );
				break;

			case CONSULTER_TOUTES_ASSIGNATIONS:
				new ConsulterToutesAssignations( momoTech );
				break;

			case QUITTER_SOUS_MENU:
				System.out.println( "\nFin du sous-menu pour la gestion des assignations." );
				break;
			}
		} while ( choix != QUITTER_SOUS_MENU );
	}

	/**
	 * La méthode privée preparerOuvertureFichier() permet d'ouvrir le fichier
	 * de MomoTech en lecture. Si le fichier n'existe pas, on le crée sans
	 * aucune donnée et on ouvre ce fichier par la suite en lecture.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @param momoTech
	 *            L'objet qui gère MomoTech.
	 * @return Le nom logique du fichier si l'opération est un succès ou null
	 *         dans le cas contraire.
	 */

	private ObjectInputStream preparerOuvertureFichier( String nomFichier, MomoTech momoTech ) {

		ObjectInputStream ficLecture = null;
		ObjectOutputStream ficEcriture = null;
		Path chemin = null;
		boolean peutContinuer = true;

		try {
			chemin = Paths.get( nomFichier );
		} catch ( InvalidPathException errNomFichier ) {
			System.out.println( "\nErreur, le fichier " + nomFichier + " contient des mots illégaux." );
			peutContinuer = false;
		}
		if ( peutContinuer ) {

			if ( Files.notExists( chemin ) ) {
				ficEcriture = OutilsFichier.ouvrirFicBinEcriture( nomFichier );

				if ( ficEcriture == null ) {
					peutContinuer = false;
				} else {
					momoTech.ecrireFicBin( ficEcriture );
					OutilsFichier.fermerFicBinEcriture( ficEcriture, nomFichier );
				}
			}
		}

		if ( peutContinuer ) {
			ficLecture = OutilsFichier.ouvrirFicBinLecture( nomFichier );
		}

		// ----------------
		return ficLecture;
	}

	/**
	 * La méthode privée sauvegarderFichier() permet de sauvegarder l'objet qui
	 * gère MomoTech, reçu en paramètre, dans le fichier reçu en paramètre.
	 * 
	 * @param nomFichier
	 *            Le nom physique du fichier.
	 * @param momoTech
	 *            L'objet qui gère MomoTech.
	 */

	private void sauvegarderFichier( String nomFichier, MomoTech momoTech ) {

<<<<<<< HEAD
		ObjectOutputStream ficEcriture = null;
=======
		/**
		 * TODO (À COMPLÉTER). Voir page 54 de l'énoncé du TP5.
		 * 
		 * Cette méthode est utilisée dans la deuxième partie (pages 54 à 55 de l'énoncé
		 * du TP5).
		 */
>>>>>>> 651fa1284ec4f8b990f031a714d862cae5285d7c

	}
}