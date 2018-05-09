/**
 * Auteur  : Christian Mongeon
 * Fichier : MomoTech.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du syst�me.
import java.io.*;

/**
 * La classe MomoTech contient les donn�es et les m�thodes pour g�rer
 * l'entreprise Momotech. Cette classe impl�mente l'interface Serializable.
 */

public class MomoTech implements Serializable {
	
	// Num�ro d'identification pour la sauvegarde de l'objet MomoTech.
	
	static final long serialVersionUID = 2;
	
	// Constantes de la classe MomoTech.
	
	public static final int MAX_MATERIEL     = 250;
	public static final int MAX_PARTICIPANTS = 50;
	
	// Champs d'instances priv�s de la classe MomoTech.
	// Chez MomoTech, on retrouve du mat�riel informatique,
	// des participants et des assignations.
	
	private TabObjets tabMateriel;
	private TabObjets tabParticipants;
	private TabObjets tabAssignations;
	
	/**
	 * Le constructeur MomoTech() permet de construire l'objet de
	 * l'entreprise MomoTech. Il initialise les objets qui g�rent tout le
	 * mat�riel informatique, tous les participants et toutes les
	 * assignations.
	 */
	
	public MomoTech() {
		this.tabMateriel = new TabObjets( MomoTech.MAX_MATERIEL );
		this.tabParticipants = new TabObjets( MomoTech.MAX_PARTICIPANTS );
		this.tabAssignations = new TabObjets( MomoTech.MAX_MATERIEL );
	}

	/**
	 * La m�thode accesseur getTabMateriel() permet de retourner l'objet qui
	 * g�re tout le mat�riel informatique.
	 * 
	 * @return L'objet qui g�re tout le mat�riel informatique.
	 */
	
	public TabObjets getTabMateriel() {
		return this.tabMateriel;
	}
	
	/**
	 * La m�thode accesseur getTabParticipants() permet de retourner l'objet qui
	 * g�re tous les participants.
	 * 
	 * @return L'objet qui g�re tous les participants.
	 */

	public TabObjets getTabParticipants() {
		return this.tabParticipants;
	}

	/**
	 * La m�thode accesseur getTabAssignations() permet de retourner l'objet qui
	 * g�re toutes les assignations.
	 * 
	 * @return L'objet qui g�re toutes les assignations.
	 */

	public TabObjets getTabAssignations() {
		return this.tabAssignations;
	}
	
	/**
	 * La m�thode publique statique lireFicBin() permet de lire un objet de type
	 * MomoTech du fichier binaire.
	 * 
	 * @param ficLecture
	 *            Nom logique du fichier binaire d�j� ouvert en mode lecture.
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
			System.out.println( "\nErreur d'entr�e-sortie avec le fichier binaire." );
			momoTech = null;
		}

		return momoTech;
	}

	/**
	 * La m�thode ecrireFicBin() permet d'�crire l'objet courant dans le fichier
	 * binaire.
	 * 
	 * @param ficEcriture
	 *            Nom logique du fichier binaire d�j� ouvert en mode �criture.
	 */
	
	public void ecrireFicBin( ObjectOutputStream ficEcriture ) {

		// this fait r�f�rence � l'objet courant de type MomoTech.

		try {
			ficEcriture.writeObject( this );
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'�criture d'un objet MomoTech dans le fichier binaire." );
		}
	}
}