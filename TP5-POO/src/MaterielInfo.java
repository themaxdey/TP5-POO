/**
 * Auteur  : Christian Mongeon
 * Fichier : MaterielInfo.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du syst�me.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe abstraite MaterielInfo contient les donn�es et les m�thodes
 * communes pour du mat�riel informatique. Cette classe impl�mente les
 * interfaces Comparable et Serializable.
 */

public abstract class MaterielInfo implements Comparable <MaterielInfo>, Serializable {
	
	// Num�ro d'identification pour la sauvegarde du mat�riel informatique.
	static final long serialVersionUID = 4;
	
	// Constantes de la classe MaterielInfo.

	public static final int MIN_CAR_NO_MATERIEL = 1;
	public static final int MAX_CAR_NO_MATERIEL = 12;
	public static final int MIN_CAR_MARQUE      = 1;
	public static final int MAX_CAR_MARQUE      = 48;
	public static final int MIN_CAR_MODELE      = 1;
	public static final int MAX_CAR_MODELE      = 32;

	// Diff�rents types de mat�riel informatique.

	public static final char TOUS       = 'T';
	public static final char ECRAN      = 'E';
	public static final char IMPRIMANTE = 'I';
	public static final char ORDINATEUR = 'O';

	// Cha�ne contenant les types de mat�riel informatique : "EIO".
	public static final String TYPES_MATERIEL = "" + ECRAN + IMPRIMANTE + ORDINATEUR;

	// Cha�ne contenant les types de mat�riel informatique � consulter : "TEIO".
	public static final String TYPES_MATERIEL_CONSULTER = "" + TOUS + TYPES_MATERIEL;

	// Questions pour lire un type de mat�riel informatique.

	public static final String QUEST_TYPE_BASE = "\nEntrez le type de mat�riel informatique (E pour �cran, " + 
	                                             "I pour Imprimante, O pour Ordinateur) : ";

	public static final String QUEST_TYPE_CONSULTER = "\nEntrez le type de mat�riel informatique � consulter " +
	                                                  "(T pour Tous, E pour �cran, I pour Imprimante, " +
			                                          "O pour Ordinateur) : ";	

	// Champs d'instance priv�s de la classe MaterielInfo.
	
	private String noMateriel;  // Sert de cl�.
	private String marque;
	private String modele;
	private boolean assigne;

	/**
	 * Le constructeur MaterielInfo() permet de construire un mat�riel informatique de base.
	 * Aucun num�ro de mat�riel, aucune marque, aucun mod�le. 
	 */
	
	public MaterielInfo() {
		// Ex�cuter l'autre constructeur.
		this( "", "", "" );
	}
	
	/**
	 * Le constructeur MaterielInfo() permet de construire un mat�riel informatique connaissant
	 * son num�ro de mat�riel, sa marque et son mod�le. Au d�but le mat�riel n'est pas assign�
	 * � un participant.
	 * 
	 * @param noMateriel
	 *            Le num�ro du mat�riel informatique.
	 * @param marque
	 *            La marque du mat�riel informatique.
	 * @param modele
	 *            Le mod�le du mat�riel informatique.
	 */

	public MaterielInfo( String noMateriel, String marque, String modele ) {
		this.setNoMateriel( noMateriel );
		this.setMarque( marque );
		this.setModele( modele );
		this.setAssigne( false );
	}

	/**
	 * La m�thode accesseur getNoMateriel() permet de retourner le num�ro du mat�riel informatique.
	 * 
	 * @return Le num�ro du mat�riel informatique.
	 */

	public String getNoMateriel() {
		return this.noMateriel;
	}

	/**
	 * La m�thode accesseur getMarque() permet de retourner la marque du mat�riel informatique.
	 * 
	 * @return La marque du mat�riel informatique.
	 */

	public String getMarque() {
		return this.marque;
	}

	/**
	 * La m�thode accesseur getModele() permet de retourner le mod�le du mat�riel informatique.
	 * 
	 * @return Le mod�le du mat�riel informatique.
	 */

	public String getModele() {
		return this.modele;
	}

	/**
	 * La m�thode accesseur isAssigne() permet de v�rifier si le mat�riel est assign� � un participant.
	 * 
	 * @return true si le mat�riel est assign� � un participant ou false dans le cas contraire.
	 */

	public boolean isAssigne() {
		return this.assigne;
	}

