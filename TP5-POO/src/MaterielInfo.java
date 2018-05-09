/**
 * Auteur  : Christian Mongeon
 * Fichier : MaterielInfo.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du système.
import java.io.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe abstraite MaterielInfo contient les données et les méthodes
 * communes pour du matériel informatique. Cette classe implémente les
 * interfaces Comparable et Serializable.
 */

public abstract class MaterielInfo implements Comparable <MaterielInfo>, Serializable {
	
	// Numéro d'identification pour la sauvegarde du matériel informatique.
	static final long serialVersionUID = 4;
	
	// Constantes de la classe MaterielInfo.

	public static final int MIN_CAR_NO_MATERIEL = 1;
	public static final int MAX_CAR_NO_MATERIEL = 12;
	public static final int MIN_CAR_MARQUE      = 1;
	public static final int MAX_CAR_MARQUE      = 48;
	public static final int MIN_CAR_MODELE      = 1;
	public static final int MAX_CAR_MODELE      = 32;

	// Différents types de matériel informatique.

	public static final char TOUS       = 'T';
	public static final char ECRAN      = 'E';
	public static final char IMPRIMANTE = 'I';
	public static final char ORDINATEUR = 'O';

	// Chaîne contenant les types de matériel informatique : "EIO".
	public static final String TYPES_MATERIEL = "" + ECRAN + IMPRIMANTE + ORDINATEUR;

	// Chaîne contenant les types de matériel informatique à consulter : "TEIO".
	public static final String TYPES_MATERIEL_CONSULTER = "" + TOUS + TYPES_MATERIEL;

	// Questions pour lire un type de matériel informatique.

	public static final String QUEST_TYPE_BASE = "\nEntrez le type de matériel informatique (E pour Écran, " + 
	                                             "I pour Imprimante, O pour Ordinateur) : ";

	public static final String QUEST_TYPE_CONSULTER = "\nEntrez le type de matériel informatique à consulter " +
	                                                  "(T pour Tous, E pour Écran, I pour Imprimante, " +
			                                          "O pour Ordinateur) : ";	

	// Champs d'instance privés de la classe MaterielInfo.
	
	private String noMateriel;  // Sert de clé.
	private String marque;
	private String modele;
	private boolean assigne;

	/**
	 * Le constructeur MaterielInfo() permet de construire un matériel informatique de base.
	 * Aucun numéro de matériel, aucune marque, aucun modèle. 
	 */
	
	public MaterielInfo() {
		// Exécuter l'autre constructeur.
		this( "", "", "" );
	}
	
	/**
	 * Le constructeur MaterielInfo() permet de construire un matériel informatique connaissant
	 * son numéro de matériel, sa marque et son modèle. Au début le matériel n'est pas assigné
	 * à un participant.
	 * 
	 * @param noMateriel
	 *            Le numéro du matériel informatique.
	 * @param marque
	 *            La marque du matériel informatique.
	 * @param modele
	 *            Le modèle du matériel informatique.
	 */

	public MaterielInfo( String noMateriel, String marque, String modele ) {
		this.setNoMateriel( noMateriel );
		this.setMarque( marque );
		this.setModele( modele );
		this.setAssigne( false );
	}

	/**
	 * La méthode accesseur getNoMateriel() permet de retourner le numéro du matériel informatique.
	 * 
	 * @return Le numéro du matériel informatique.
	 */

	public String getNoMateriel() {
		return this.noMateriel;
	}

	/**
	 * La méthode accesseur getMarque() permet de retourner la marque du matériel informatique.
	 * 
	 * @return La marque du matériel informatique.
	 */

	public String getMarque() {
		return this.marque;
	}

	/**
	 * La méthode accesseur getModele() permet de retourner le modèle du matériel informatique.
	 * 
	 * @return Le modèle du matériel informatique.
	 */

	public String getModele() {
		return this.modele;
	}

	/**
	 * La méthode accesseur isAssigne() permet de vérifier si le matériel est assigné à un participant.
	 * 
	 * @return true si le matériel est assigné à un participant ou false dans le cas contraire.
	 */

	public boolean isAssigne() {
		return this.assigne;
	}

