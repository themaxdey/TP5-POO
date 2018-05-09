/**
 * Auteur  : Christian Mongeon
 * Fichier : Participant.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du syst�me.
import java.io.*;

//Package du programmeur.
import outilsjava.*;

/**
 * La classe Participant contient les donn�es et les m�thodes pour un participant. Cette
 * classe impl�mente les interfaces Comparable, OutilsConstantes et Serializable.
 */

public class Participant implements Comparable <Participant>, OutilsConstantes, Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un participant.
	static final long serialVersionUID = 3;
	
	// Constantes de la classe Participant.

	public static final int MAX_MATERIEL          = 5;
	public static final int NB_CAR_NO_PARTICIPANT = 2;
	public static final int MIN_CAR_NOM           = 1;
	public static final int MAX_CAR_NOM           = 50;

	// Champs d'instance priv�s de la classe Participant.
	
	private String noParticipant;    // Sert de cl�.
	private String nom;
	private TabObjets tabAssignMat;  // Tout le mat�riel informatique assign� au participant.

	/**
	 * Le constructeur Participant() permet de construire un participant de base.
	 * Aucun num�ro, aucun nom et aucun mat�riel informatique d'assign�. 
	 */
	
	public Participant() {
		// Ex�cute l'autre constructeur.
		this( "", "" );
	}
	
	/**
	 * Le constructeur Participant() permet de construire un participant connaissant son
	 * num�ro et son nom. Au d�but, aucun mat�riel informatique d'assign�. 
	 * 
	 * @param noParticipant
	 *            Le num�ro du participant.
	 * @param nom
	 *            Le nom du participant.
	 */

	public Participant( String noParticipant, String nom ) {
		this.setNoParticipant( noParticipant );
		this.setNom( nom );
		this.tabAssignMat = new TabObjets( MAX_MATERIEL );
	}

	/**
	 * La m�thode accesseur getNoParticipant() permet de retourner le num�ro du participant.
	 * 
	 * @return Le num�ro du participant.
	 */

	public String getNoParticipant() {
		return this.noParticipant;
	}

	/**
	 * La m�thode accesseur getNom() permet de retourner le nom du participant.
	 * 
	 * @return Le nom du participant.
	 */

	public String getNom() {
		return this.nom;
	}

	/**
	 * La m�thode accesseur getTabAssignMat() permet de retourner tout le mat�riel
	 * informatique assign� au participant.
	 * 
	 * @return Tout le mat�riel informatique assign� au participant.
	 */

	public TabObjets getTabAssignMat() {
		return this.tabAssignMat;
	}

	/**
	 * La m�thode mutateur setNoParticipant() permet de modifier le num�ro
	 * du participant par celui re�u en param�tre.
	 * 
	 * @param noParticipant
	 *            Le num�ro du participant.
	 */

	public void setNoParticipant( String noParticipant ) {
		if ( noParticipant.length() <= Participant.NB_CAR_NO_PARTICIPANT ) {
			this.noParticipant = noParticipant;
		}
	}

	/**
	 * La m�thode mutateur setNom() permet de modifier le nom du participant par
	 * celui re�u en param�tre.
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
	 * La m�thode publique lireNoParticipant() permet de lire le num�ro du participant
	 * et de modifier le champ du num�ro du participant.
	 */
	
	public void lireNoParticipant() {
		final String QUEST_NO_PARTICIPANT = "\nEntrez le num�ro du participant (" + 
	                                        Participant.NB_CAR_NO_PARTICIPANT + " car.) : ";

		String noParticipant = OutilsLecture.lireChaineExacte( QUEST_NO_PARTICIPANT,
															   Participant.NB_CAR_NO_PARTICIPANT );
		this.setNoParticipant( noParticipant );
	}

	/**
	 * La m�thode publique lireNom() permet de lire le nom du participant
	 * et de modifier le champ du nom du participant.
	 */
	
	public void lireNom() {
		final String QUEST_NOM = "\nEntrez le nom du participant (entre " + Participant.MIN_CAR_NOM + " et " +
								 Participant.MAX_CAR_NOM + " car.) : ";

		String nom = OutilsLecture.lireChaineValide( QUEST_NOM, Participant.MIN_CAR_NOM, Participant.MAX_CAR_NOM );

		this.setNom( nom );
	}
	
	/**
	 * La m�thode lireAutresRenseignements() permet de lire les autres
	 * renseignements du participant connaissant le num�ro du participant.
	 */
	
	public void lireAutresRenseignements() {
		System.out.println( "\nEntrez les autres renseignements du participant num�ro " + this.getNoParticipant() );

		this.lireNom();
	}

	/**
	 * La m�thode afficher() permet d'afficher tous les renseignements du participant.
	 */
	
	public void afficher() {
		System.out.println( "\nRenseignements du participant.\n" );
		System.out.println( "Num�ro : " + this.getNoParticipant() );
		System.out.println( "Nom :    " + this.getNom() );

		if ( tabAssignMat.estVide() ) {
			System.out.println( "\nAucun mat�riel informatique n'est assign� � ce participant." );
		} else {
			System.out.println( "\nListe du mat�riel informatique assign� � ce participant :" );

			MaterielInfo materiel;
			int nbElements = this.tabAssignMat.taille();

			for ( int i = 0; i < nbElements ; ++i ) {
				materiel = (MaterielInfo) this.tabAssignMat.obtenirObjet( i );
				materiel.afficher();
				OutilsLecture.lireEntree( OutilsConstantes.QUEST_CONTINUER );
			}

			System.out.println( "\nQuantit� de mat�riel informatique assign� au participant : " + nbElements );
		}
	}

	/**
	 * Red�finition de la m�thode toString() de la classe Object.
	 * 
	 * @return Les informations du participant sous forme d'une cha�ne de caract�res.
	 */
	
	@Override
	public String toString() {

		return this.getClass().getName() + "[" + this.getNoParticipant() + "," + 
			   this.getNom() + "," + this.getTabAssignMat() + "]";
	}

	/**
	 * Red�finition de la m�thode equals() de la classe Object. L'objet courant est 
	 * �gal � l'objet re�u en param�tre lorsque les num�ros du participant sont �gaux.
	 * 
	 * @param autreObjet
	 *            L'autre objet � comparer avec celui courant de type Object.
	 * 
	 * @return true si l'objet courant est �gal � l'autre objet ou false dans le
	 *         cas contraire.
	 */
	
	@Override	
	public boolean equals( Object autreObjet ) {
		boolean egalite = false;

		// Si les deux objets pointent sur la m�me zone m�moire.

		if ( this == autreObjet ) {
			egalite = true;
		} else if ( autreObjet != null ) {

			if ( autreObjet instanceof Participant ) {

				// Convertir le type de l'autre objet en type Participant.
				
				Participant autre = (Participant) autreObjet;

				// Les objets sont identiques si les num�ros de participant sont identiques.

				if ( this.getNoParticipant().equalsIgnoreCase( autre.getNoParticipant() ) ) {
					egalite = true;
				}
			}
		}

		return egalite;
	}

	/**
	 * Impl�mentation de la m�thode compareTo() de l'interface Comparable. Un objet
	 * de type Participant est plus petit qu'un autre objet de type Participant,
	 * lorsque le noParticipant du premier objet est alphab�tiquement plus petit que
	 * le noParticipant du deuxi�me objet. On ne fait pas de diff�rence entre les
	 * caract�res minuscules et les caract�res majuscules.
	 * 
	 * @param autreParticipant
	 *            L'autre participant � comparer avec celui courant de type Participant.
	 * 
	 * @return Une valeur n�gative si le participant courant est plus petit que l'autre
	 *         participant, une valeur positive si le participant courant est plus
	 *         grand que l'autre participant ou 0 si le participant courant est
	 *         �gal � l'autre participant.
	 */
	
	@Override
	public int compareTo( Participant autreParticipant ) {

		return this.getNoParticipant().compareToIgnoreCase( autreParticipant.getNoParticipant() );
	}
}