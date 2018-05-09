/**
 * Auteur  : Christian Mongeon
 * Fichier : MomoTech.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du système.
import java.io.*;

/**
 * La classe MomoTech contient les données et les méthodes pour gérer
 * l'entreprise Momotech. Cette classe implémente l'interface Serializable.
 */

public class MomoTech implements Serializable {
	
	// Numéro d'identification pour la sauvegarde de l'objet MomoTech.
	
	static final long serialVersionUID = 2;
	
	// Constantes de la classe MomoTech.
	
	public static final int MAX_MATERIEL     = 250;
	public static final int MAX_PARTICIPANTS = 50;
	
	// Champs d'instances privés de la classe MomoTech.
	// Chez MomoTech, on retrouve du matériel informatique,
	// des participants et des assignations.
	
	private TabObjets tabMateriel;
	private TabObjets tabParticipants;
	private TabObjets tabAssignations;
	
	/**
	 * Le constructeur MomoTech() permet de construire l'objet de
	 * l'entreprise MomoTech. Il initialise les objets qui gèrent tout le
	 * matériel informatique, tous les participants et toutes les
	 * assignations.
	 */
	
	public MomoTech() {
		this.tabMateriel = new TabObjets( MomoTech.MAX_MATERIEL );
		this.tabParticipants = new TabObjets( MomoTech.MAX_PARTICIPANTS );
		this.tabAssignations = new TabObjets( MomoTech.MAX_MATERIEL );
	}

	/**
	 * La méthode accesseur getTabMateriel() permet de retourner l'objet qui
	 * gère tout le matériel informatique.
	 * 
	 * @return L'objet qui gère tout le matériel informatique.
	 */
	
	public TabObjets getTabMateriel() {
		return this.tabMateriel;
	}
	
	/**
	 * La méthode accesseur getTabParticipants() permet de retourner l'objet qui
	 * gère tous les participants.
	 * 
	 * @return L'objet qui gère tous les participants.
	 */

	public TabObjets getTabParticipants() {
		return this.tabParticipants;
	}

	/**
	 * La méthode accesseur getTabAssignations() permet de retourner l'objet qui
	 * gère toutes les assignations.
	 * 
	 * @return L'objet qui gère toutes les assignations.
	 */

	public TabObjets getTabAssignations() {
		return this.tabAssignations;
	}
	
	/**
	 * La méthode publique statique lireFicBin() permet de lire un objet de type
	 * MomoTech du fichier binaire.
	 * 
	 * @param ficLecture
	 *            Nom logique du fichier binaire déjà ouvert en mode lecture.
	 * 
	 * @return Un objet de type MomoTech ou null si fin de fichier.
	 */
	
	public static MomoTech lireFicBin( ObjectInputStream ficLecture ) {

		MomoTech momoTech;

		try {
			momoTech = (MomoTech) ficLecture.readObject();
		}

		catch ( EOFException errEOF ) {
			momoTech = null;
		}

		catch ( ClassNotFoundException errClasse ) {
			System.out.println( "\nErreur, impossible de lire un objet de type MomoTech du fichier binaire." );
			momoTech = null;
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'entrée-sortie avec le fichier binaire." );
			momoTech = null;
		}

		return momoTech;
	}

	/**
	 * La méthode ecrireFicBin() permet d'écrire l'objet courant dans le fichier
	 * binaire.
	 * 
	 * @param ficEcriture
	 *            Nom logique du fichier binaire déjà ouvert en mode écriture.
	 */
	
	public void ecrireFicBin( ObjectOutputStream ficEcriture ) {

		// this fait référence à l'objet courant de type MomoTech.

		try {
			ficEcriture.writeObject( this );
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'écriture d'un objet MomoTech dans le fichier binaire." );
		}
	}
}