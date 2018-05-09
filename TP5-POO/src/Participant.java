/**
 * Auteur  : Christian Mongeon
 * Fichier : Participant.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du système.
import java.io.*;

//Package du programmeur.
import outilsjava.*;

/**
 * La classe Participant contient les données et les méthodes pour un participant. Cette
 * classe implémente les interfaces Comparable, OutilsConstantes et Serializable.
 */

public class Participant implements Comparable <Participant>, OutilsConstantes, Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un participant.
	static final long serialVersionUID = 3;
	
	// Constantes de la classe Participant.

	public static final int MAX_MATERIEL          = 5;
	public static final int NB_CAR_NO_PARTICIPANT = 2;
	public static final int MIN_CAR_NOM           = 1;
	public static final int MAX_CAR_NOM           = 50;

	// Champs d'instance privés de la classe Participant.
	
	private String noParticipant;    // Sert de clé.
	private String nom;
	private TabObjets tabAssignMat;  // Tout le matériel informatique assigné au participant.

	/**
	 * Le constructeur Participant() permet de construire un participant de base.
	 * Aucun numéro, aucun nom et aucun matériel informatique d'assigné. 
	 */
	
	public Participant() {
		// Exécute l'autre constructeur.
		this( "", "" );
	}
	
	/**
	 * Le constructeur Participant() permet de construire un participant connaissant son
	 * numéro et son nom. Au début, aucun matériel informatique d'assigné. 
	 * 
	 * @param noParticipant
	 *            Le numéro du participant.
	 * @param nom
	 *            Le nom du participant.
	 */

	public Participant( String noParticipant, String nom ) {
		this.setNoParticipant( noParticipant );
		this.setNom( nom );
		this.tabAssignMat = new TabObjets( MAX_MATERIEL );
	}

	/**
	 * La méthode accesseur getNoParticipant() permet de retourner le numéro du participant.
	 * 
	 * @return Le numéro du participant.
	 */

	public String getNoParticipant() {
		return this.noParticipant;
	}

	/**
	 * La méthode accesseur getNom() permet de retourner le nom du participant.
	 * 
	 * @return Le nom du participant.
	 */

	public String getNom() {
		return this.nom;
	}

	/**
	 * La méthode accesseur getTabAssignMat() permet de retourner tout le matériel
	 * informatique assigné au participant.
	 * 
	 * @return Tout le matériel informatique assigné au participant.
	 */

	public TabObjets getTabAssignMat() {
		return this.tabAssignMat;
	}

	/**
	 * La méthode mutateur setNoParticipant() permet de modifier le numéro
	 * du participant par celui reçu en paramètre.
	 * 
	 * @param noParticipant
	 *            Le numéro du participant.
	 */

	public void setNoParticipant( String noParticipant ) {
		if ( noParticipant.length() <= Participant.NB_CAR_NO_PARTICIPANT ) {
			this.noParticipant = noParticipant;
		}
	}

	/**
	 * La méthode mutateur setNom() permet de modifier le nom du participant par
	 * celui reçu en paramètre.
	 * 
	 * @param nom
	 *            Le nom du participant.
	 */

	public void setNom( String nom ) {
		if ( nom.length() <= Participant.MAX_CAR_NOM ) {
			this.nom = nom;
		}
	}

	/**
	 * La méthode publique lireNoParticipant() permet de lire le numéro du participant
	 * et de modifier le champ du numéro du participant.
	 */
	
	public void lireNoParticipant() {
		final String QUEST_NO_PARTICIPANT = "\nEntrez le numéro du participant (" + 
	                                        Participant.NB_CAR_NO_PARTICIPANT + " car.) : ";

		String noParticipant = OutilsLecture.lireChaineExacte( QUEST_NO_PARTICIPANT,
															   Participant.NB_CAR_NO_PARTICIPANT );
		this.setNoParticipant( noParticipant );
	}

	/**
	 * La méthode publique lireNom() permet de lire le nom du participant
	 * et de modifier le champ du nom du participant.
	 */
	
	public void lireNom() {
		final String QUEST_NOM = "\nEntrez le nom du participant (entre " + Participant.MIN_CAR_NOM + " et " +
								 Participant.MAX_CAR_NOM + " car.) : ";

		String nom = OutilsLecture.lireChaineValide( QUEST_NOM, Participant.MIN_CAR_NOM, Participant.MAX_CAR_NOM );

		this.setNom( nom );
	}
	
	/**
	 * La méthode lireAutresRenseignements() permet de lire les autres
	 * renseignements du participant connaissant le numéro du participant.
	 */
	
	public void lireAutresRenseignements() {
		System.out.println( "\nEntrez les autres renseignements du participant numéro " + this.getNoParticipant() );

		this.lireNom();
	}

	/**
	 * La méthode afficher() permet d'afficher tous les renseignements du participant.
	 */
	
	public void afficher() {
		System.out.println( "\nRenseignements du participant.\n" );
		System.out.println( "Numéro : " + this.getNoParticipant() );
		System.out.println( "Nom :    " + this.getNom() );

		if ( tabAssignMat.estVide() ) {
			System.out.println( "\nAucun matériel informatique n'est assigné à ce participant." );
		} else {
			System.out.println( "\nListe du matériel informatique assigné à ce participant :" );

			MaterielInfo materiel;
			int nbElements = this.tabAssignMat.taille();

			for ( int i = 0; i < nbElements ; ++i ) {
				materiel = (MaterielInfo) this.tabAssignMat.obtenirObjet( i );
				materiel.afficher();
				OutilsLecture.lireEntree( OutilsConstantes.QUEST_CONTINUER );
			}

			System.out.println( "\nQuantité de matériel informatique assigné au participant : " + nbElements );
		}
	}

	/**
	 * Redéfinition de la méthode toString() de la classe Object.
	 * 
	 * @return Les informations du participant sous forme d'une chaîne de caractères.
	 */
	
	@Override
	public String toString() {

		return this.getClass().getName() + "[" + this.getNoParticipant() + "," + 
			   this.getNom() + "," + this.getTabAssignMat() + "]";
	}

	/**
	 * Redéfinition de la méthode equals() de la classe Object. L'objet courant est 
	 * égal à l'objet reçu en paramètre lorsque les numéros du participant sont égaux.
	 * 
	 * @param autreObjet
	 *            L'autre objet à comparer avec celui courant de type Object.
	 * 
	 * @return true si l'objet courant est égal à l'autre objet ou false dans le
	 *         cas contraire.
	 */
	
	@Override	
	public boolean equals( Object autreObjet ) {
		boolean egalite = false;

		// Si les deux objets pointent sur la même zone mémoire.

		if ( this == autreObjet ) {
			egalite = true;
		} else if ( autreObjet != null ) {

			if ( autreObjet instanceof Participant ) {

				// Convertir le type de l'autre objet en type Participant.
				
				Participant autre = (Participant) autreObjet;

				// Les objets sont identiques si les numéros de participant sont identiques.

				if ( this.getNoParticipant().equalsIgnoreCase( autre.getNoParticipant() ) ) {
					egalite = true;
				}
			}
		}

		return egalite;
	}

	/**
	 * Implémentation de la méthode compareTo() de l'interface Comparable. Un objet
	 * de type Participant est plus petit qu'un autre objet de type Participant,
	 * lorsque le noParticipant du premier objet est alphabétiquement plus petit que
	 * le noParticipant du deuxième objet. On ne fait pas de différence entre les
	 * caractères minuscules et les caractères majuscules.
	 * 
	 * @param autreParticipant
	 *            L'autre participant à comparer avec celui courant de type Participant.
	 * 
	 * @return Une valeur négative si le participant courant est plus petit que l'autre
	 *         participant, une valeur positive si le participant courant est plus
	 *         grand que l'autre participant ou 0 si le participant courant est
	 *         égal à l'autre participant.
	 */
	
	@Override
	public int compareTo( Participant autreParticipant ) {

		return this.getNoParticipant().compareToIgnoreCase( autreParticipant.getNoParticipant() );
	}
}