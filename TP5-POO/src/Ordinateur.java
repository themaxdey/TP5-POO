/**
 * Auteur  : Christian Mongeon
 * Fichier : Ordinateur.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Ordinateur h�rite de la classe abstraite MaterielInfo et contient les donn�es et les
 * m�thodes suppl�mentaires pour un ordinateur. Cette classe impl�mente l'interface Serializable.
 */

public class Ordinateur extends MaterielInfo implements Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un ordinateur.
	static final long serialVersionUID = 5;
	
	// Constantes de la classe Ordinateur.
	
	public static final char BUREAU   = 'B';
	public static final char PORTABLE = 'P';
	public static final String TYPES_ORDIS = "" + Ordinateur.BUREAU + Ordinateur.PORTABLE;
		
	// Champ d'instance priv� suppl�mentaire de la classe Ordinateur.
	
	private char typeOrdi;

	/**
	 * Le constructeur Ordinateur() permet de construire un ordinateur de base.
	 * Aucun num�ro de mat�riel, aucune marque, aucun mod�le et aucun type. 
	 */
	
	public Ordinateur() {
		// Ex�cuter l'autre constructeur.
		this( "", "", "", '\0' );
	}
	
	/**
	 * Le constructeur Ordinateur() permet de construire un ordinateur connaissant son
	 * num�ro de mat�riel, sa marque, son mod�le et son type (bureau ou portable). Au
	 * d�but l'ordinateur n'est pas assign� � un participant.
	 * 
	 * @param noMateriel
	 *            Le num�ro de mat�riel de l'ordinateur.
	 * @param marque
	 *            La marque de l'ordinateur.
	 * @param modele
	 *            Le mod�le de l'ordinateur.
	 * @param type
	 *            Le type de l'ordinateur (bureau ou portable).
	 */

	public Ordinateur( String noMateriel, String marque, String modele, char type ) {
		
		super( noMateriel, marque, modele );
		
		this.setTypeOrdi( type );
	}

	/**
	 * La m�thode accesseur getTypeOrdi() permet de retourner de type de l'ordinateur (bureau ou portable).
	 * 
	 * @return Le type de l'ordinateur (bureau ou portable).
	 */

	public char getTypeOrdi() {
		return this.typeOrdi;
	}

	/**
	 * La m�thode mutateur setTypeOrdi() permet de modifier le type de
	 * l'ordinateur (bureau ou portable) par celui re�u en param�tre.
	 * 
	 * @param type
	 *            Le type de l'ordinateur (bureau ou portable).
	 */

	public void setTypeOrdi( char type ) {
		this.typeOrdi = type;
	}

	/**
	 * La m�thode publique lireTypeOrdinateur() permet de lire le type de l'ordinateur
	 * et de modifier le champ du type de l'ordinateur.
	 */
	
	public void lireTypeOrdi() {
		final String QUEST_TYPE = "\nEntrez le type de l'ordinateur (B pour Bureau, P pour Portable) : ";

		char type = OutilsLecture.lireCaractereDisparate( QUEST_TYPE, TYPES_ORDIS );

		this.setTypeOrdi( type );
	}
	

	/**
	 * Red�finition de la m�thode lireAutresRenseignements() qui permet de lire les
	 * autres renseignements de l'ordinateur, connaissant le num�ro du mat�riel.
	 */
	
	@Override
	public void lireAutresRenseignements() {

		super.lireAutresRenseignements();
		
		this.lireTypeOrdi();
	}

	/**
	 * Red�finition de la m�thode afficher() qui permet d'afficher tous les
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
	 * Red�finition de la m�thode toString().
	 * 
	 * @return Les informations de l'ordinateur sous forme d'une cha�ne de caract�res.
	 */

	@Override
	public String toString() {

		return super.toString() + "[" + this.getTypeOrdi() + "]";
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirType() qui retourne
	 * le type de mat�riel informatique qui repr�sente un ordinateur.
	 * 
	 * @return Le caract�re repr�sentant un ordinateur : O.
	 */
	
	@Override
	public char obtenirType() {
		return MaterielInfo.ORDINATEUR;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirDescription() qui permet de
	 * retourner la description du mat�riel informatique.
	 * 
	 * @return La description du mat�riel informatique sous forme d'une cha�ne de caract�res.
	 */
	
	@Override
	public String obtenirDescription() {
		return "ordinateur";
	}
}