	/**
	 * La m�thode mutateur setNoMateriel() permet de modifier le num�ro
	 * du mat�riel informatique par celui re�u en param�tre.
	 * 
	 * @param noMateriel
	 *            Le num�ro du mat�riel informatique.
	 */

	public void setNoMateriel( String noMateriel ) {
		if ( noMateriel.length() <= MaterielInfo.MAX_CAR_NO_MATERIEL ) {
			
			this.noMateriel = noMateriel;
		}
	}

	/**
	 * La m�thode mutateur setMarque() permet de modifier la marque du 
	 * mat�riel informatique par celle re�ue en param�tre.
	 * 
	 * @param marque
	 *            La marque du mat�riel informatique.
	 */

	public void setMarque( String marque ) {
		if ( marque.length() <= MaterielInfo.MAX_CAR_MARQUE ) {
				
			this.marque = marque;
		}
	}

	/**
	 * La m�thode mutateur setModele() permet de modifier le mod�le
	 * du mat�riel informatique par celui re�u en param�tre.
	 * 
	 * @param modele
	 *            Le mod�le du mat�riel informatique.
	 */

	public void setModele( String modele ) {
		if ( modele.length() <= MaterielInfo.MAX_CAR_MODELE ) {
				
			this.modele = modele;
		}
	}

	/**
	 * La m�thode mutateur setAssigne() permet de modifier l'assignation ou non d'un mat�riel informatique.
	 * 
	 * @param assigne
	 *            Un bool�en indiquant si le mat�riel informatique est assign� ou non � un participant.
	 */

	public void setAssigne( boolean assigne ) {
		this.assigne = assigne;
	}

	/**
	 * La m�thode publique lireNoMateriel() permet de lire le num�ro du mat�riel informatique
	 * et de modifier le champ du num�ro du mat�riel informatique.
	 */
	
	public void lireNoMateriel() {
		final String QUEST_MAT = "\nEntrez le num�ro du mat�riel informatique (entre " + 
	                             MaterielInfo.MIN_CAR_NO_MATERIEL +
	                             " et " + MaterielInfo.MAX_CAR_NO_MATERIEL + " car.) : ";		
		
		String noMateriel = OutilsLecture.lireChaineValide( QUEST_MAT, MaterielInfo.MIN_CAR_NO_MATERIEL, 
				                                            MaterielInfo.MAX_CAR_NO_MATERIEL );
		this.setNoMateriel( noMateriel );
	}
	
	/**
	 * La m�thode publique lireMarque() permet de lire la marque du mat�riel informatique
	 * et de modifier le champ de la marque du mat�riel informatique.
	 */
	
	public void lireMarque() {
		final String QUEST_MARQUE = "\nEntrez la marque de l'" + this.obtenirDescription() + " (entre " +
								    MaterielInfo.MIN_CAR_MARQUE + " et " + MaterielInfo.MAX_CAR_MARQUE + " car.) : ";

		String marque = OutilsLecture.lireChaineValide( QUEST_MARQUE, MaterielInfo.MIN_CAR_MARQUE, 
				                                        MaterielInfo.MAX_CAR_MARQUE );
		this.setMarque( marque );
	}

	/**
	 * La m�thode publique lireModele() permet de lire le mod�le du mat�riel informatique
	 * et de modifier le champ du mod�le du mat�riel informatique.
	 */
	
	public void lireModele() {
		final String QUEST_MODELE = "\nEntrez le num�ro de mod�le de l'" + this.obtenirDescription() + " (entre " +
									 MaterielInfo.MIN_CAR_MODELE + " et " + MaterielInfo.MAX_CAR_MODELE + " car.) : ";

		String modele = OutilsLecture.lireChaineValide( QUEST_MODELE, MaterielInfo.MIN_CAR_MODELE, 
				                                        MaterielInfo.MAX_CAR_MODELE );
		this.setModele( modele );
	}

	/**
	 * La m�thode publique lireAutresRenseignements() permet de lire les autres renseignements
	 * du mat�riel informatique, connaissant le num�ro du mat�riel informatique.
	 */
	
	public void lireAutresRenseignements() {
		System.out.println( "\nEntrez les autres renseignements de l'" + this.obtenirDescription() +
							" dont le num�ro de mat�riel est " + this.getNoMateriel() );
		this.lireMarque();
		this.lireModele();
	}

	/**
	 * La m�thode publique afficher() permet d'afficher tous les renseignements du mat�riel informatique.
	 */

