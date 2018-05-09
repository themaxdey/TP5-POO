/**
 * Auteur  : Christian Mongeon
 * Fichier : Ordinateur.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du système.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Ordinateur hérite de la classe abstraite MaterielInfo et contient les données et les
 * méthodes supplémentaires pour un ordinateur. Cette classe implémente l'interface Serializable.
 */

public class Ordinateur extends MaterielInfo implements Serializable {
	
	// Numéro d'identification pour la sauvegarde d'un ordinateur.
	static final long serialVersionUID = 5;
	
	// Constantes de la classe Ordinateur.
	
	public static final char BUREAU   = 'B';
	public static final char PORTABLE = 'P';
	public static final String TYPES_ORDIS = "" + Ordinateur.BUREAU + Ordinateur.PORTABLE;
		
	// Champ d'instance privé supplémentaire de la classe Ordinateur.
	
	private char typeOrdi;

	/**
	 * Le constructeur Ordinateur() permet de construire un ordinateur de base.
	 * Aucun numéro de matériel, aucune marque, aucun modèle et aucun type. 
	 */
	
	public Ordinateur() {
		// Exécuter l'autre constructeur.
		this( "", "", "", '\0' );
	}
	
	/**
	 * Le constructeur Ordinateur() permet de construire un ordinateur connaissant son
	 * numéro de matériel, sa marque, son modèle et son type (bureau ou portable). Au
	 * début l'ordinateur n'est pas assigné à un participant.
	 * 
	 * @param noMateriel
	 *            Le numéro de matériel de l'ordinateur.
	 * @param marque
	 *            La marque de l'ordinateur.
	 * @param modele
	 *            Le modèle de l'ordinateur.
	 * @param type
	 *            Le type de l'ordinateur (bureau ou portable).
	 */

	public Ordinateur( String noMateriel, String marque, String modele, char type ) {
		
		super( noMateriel, marque, modele );
		
		this.setTypeOrdi( type );
	}

	/**
	 * La méthode accesseur getTypeOrdi() permet de retourner de type de l'ordinateur (bureau ou portable).
	 * 
	 * @return Le type de l'ordinateur (bureau ou portable).
	 */

	public char getTypeOrdi() {
		return this.typeOrdi;
	}

	/**
	 * La méthode mutateur setTypeOrdi() permet de modifier le type de
	 * l'ordinateur (bureau ou portable) par celui reçu en paramètre.
	 * 
	 * @param type
	 *            Le type de l'ordinateur (bureau ou portable).
	 */

	public void setTypeOrdi( char type ) {
		this.typeOrdi = type;
	}

	/**
	 * La méthode publique lireTypeOrdinateur() permet de lire le type de l'ordinateur
	 * et de modifier le champ du type de l'ordinateur.
	 */
	
	public void lireTypeOrdi() {
		final String QUEST_TYPE = "\nEntrez le type de l'ordinateur (B pour Bureau, P pour Portable) : ";

		char type = OutilsLecture.lireCaractereDisparate( QUEST_TYPE, TYPES_ORDIS );

		this.setTypeOrdi( type );
	}
	

	/**
	 * Redéfinition de la méthode lireAutresRenseignements() qui permet de lire les
	 * autres renseignements de l'ordinateur, connaissant le numéro du matériel.
	 */
	
	@Override
	public void lireAutresRenseignements() {

		super.lireAutresRenseignements();
		
		this.lireTypeOrdi();
	}

	/**
	 * Redéfinition de la méthode afficher() qui permet d'afficher tous les
	 * renseignements de l'ordinateur.
	 */

	@Override
	public void afficher() {
		
		final String[] TAB_TYPES = {
				"bureau", "portable"
		};
		
		super.afficher();
		
		System.out.println( "Type :       " + TAB_TYPES[TYPES_ORDIS.indexOf( this.getTypeOrdi() )] );

		super.afficherAssignation();
	}

	/**
	 * Redéfinition de la méthode toString().
	 * 
	 * @return Les informations de l'ordinateur sous forme d'une chaîne de caractères.
	 */

	@Override
	public String toString() {

		return super.toString() + "[" + this.getTypeOrdi() + "]";
	}

	/**
	 * Implémentation de la méthode abstraite obtenirType() qui retourne
	 * le type de matériel informatique qui représente un ordinateur.
	 * 
	 * @return Le caractère représentant un ordinateur : O.
	 */
	
	@Override
	public char obtenirType() {
		return MaterielInfo.ORDINATEUR;
	}

	/**
	 * Implémentation de la méthode abstraite obtenirDescription() qui permet de
	 * retourner la description du matériel informatique.
	 * 
	 * @return La description du matériel informatique sous forme d'une chaîne de caractères.
	 */
	
	@Override
	public String obtenirDescription() {
		return "ordinateur";
	}
}