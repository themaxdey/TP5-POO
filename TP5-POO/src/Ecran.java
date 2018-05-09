/**
 * Auteur  : Christian Mongeon
 * Fichier : Ecran.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Ecran h�rite de la classe abstraite MaterielInfo et contient les
 * donn�es et les m�thodes suppl�mentaires pour un �cran d'ordinateur.
 * Cette classe impl�mente l'interface Serializable.
 */

public class Ecran extends MaterielInfo implements Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'un �cran.
	static final long serialVersionUID = 7;
	
	// Constantes de la classe Ecran.

	public static final double MIN_TAILLE  = 3.5;
	public static final double MAX_TAILLE  = 152;
	
	public static final int MIN_CAR_RESOLUTION = 7;
	public static final int MAX_CAR_RESOLUTION = 17;
	
	// Champs d'instance priv�s suppl�mentaires de la classe Ecran.
	
	private double taille;     // Taille de l'�cran en pouces.
	private String resolution; // Indique la r�solution de l'�cran en pixels (Ex: "1920x1080").
	
	/**
	 * Le constructeur Ecran() permet de construire un �cran de base.
	 * Aucun num�ro de mat�riel, aucune marque, aucun mod�le, aucune
	 * taille et aucune r�solution. 
	 */
	
	public Ecran() {
		// Appel de l'autre constructeur.
		this( "", "", "", 0, "" );
	}
	
	/**
	 * Le constructeur Ecran() permet de construire un �cran connaissant son num�ro de mat�riel, 
	 * sa marque, son mod�le, sa taille et sa r�solution. Au d�but l'�cran n'est pas assign�
	 * � un participant.
	 * 
	 * @param noMateriel
	 *            Le num�ro de mat�riel de l'�cran d'ordinateur.
	 * @param marque
	 *            La marque de l'�cran d'ordinateur.
	 * @param modele
	 *            Le mod�le de l'�cran d'ordinateur.
	 * @param taille
	 *            La taille de l'�cran d'ordinateur en pouces.
	 * @param resolution
	 *            La r�solution de l'�cran d'ordinateur.
	 */

	public Ecran( String noMateriel, String marque, String modele, double taille, String resolution ) {
		
		super( noMateriel, marque, modele );
		
		this.setTaille( taille );
		this.setResolution( resolution );
	}

	/**
	 * La m�thode accesseur getTaille() permet de retourner la taille de l'�cran d'ordinateur en pouces.
	 * 
	 * @return La taille de l'�cran d'ordinateur.
	 */

	public double getTaille() {
		return this.taille;
	}

	/**
	 * La m�thode accesseur getResolution() permet de retourner la r�solution de l'�cran d'ordinateur.
	 * 
	 * @return La r�solution de l'�cran d'ordinateur.
	 */

	public String getResolution() {
		return this.resolution;
	}

	/**
	 * La m�thode mutateur setTaille() permet de modifier la taille de l'�cran
	 * d'ordinateur par celle re�ue en param�tre.
	 * 
	 * @param taille
	 *            La taille de l'�cran d'ordinateur.
	 */

	public void setTaille( double taille ) {
		if ( taille >= Ecran.MIN_TAILLE && taille <= Ecran.MAX_TAILLE ) {
			this.taille = taille;
		}
	}

	/**
	 * La m�thode mutateur setResolution() permet de modifier la r�solution de
	 * l'�cran d'ordinateur par celle re�ue en param�tre.
	 * 
	 * @param resolution
	 *            La r�solution de l'�cran d'ordinateur.
	 */

	public void setResolution( String resolution ) {
		if ( resolution.length() <= Ecran.MAX_CAR_RESOLUTION ) {
			this.resolution = resolution;
		}
	}

	/**
	 * La m�thode publique lireTaille() permet de lire la taille de l'�cran d'ordinateur et de
	 * modifier le champ de la taille de l'�cran d'ordinateur.
	 */
	
	public void lireTaille() {
		final String QUEST_TAILLE = "\nEntrez la taille de l'�cran en pouces (entre " + 
									Ecran.MIN_TAILLE + " et " + Ecran.MAX_TAILLE + ") : ";

		double taille = OutilsLecture.lireReelValide( QUEST_TAILLE, Ecran.MIN_TAILLE, Ecran.MAX_TAILLE );

		this.setTaille( taille );
	}

	/**
	 * La m�thode publique lireResolution() permet de lire la r�solution de l'�cran d'ordinateur 
	 * et de modifier le champ de la r�solution de l'�cran d'ordinateur.
	 */
	
	public void lireResolution() {
		final String QUEST_RESOLUTION = "\nEntrez la r�solution de l'�cran d'ordinateur (entre " + 
                				        Ecran.MIN_CAR_RESOLUTION + " et " + Ecran.MAX_CAR_RESOLUTION + " car.) : ";		

		String resolution = OutilsLecture.lireChaineValide( QUEST_RESOLUTION , Ecran.MIN_CAR_RESOLUTION, 
				                                            Ecran.MAX_CAR_RESOLUTION );
		this.setResolution( resolution );
	}

	/**
	 * Red�finition de la m�thode lireAutresRenseignements() qui permet de lire les autres renseignements de 
	 * l'�cran d'ordinateur, connaissant le num�ro de mat�riel de l'�cran d'ordinateur.
	 */

	@Override
	public void lireAutresRenseignements() {
		
		super.lireAutresRenseignements();
		
		this.lireTaille();
		this.lireResolution();
	}

	/**
	 * Red�finition de la m�thode afficher() qui permet d'afficher tous les
	 * renseignements de l'�cran d'ordinateur.
	 */

	@Override
	public void afficher() {
		
		super.afficher();
		
		System.out.println( "Taille :     " + OutilsAffichage.formaterNb( this.getTaille(), 1 ) );
		System.out.println( "R�solution : " + this.getResolution() );

		super.afficherAssignation();
	}

	/**
	 * Red�finition de la m�thode toString().
	 * 
	 * @return Les informations de l'�cran d'ordinateur sous la forme d'une cha�ne de caract�res.
	 */

	@Override
	public String toString() {
		
		return super.toString() + "[" + this.getTaille() + "," + this.getResolution() + "]";
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirType() qui retourne le type
	 * de mat�riel informatique repr�sentant un �cran d'ordinateur.
	 * 
	 * @return Le caract�re repr�sentant un �cran d'ordinateur : E.
	 */
	
	@Override
	public char obtenirType() {
		return MaterielInfo.ECRAN;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirDescription() qui permet de
	 * retourner la description du mat�riel informatique.
	 * 
	 * @return La description du mat�riel informatique sous forme d'une cha�ne de caract�res.
	 */
	
	@Override
	public String obtenirDescription() {
		return "�cran";
	}
}