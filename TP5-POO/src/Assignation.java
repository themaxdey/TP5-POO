/**
 * Auteur  : Christian Mongeon
 * Fichier : Assignation.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du système.
import java.io.*;

/**
 * La classe Assignation contient les données et les méthodes pour une assignation de matériel
 * informatique, à un participant au programme de réemploi de matériel informatique de MomoTech.
 * Cette classe implémente les interfaces Comparable et Serializable.
 */

public class Assignation implements Comparable <Assignation>, Serializable {
	
	// Numéro d'identification pour la sauvegarde d'une assignation de matériel informatique à un participant.
	static final long serialVersionUID = 8;
	
	// Champs d'instances privés de la classe Assignation.
	
	// Le matériel informatique avec le noMateriel est assigné au participant avec le numéro noParticipant.
	private String noMateriel;
	private String noParticipant;

	/**
	 * Le constructeur Assignation() permet de construire un objet pour l'assignation de matériel
	 * informatique, connaissant seulement le numéro du matériel informatique.
	 * 
	 * @param noMateriel
	 *            Le numéro du matériel informatique.
	 */
	
	public Assignation( String noMateriel ) {
		// Exécuter l'autre constructeur.
		this( noMateriel, "" );
	}

	/**
	 * Le constructeur Assignation() permet de construire un objet pour l'assignation de matériel
	 * informatique, connaissant le numéro du matériel informatique et le numéro du participant 
	 * au programme de réemploi de matériel informatique de MomoTech.
	 * 
	 * @param noMateriel
	 *            Le numéro du matériel informatique.
	 * @param noParticipant
	 *            Le numéro du participant au programme de réemploi de matériel informatique.
	 */
	
	public Assignation( String noMateriel, String noParticipant ) {
		this.setNoMateriel( noMateriel );
		this.setNoParticipant( noParticipant );
	}
	
	/**
	 * La méthode accesseur getNoMateriel() permet de retourner le numéro du matériel informatique,
	 * qui a été assigné à un participant au programme de réemploi de matériel de MomoTech.
	 * 
	 * @return Le numéro du matériel informatique assigné à un participant au programme de réemploi de matériel.
	 */

	public String getNoMateriel() {
		return this.noMateriel;
	}
	
	/**
	 * La méthode accesseur getNoParticipant() permet de retourner le numéro
	 * du participant auquel un matériel informatique a été assigné.
	 * 
	 * @return Le numéro du participant auquel le matériel informatique a été assigné.
	 */

	public String getNoParticipant() {
		return this.noParticipant;
	}

	/**
	 * La méthode mutateur setNoMateriel() permet de modifier le numéro du matériel
	 * informatique assigné à un participant, par celui reçu en paramètre.
	 * 
	 * @param noMateriel
	 *            Le numéro du matériel informatique assigné à un participant.
	 */

	public void setNoMateriel( String noMateriel ) {
		if ( noMateriel.length() <= MaterielInfo.MAX_CAR_NO_MATERIEL ) {
			this.noMateriel = noMateriel;
		}
	}

	/**
	 * La méthode mutateur setNoParticipant() permet de modifier le numéro de participant
	 * auquel un matériel informatique a été assigné, par celui reçu en paramètre.
	 * 
	 * @param noParticipant
	 *            Le numéro de participant auquel un matériel informatique a été assigné.
	 */

	public void setNoParticipant( String noParticipant ) {
		if ( noParticipant.length() <= Participant.NB_CAR_NO_PARTICIPANT ) {
			this.noParticipant = noParticipant;
		}
	}

	/**
	 * La méthode afficher() permet d'afficher les renseignements de l'assignation d'un matériel
	 * informatique à un participant au programme de réemploi de matériel informatique.
	 */

	public void afficher() {
		System.out.println( "\nLe matériel numéro " + this.getNoMateriel() + 
							" est assigné au participant numéro " + this.getNoParticipant() );
	}

	/**
	 * Redéfinition de la méthode toString() de la classe Object.
	 * 
	 * @return Les informations de l'assignation du matériel sous forme d'une chaîne de caractères.
	 */

	@Override
	public String toString() {

		return this.getClass().getName() + "[" + this.getNoMateriel() + "," + this.getNoParticipant() + "]";
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

			if ( autreObjet instanceof Assignation ) {

				// Convertir le type de l'autre objet en type Assignation.
				Assignation autre = (Assignation) autreObjet;

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
	 * de type Assignation est plus petit qu'un autre objet de type Assignation,
	 * lorsque le numéro de matériel informatique du premier objet est alphabétiquement
	 * plus petit que le numéro de matériel informatique du deuxième objet. On ne fait 
	 * pas de différence entre les caractères minuscules et les caractères majuscules.
	 * 
	 * @param autreAssignation
	 *            L'autre objet à comparer avec celui courant de type Assignation.
	 *            
	 * @return Une valeur négative si l'objet courant est plus petit que l'autre
	 *         objet, une valeur positive si l'objet courant est plus grand que
	 *         l'autre objet ou 0 si l'objet courant est égal à l'autre objet.
	 */

	@Override
	public int compareTo( Assignation autreAssignation ) {

		return this.getNoMateriel().compareToIgnoreCase( autreAssignation.getNoMateriel() );

	}
}