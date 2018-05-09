/**
 * Auteur  : Christian Mongeon
 * Fichier : Ecran.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du système.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Ecran hérite de la classe abstraite MaterielInfo et contient les
 * données et les méthodes supplémentaires pour un écran d'ordinateur.
 * Cette classe implémente l'interface Serializable.
 */

public class Ecran extends MaterielInfo implements Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un écran.
	static final long serialVersionUID = 7;
	
	// Constantes de la classe Ecran.

	public static final double MIN_TAILLE  = 3.5;
	public static final double MAX_TAILLE  = 152;
	
	public static final int MIN_CAR_RESOLUTION = 7;
	public static final int MAX_CAR_RESOLUTION = 17;
	
	// Champs d'instance privés supplémentaires de la classe Ecran.
	
	private double taille;     // Taille de l'écran en pouces.
	private String resolution; // Indique la résolution de l'écran en pixels (Ex: "1920x1080").
	
	/**
	 * Le constructeur Ecran() permet de construire un écran de base.
	 * Aucun numéro de matériel, aucune marque, aucun modèle, aucune
	 * taille et aucune résolution. 
	 */
	
	public Ecran() {
		// Appel de l'autre constructeur.
		this( "", "", "", 0, "" );
	}
	
	/**
	 * Le constructeur Ecran() permet de construire un écran connaissant son numéro de matériel, 
	 * sa marque, son modèle, sa taille et sa résolution. Au début l'écran n'est pas assigné
	 * à un participant.
	 * 
	 * @param noMateriel
	 *            Le numéro de matériel de l'écran d'ordinateur.
	 * @param marque
	 *            La marque de l'écran d'ordinateur.
	 * @param modele
	 *            Le modèle de l'écran d'ordinateur.
	 * @param taille
	 *            La taille de l'écran d'ordinateur en pouces.
	 * @param resolution
	 *            La résolution de l'écran d'ordinateur.
	 */

	public Ecran( String noMateriel, String marque, String modele, double taille, String resolution ) {
		
		super( noMateriel, marque, modele );
		
		this.setTaille( taille );
		this.setResolution( resolution );
	}

	/**
	 * La méthode accesseur getTaille() permet de retourner la taille de l'écran d'ordinateur en pouces.
	 * 
	 * @return La taille de l'écran d'ordinateur.
	 */

	public double getTaille() {
		return this.taille;
	}

	/**
	 * La méthode accesseur getResolution() permet de retourner la résolution de l'écran d'ordinateur.
	 * 
	 * @return La résolution de l'écran d'ordinateur.
	 */

	public String getResolution() {
		return this.resolution;
	}

	/**
	 * La méthode mutateur setTaille() permet de modifier la taille de l'écran
	 * d'ordinateur par celle reçue en paramètre.
	 * 
	 * @param taille
	 *            La taille de l'écran d'ordinateur.
	 */

	public void setTaille( double taille ) {
		if ( taille >= Ecran.MIN_TAILLE && taille <= Ecran.MAX_TAILLE ) {
			this.taille = taille;
		}
	}

	/**
	 * La méthode mutateur setResolution() permet de modifier la résolution de
	 * l'écran d'ordinateur par celle reçue en paramètre.
	 * 
	 * @param resolution
	 *            La résolution de l'écran d'ordinateur.
	 */

	public void setResolution( String resolution ) {
		if ( resolution.length() <= Ecran.MAX_CAR_RESOLUTION ) {
			this.resolution = resolution;
		}
	}

	/**
	 * La méthode publique lireTaille() permet de lire la taille de l'écran d'ordinateur et de
	 * modifier le champ de la taille de l'écran d'ordinateur.
	 */
	
	public void lireTaille() {
		final String QUEST_TAILLE = "\nEntrez la taille de l'écran en pouces (entre " + 
									Ecran.MIN_TAILLE + " et " + Ecran.MAX_TAILLE + ") : ";

		double taille = OutilsLecture.lireReelValide( QUEST_TAILLE, Ecran.MIN_TAILLE, Ecran.MAX_TAILLE );

		this.setTaille( taille );
	}

	/**
	 * La méthode publique lireResolution() permet de lire la résolution de l'écran d'ordinateur 
	 * et de modifier le champ de la résolution de l'écran d'ordinateur.
	 */
	
	public void lireResolution() {
		final String QUEST_RESOLUTION = "\nEntrez la résolution de l'écran d'ordinateur (entre " + 
                				        Ecran.MIN_CAR_RESOLUTION + " et " + Ecran.MAX_CAR_RESOLUTION + " car.) : ";		

		String resolution = OutilsLecture.lireChaineValide( QUEST_RESOLUTION , Ecran.MIN_CAR_RESOLUTION, 
				                                            Ecran.MAX_CAR_RESOLUTION );
		this.setResolution( resolution );
	}

	/**
	 * Redéfinition de la méthode lireAutresRenseignements() qui permet de lire les autres renseignements de 
	 * l'écran d'ordinateur, connaissant le numéro de matériel de l'écran d'ordinateur.
	 */

	@Override
	public void lireAutresRenseignements() {
		
		super.lireAutresRenseignements();
		
		this.lireTaille();
		this.lireResolution();
	}

	/**
	 * Redéfinition de la méthode afficher() qui permet d'afficher tous les
	 * renseignements de l'écran d'ordinateur.
	 */

	@Override
	public void afficher() {
		
		super.afficher();
		
		System.out.println( "Taille :     " + OutilsAffichage.formaterNb( this.getTaille(), 1 ) );
		System.out.println( "Résolution : " + this.getResolution() );

		super.afficherAssignation();
	}

	/**
	 * Redéfinition de la méthode toString().
	 * 
	 * @return Les informations de l'écran d'ordinateur sous la forme d'une chaîne de caractères.
	 */

	@Override
	public String toString() {
		
		return super.toString() + "[" + this.getTaille() + "," + this.getResolution() + "]";
	}

	/**
	 * Implémentation de la méthode abstraite obtenirType() qui retourne le type
	 * de matériel informatique représentant un écran d'ordinateur.
	 * 
	 * @return Le caractère représentant un écran d'ordinateur : E.
	 */
	
	@Override
	public char obtenirType() {
		return MaterielInfo.ECRAN;
	}

	/**
	 * Implémentation de la méthode abstraite obtenirDescription() qui permet de
	 * retourner la description du matériel informatique.
	 * 
	 * @return La description du matériel informatique sous forme d'une chaîne de caractères.
	 */
	
	@Override
	public String obtenirDescription() {
		return "écran";
	}
}