/**
 * Auteur  : Christian Mongeon
 * Fichier : Assignation.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du syst�me.
import java.io.*;

/**
 * La classe Assignation contient les donn�es et les m�thodes pour une assignation de mat�riel
 * informatique, � un participant au programme de r�emploi de mat�riel informatique de MomoTech.
 * Cette classe impl�mente les interfaces Comparable et Serializable.
 */

public class Assignation implements Comparable <Assignation>, Serializable {
	
	// Num�ro d'identification pour la sauvegarde d'une assignation de mat�riel informatique � un participant.
	static final long serialVersionUID = 8;
	
	// Champs d'instances priv�s de la classe Assignation.
	
	// Le mat�riel informatique avec le noMateriel est assign� au participant avec le num�ro noParticipant.
	private String noMateriel;
	private String noParticipant;

	/**
	 * Le constructeur Assignation() permet de construire un objet pour l'assignation de mat�riel
	 * informatique, connaissant seulement le num�ro du mat�riel informatique.
	 * 
	 * @param noMateriel
	 *            Le num�ro du mat�riel informatique.
	 */
	
	public Assignation( String noMateriel ) {
		// Ex�cuter l'autre constructeur.
		this( noMateriel, "" );
	}

	/**
	 * Le constructeur Assignation() permet de construire un objet pour l'assignation de mat�riel
	 * informatique, connaissant le num�ro du mat�riel informatique et le num�ro du participant 
	 * au programme de r�emploi de mat�riel informatique de MomoTech.
	 * 
	 * @param noMateriel
	 *            Le num�ro du mat�riel informatique.
	 * @param noParticipant
	 *            Le num�ro du participant au programme de r�emploi de mat�riel informatique.
	 */
	
	public Assignation( String noMateriel, String noParticipant ) {
		this.setNoMateriel( noMateriel );
		this.setNoParticipant( noParticipant );
	}
	
	/**
	 * La m�thode accesseur getNoMateriel() permet de retourner le num�ro du mat�riel informatique,
	 * qui a �t� assign� � un participant au programme de r�emploi de mat�riel de MomoTech.
	 * 
	 * @return Le num�ro du mat�riel informatique assign� � un participant au programme de r�emploi de mat�riel.
	 */

	public String getNoMateriel() {
		return this.noMateriel;
	}
	
	/**
	 * La m�thode accesseur getNoParticipant() permet de retourner le num�ro
	 * du participant auquel un mat�riel informatique a �t� assign�.
	 * 
	 * @return Le num�ro du participant auquel le mat�riel informatique a �t� assign�.
	 */

	public String getNoParticipant() {
		return this.noParticipant;
	}

	/**
	 * La m�thode mutateur setNoMateriel() permet de modifier le num�ro du mat�riel
	 * informatique assign� � un participant, par celui re�u en param�tre.
	 * 
	 * @param noMateriel
	 *            Le num�ro du mat�riel informatique assign� � un participant.
	 */

	public void setNoMateriel( String noMateriel ) {
		if ( noMateriel.length() <= MaterielInfo.MAX_CAR_NO_MATERIEL ) {
			this.noMateriel = noMateriel;
		}
	}

	/**
	 * La m�thode mutateur setNoParticipant() permet de modifier le num�ro de participant
	 * auquel un mat�riel informatique a �t� assign�, par celui re�u en param�tre.
	 * 
	 * @param noParticipant
	 *            Le num�ro de participant auquel un mat�riel informatique a �t� assign�.
	 */

	public void setNoParticipant( String noParticipant ) {
		if ( noParticipant.length() <= Participant.NB_CAR_NO_PARTICIPANT ) {
			this.noParticipant = noParticipant;
		}
	}

	/**
	 * La m�thode afficher() permet d'afficher les renseignements de l'assignation d'un mat�riel
	 * informatique � un participant au programme de r�emploi de mat�riel informatique.
	 */

	public void afficher() {
		System.out.println( "\nLe mat�riel num�ro " + this.getNoMateriel() + 
							" est assign� au participant num�ro " + this.getNoParticipant() );
	}

	/**
	 * Red�finition de la m�thode toString() de la classe Object.
	 * 
	 * @return Les informations de l'assignation du mat�riel sous forme d'une cha�ne de caract�res.
	 */

	@Override
	public String toString() {

		return this.getClass().getName() + "[" + this.getNoMateriel() + "," + this.getNoParticipant() + "]";
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

			if ( autreObjet instanceof Assignation ) {

				// Convertir le type de l'autre objet en type Assignation.
				Assignation autre = (Assignation) autreObjet;

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
	 * de type Assignation est plus petit qu'un autre objet de type Assignation,
	 * lorsque le num�ro de mat�riel informatique du premier objet est alphab�tiquement
	 * plus petit que le num�ro de mat�riel informatique du deuxi�me objet. On ne fait 
	 * pas de diff�rence entre les caract�res minuscules et les caract�res majuscules.
	 * 
	 * @param autreAssignation
	 *            L'autre objet � comparer avec celui courant de type Assignation.
	 *            
	 * @return Une valeur n�gative si l'objet courant est plus petit que l'autre
	 *         objet, une valeur positive si l'objet courant est plus grand que
	 *         l'autre objet ou 0 si l'objet courant est �gal � l'autre objet.
	 */

	@Override
	public int compareTo( Assignation autreAssignation ) {

		return this.getNoMateriel().compareToIgnoreCase( autreAssignation.getNoMateriel() );

	}
}