	/**
	 * La méthode mutateur setNoMateriel() permet de modifier le numéro
	 * du matériel informatique par celui reçu en paramètre.
	 * 
	 * @param noMateriel
	 *            Le numéro du matériel informatique.
	 */

	public void setNoMateriel( String noMateriel ) {
		if ( noMateriel.length() <= MaterielInfo.MAX_CAR_NO_MATERIEL ) {
			
			this.noMateriel = noMateriel;
		}
	}

	/**
	 * La méthode mutateur setMarque() permet de modifier la marque du 
	 * matériel informatique par celle reçue en paramètre.
	 * 
	 * @param marque
	 *            La marque du matériel informatique.
	 */

	public void setMarque( String marque ) {
		if ( marque.length() <= MaterielInfo.MAX_CAR_MARQUE ) {
				
			this.marque = marque;
		}
	}

	/**
	 * La méthode mutateur setModele() permet de modifier le modèle
	 * du matériel informatique par celui reçu en paramètre.
	 * 
	 * @param modele
	 *            Le modèle du matériel informatique.
	 */

	public void setModele( String modele ) {
		if ( modele.length() <= MaterielInfo.MAX_CAR_MODELE ) {
				
			this.modele = modele;
		}
	}

	/**
	 * La méthode mutateur setAssigne() permet de modifier l'assignation ou non d'un matériel informatique.
	 * 
	 * @param assigne
	 *            Un booléen indiquant si le matériel informatique est assigné ou non à un participant.
	 */

	public void setAssigne( boolean assigne ) {
		this.assigne = assigne;
	}

	/**
	 * La méthode publique lireNoMateriel() permet de lire le numéro du matériel informatique
	 * et de modifier le champ du numéro du matériel informatique.
	 */
	
	public void lireNoMateriel() {
		final String QUEST_MAT = "\nEntrez le numéro du matériel informatique (entre " + 
	                             MaterielInfo.MIN_CAR_NO_MATERIEL +
	                             " et " + MaterielInfo.MAX_CAR_NO_MATERIEL + " car.) : ";		
		
		String noMateriel = OutilsLecture.lireChaineValide( QUEST_MAT, MaterielInfo.MIN_CAR_NO_MATERIEL, 
				                                            MaterielInfo.MAX_CAR_NO_MATERIEL );
		this.setNoMateriel( noMateriel );
	}
	
	/**
	 * La méthode publique lireMarque() permet de lire la marque du matériel informatique
	 * et de modifier le champ de la marque du matériel informatique.
	 */
	
	public void lireMarque() {
		final String QUEST_MARQUE = "\nEntrez la marque de l'" + this.obtenirDescription() + " (entre " +
								    MaterielInfo.MIN_CAR_MARQUE + " et " + MaterielInfo.MAX_CAR_MARQUE + " car.) : ";

		String marque = OutilsLecture.lireChaineValide( QUEST_MARQUE, MaterielInfo.MIN_CAR_MARQUE, 
				                                        MaterielInfo.MAX_CAR_MARQUE );
		this.setMarque( marque );
	}

	/**
	 * La méthode publique lireModele() permet de lire le modèle du matériel informatique
	 * et de modifier le champ du modèle du matériel informatique.
	 */
	
	public void lireModele() {
		final String QUEST_MODELE = "\nEntrez le numéro de modèle de l'" + this.obtenirDescription() + " (entre " +
									 MaterielInfo.MIN_CAR_MODELE + " et " + MaterielInfo.MAX_CAR_MODELE + " car.) : ";

		String modele = OutilsLecture.lireChaineValide( QUEST_MODELE, MaterielInfo.MIN_CAR_MODELE, 
				                                        MaterielInfo.MAX_CAR_MODELE );
		this.setModele( modele );
	}

	/**
	 * La méthode publique lireAutresRenseignements() permet de lire les autres renseignements
	 * du matériel informatique, connaissant le numéro du matériel informatique.
	 */
	
	public void lireAutresRenseignements() {
		System.out.println( "\nEntrez les autres renseignements de l'" + this.obtenirDescription() +
							" dont le numéro de matériel est " + this.getNoMateriel() );
		this.lireMarque();
		this.lireModele();
	}