	public void afficher() {
		System.out.println( "\nRenseignements de l'" + this.obtenirDescription() + ".\n" );
		System.out.println( "Num�ro :     " + this.getNoMateriel() );
		System.out.println( "Marque :     " + this.getMarque() );
		System.out.println( "Mod�le :     " + this.getModele() );
	}

	/**
	 * La m�thode publique afficherAssignation() permet d'afficher si
	 * le mat�riel informatique est assign� ou non � un participant.
	 */

	public void afficherAssignation() {
		System.out.print( "\nCe mat�riel de type " + this.obtenirDescription() + 
				          (this.isAssigne() ? " est" : " n'est pas") + " assign� � un participant.\n" );
	}

	/**
	 * La m�thode publique statique creerMaterielInfo() permet de cr�er et de
	 * retourner un mat�riel informatique de base temporaire.
	 * 
	 * @return Un mat�riel informatique de base temporaire.
	 */
	
	public static MaterielInfo creerMaterielInfo() {
		// Un mat�riel de base temporaire est un Ordinateur. 
		return new Ordinateur();
	}

	/**
	 * La m�thode publique statique creerMaterielInfo() permet de cr�er et de retourner un
	 * objet de base qui correspond au type de mat�riel informatique re�u en param�tre.
	 * 
	 * @param type
	 *            Le type de mat�riel informatique.
	 * 
	 * @return L'objet de base qui correspond au type de mat�riel informatique.
	 */
	
	public static MaterielInfo creerMaterielInfo( char type ) {
		MaterielInfo materiel = null;
		
		// Cr�er le bon objet de base selon le type de mat�riel informatique re�u en param�tre.

		switch ( type ) {
		
		case MaterielInfo.ECRAN:
			materiel = new Ecran();
			break;

		case MaterielInfo.IMPRIMANTE:
			materiel = new Imprimante();
			break;
			
		case MaterielInfo.ORDINATEUR:
			materiel = new Ordinateur();
			break;
		}
		
		return materiel;
	}

	/**
	 * Red�finition de la m�thode toString() de la classe Object.
	 * 
	 * @return Les informations du mat�riel informatique sous forme d'une cha�ne de caract�res.
	 */

	@Override
	public String toString() {

		return this.getClass().getName() + "[" + this.getNoMateriel() + "," + 
			   this.getMarque() + "," + this.getModele() + "]";
	}

	/**
	 * Red�finition de la m�thode equals() de la classe Object. L'objet courant est �gal �
	 * l'objet re�u en param�tre lorsque les num�ros de mat�riel informatique sont �gaux.
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

			if ( autreObjet instanceof MaterielInfo ) {

				// Convertir le type de l'autre objet en type MaterielInfo.
				MaterielInfo autre = (MaterielInfo) autreObjet;

				// Les objets sont identiques si les num�ros de mat�riel informatique sont identiques.

				if ( this.getNoMateriel().equalsIgnoreCase( autre.getNoMateriel() ) ) {
					egalite = true;
				}
			}
		}

		return egalite;
	}
	
	/**
	 * Impl�mentation de la m�thode compareTo() de l'interface Comparable. Un objet
	 * de type MaterielInfo est plus petit qu'un autre objet de type MaterielInfo,
	 * lorsque le num�ro de mat�riel informatique du premier objet est alphab�tiquement
	 * plus petit que le num�ro de mat�riel informatique du deuxi�me objet. On ne fait
	 * pas de diff�rence entre les caract�res minuscules et les caract�res majuscules.
	 * 
	 * @param autreMaterielInfo
	 *            L'autre objet � comparer avec celui courant de type MaterielInfo.
	 * 
	 * @return Une valeur n�gative si l'objet courant est plus petit que l'autre
	 *         objet, une valeur positive si l'objet courant est plus grand que
	 *         l'autre objet ou 0 si l'objet courant est �gal � l'autre objet.
	 */

	@Override
	public int compareTo( MaterielInfo autreMaterielInfo ) {

		return this.getNoMateriel().compareToIgnoreCase( autreMaterielInfo.getNoMateriel() );
	}

	/**
	 * La m�thode abstraite obtenirType() retourne le type du mat�riel informatique.
	 * 
	 * @return Le caract�re repr�sentant le type du mat�riel informatique : E, I ou O.
	 */
	
	public abstract char obtenirType();

	/**
	 * La m�thode abstraite obtenirDescription() retourne la description du
	 * mat�riel informatique.
	 * 
	 * @return La description du mat�riel informatique sous forme d'une cha�ne de caract�res.
	 */
	
	public abstract String obtenirDescription();
}