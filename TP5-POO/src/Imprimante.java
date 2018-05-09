/**
 * Auteur  : Christian Mongeon
 * Fichier : Imprimante.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe Imprimante h�rite de la classe abstraite MaterielInfo et contient les donn�es et les m�thodes
 * suppl�mentaires pour une imprimante. Cette classe impl�mente les interfaces OutilsConstantes et Serializable.
 */

public class Imprimante extends MaterielInfo implements OutilsConstantes, Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'une imprimante.
	static final long serialVersionUID = 6;
	
	// Constantes de la classe Imprimante.

	public static final char JET_DENCRE = 'J';
	public static final char LASER      = 'L';
	public static final String TYPES_IMPRIMANTES = "" + Imprimante.JET_DENCRE + Imprimante.LASER;
	
	// Champs d'instance priv�s suppl�mentaires de la classe Imprimante.
	
	private char typeImpr;
	private boolean couleur;
	
	/**
	 * Le constructeur Imprimante() permet de construire une imprimante de base. Aucun num�ro
	 * de mat�riel, aucune marque, aucun mod�le, aucun type et pas en couleur.
	 */
	
	public Imprimante() {
		// Ex�cuter l'autre constructeur.
		this( "", "", "", '\0', false );
	}
	
	/**
	 * Le constructeur Imprimante() permet de construire une imprimante connaissant 
	 * son num�ro de mat�riel, sa marque, son mod�le, son type et si elle est en 
	 * couleur on non. Au d�but l'imprimante n'est assign�e � aucun participant.
	 * 
	 * @param noMateriel
	 *            Le num�ro de mat�riel de l'imprimante.
	 * @param marque
	 *            La marque de l'imprimante.
	 * @param modele
	 *            Le mod�le de l'imprimante.
	 * @param typeImpr
	 *            Le type de l'imprimante.
	 * @param couleur
	 *            Indique si l'imprimante imprime en couleur ou non.            
	 */

	public Imprimante( String noMateriel, String marque, String modele, char typeImpr, boolean couleur ) {
		
		super( noMateriel, marque, modele );
		
		this.setTypeImpr( typeImpr );
		this.setCouleur( couleur );
	}

	/**
	 * La m�thode accesseur getTypeImpr() permet de retourner le type de l'imprimante.
	 * 
	 * @return Le type de l'imprimante.
	 */

	public char getTypeImpr() {
		return this.typeImpr;
	}

	/**
	 * La m�thode accesseur isCouleur() permet de retourner si l'imprimante est couleur ou non.
	 * 
	 * @return true si l'imprimante est couleur ou false dans le cas contraire.
	 */

	public boolean isCouleur() {
		return this.couleur;
	}

	/**
	 * La m�thode mutateur setTypeImpr() permet de modifier le type 
	 * de l'imprimante, par celui re�u en param�tre.
	 * 
	 * @param typeImpr
	 *            Le type de l'imprimante.
	 */

	public void setTypeImpr( char typeImpr ) {
		this.typeImpr = typeImpr;
	}

	/**
	 * La m�thode mutateur setCouleur() permet de modifier le champ
	 * couleur de l'imprimante, par celui re�u en param�tre.
	 * 
	 * @param couleur
	 *            Indique si l'imprimante est couleur ou non.
	 */

	public void setCouleur( boolean couleur ) {
		this.couleur = couleur;
	}

	/**
	 * La m�thode publique lireTypeImpr() permet de lire le type de l'imprimante et de
	 * modifier le champ du type de l'imprimante.
	 */
	
	public void lireTypeImpr() {
		final String QUEST_TYPE = "\nEntrez le type de l'imprimante (J pour Jet d'encre, L pour Laser) : ";

		char typeImpr = OutilsLecture.lireCaractereDisparate( QUEST_TYPE, TYPES_IMPRIMANTES );

		this.setTypeImpr( typeImpr );
	}
	
	/**
	 * La m�thode publique lireCouleur() permet de lire si l'imprimante est couleur ou non et 
	 * de modifier le champ couleur de l'imprimante.
	 */
	
	public void lireCouleur() {
		final String QUEST_COULEUR = "\nEst-ce une imprimante couleur (O ou N) ? ";

		char rep = OutilsLecture.lireOuiNon( QUEST_COULEUR );

		this.setCouleur( rep == OUI );
	}

	/**
	 * Red�finition de la m�thode lireAutresRenseignements() qui permet de lire les autres
	 * renseignements de l'imprimante, connaissant le num�ro de mat�riel de l'imprimante.
	 */
	
	@Override
	public void lireAutresRenseignements() {
		
		super.lireAutresRenseignements();
		
		this.lireTypeImpr();
		this.lireCouleur();
	}

	/**
	 * Red�finition de la m�thode afficher() qui permet d'afficher tous les renseignements de l'imprimante.
	 */

	@Override
	public void afficher() {
		
		final String[] TAB_TYPES = {
				"jet d'encre", "laser"
		};
		
		super.afficher();
		
		System.out.println( "Type :       " + TAB_TYPES[TYPES_IMPRIMANTES.indexOf( this.getTypeImpr() )] );
		System.out.println( "Couleur :    " + (this.isCouleur() ? "oui" : "non") );

		super.afficherAssignation();
	}

	/**
	 * Red�finition de la m�thode toString().
	 * 
	 * @return Les informations de l'imprimante sous forme d'une cha�ne de caract�res.
	 */

	@Override
	public String toString() {

		return super.toString() + "[" + this.getTypeImpr() + this.isCouleur() + "]";
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirType() qui retourne le type
	 * de mat�riel informatique repr�sentant une imprimante.
	 * 
	 * @return Le caract�re repr�sentant une imprimante : I.
	 */
	
	@Override
	public char obtenirType() {
		return MaterielInfo.IMPRIMANTE;
	}

	/**
	 * Impl�mentation de la m�thode abstraite obtenirDescription() qui permet de
	 * retourner la description de l'imprimante.
	 * 
	 * @return La description de l'imprimante sous forme d'une cha�ne de caract�res.
	 */
	
	@Override
	public String obtenirDescription() {
		return "imprimante";
	}
}