	/**
	 * La méthode publique afficher() permet d'afficher tous les renseignements du matériel informatique.
	 */

	public void afficher() {
		System.out.println( "\nRenseignements de l'" + this.obtenirDescription() + ".\n" );
		System.out.println( "Numéro :     " + this.getNoMateriel() );
		System.out.println( "Marque :     " + this.getMarque() );
		System.out.println( "Modèle :     " + this.getModele() );
	}

	/**
	 * La méthode publique afficherAssignation() permet d'afficher si
	 * le matériel informatique est assigné ou non à un participant.
	 */

	public void afficherAssignation() {
		System.out.print( "\nCe matériel de type " + this.obtenirDescription() + 
				          (this.isAssigne() ? " est" : " n'est pas") + " assigné à un participant.\n" );
	}

	/**
	 * La méthode publique statique creerMaterielInfo() permet de créer et de
	 * retourner un matériel informatique de base temporaire.
	 * 
	 * @return Un matériel informatique de base temporaire.
	 */
	
	public static MaterielInfo creerMaterielInfo() {
		// Un matériel de base temporaire est un Ordinateur. 
		return new Ordinateur();
	}

	/**
	 * La méthode publique statique creerMaterielInfo() permet de créer et de retourner un
	 * objet de base qui correspond au type de matériel informatique reçu en paramètre.
	 * 
	 * @param type
	 *            Le type de matériel informatique.
	 * 
	 * @return L'objet de base qui correspond au type de matériel informatique.
	 */
	
	public static MaterielInfo creerMaterielInfo( char type ) {
		MaterielInfo materiel = null;
		
		// Créer le bon objet de base selon le type de matériel informatique reçu en paramètre.

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
	 * Redéfinition de la méthode toString() de la classe Object.
	 * 
	 * @return Les informations du matériel informatique sous forme d'une chaîne de caractères.
	 */

	@Override
	public String toString() {

		return this.getClass().getName() + "[" + this.getNoMateriel() + "," + 
			   this.getMarque() + "," + this.getModele() + "]";
	}

	/**
	 * Redéfinition de la méthode equals() de la classe Object. L'objet courant est égal à
	 * l'objet reçu en paramètre lorsque les numéros de matériel informatique sont égaux.
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

			if ( autreObjet instanceof MaterielInfo ) {

				// Convertir le type de l'autre objet en type MaterielInfo.
				MaterielInfo autre = (MaterielInfo) autreObjet;

				// Les objets sont identiques si les numéros de matériel informatique sont identiques.

				if ( this.getNoMateriel().equalsIgnoreCase( autre.getNoMateriel() ) ) {
					egalite = true;
				}
			}
		}

		return egalite;
	}
	
	/**
	 * Implémentation de la méthode compareTo() de l'interface Comparable. Un objet
	 * de type MaterielInfo est plus petit qu'un autre objet de type MaterielInfo,
	 * lorsque le numéro de matériel informatique du premier objet est alphabétiquement
	 * plus petit que le numéro de matériel informatique du deuxième objet. On ne fait
	 * pas de différence entre les caractères minuscules et les caractères majuscules.
	 * 
	 * @param autreMaterielInfo
	 *            L'autre objet à comparer avec celui courant de type MaterielInfo.
	 * 
	 * @return Une valeur négative si l'objet courant est plus petit que l'autre
	 *         objet, une valeur positive si l'objet courant est plus grand que
	 *         l'autre objet ou 0 si l'objet courant est égal à l'autre objet.
	 */

	@Override
	public int compareTo( MaterielInfo autreMaterielInfo ) {

		return this.getNoMateriel().compareToIgnoreCase( autreMaterielInfo.getNoMateriel() );
	}

	/**
	 * La méthode abstraite obtenirType() retourne le type du matériel informatique.
	 * 
	 * @return Le caractère représentant le type du matériel informatique : E, I ou O.
	 */
	
	public abstract char obtenirType();

	/**
	 * La méthode abstraite obtenirDescription() retourne la description du
	 * matériel informatique.
	 * 
	 * @return La description du matériel informatique sous forme d'une chaîne de caractères.
	 */
	
	public abstract String obtenirDescription();
}