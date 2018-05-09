/**
 * Auteur  : Christian Mongeon
 * Fichier : TabObjets.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du système.
import java.io.*;

/**
 * La classe TabObjets implémente l'interface CollectionObjets et permet de
 * faire la gestion d'un tableau d'objets de type quelconque. Cette classe fait
 * donc la gestion d'un tableau universel. Cette classe est composée d'un
 * tableau d'objets de type Object et du nombre d'objets dans le tableau.
 * 
 * Cette classe implémente également l'interface Serializable.
 */

public class TabObjets implements CollectionObjets, Serializable {

	// Numéro d'identification pour la sauvegarde d'une collection d'objets.
	static final long serialVersionUID = 1;

	// Champs d'instance privés.

	private Object[] tabObjets; // Tableau d'objets.

	private int nbObjets; // Nombre d'objets dans le tableau.

	/**
	 * Constructeur qui permet d'initialiser le tableau des objets. Au début le
	 * tableau ne contient aucun objet.
	 * 
	 * @param maxObjets
	 *            Le nombre maximum d'objets du tableau.
	 */

	public TabObjets( int maxObjets ) {
		this.tabObjets = new Object[maxObjets];
		this.nbObjets = 0;
	}

	/**
	 * Implémentation de la méthode taille() qui permet de connaître le nombre
	 * d'objets dans le tableau.
	 * 
	 * @return Le nombre d'objets dans le tableau.
	 */

	@Override
	public int taille() {
		return this.nbObjets;
	}

	/**
	 * Implémentation de la méthode estVide() qui permet de vérifier si le
	 * tableau d'objets est vide.
	 * 
	 * @return true si le tableau d'objets est vide ou false dans le cas
	 *         contraire.
	 */

	@Override
	public boolean estVide() {
		return ( this.nbObjets == 0 );
	}

	/**
	 * Implémentation de la méthode estPlein() qui permet de vérifier si le
	 * tableau d'objets est plein.
	 * 
	 * @return true si le tableau d'objets est plein ou false dans le cas
	 *         contraire.
	 */

	@Override
	public boolean estPlein() {
		return ( this.nbObjets == this.tabObjets.length );
	}

	/**
	 * La méthode publique obtenirObjet() permet de retourner l'objet qui est à
	 * un certain indice dans le tableau d'objets.
	 * 
	 * @param indice
	 *            L'indice de l'objet à retourner.
	 * 
	 * @return L'objet si l'indice fait partie des limites du tableau ou null
	 *         dans le cas contraire.
	 */

	public Object obtenirObjet( int indice ) {
		Object obj = null;

		if ( indice >= 0 && indice < this.nbObjets ) {
			obj = this.tabObjets[indice];
		}

		return obj;
	}

	/**
	 * Implémentation de la méthode chercher() qui permet de chercher un objet
	 * dans le tableau d'objets. On assume que la classe des objets du tableau a
	 * redéfinit la méthode equals() de la classe Object et a implémenté la
	 * méthode compareTo() de l'interface Comparable. Le tableau est en ordre
	 * croissant. On utilise l'algorithme de la recherche binaire (recherche
	 * dichotomique).
	 * 
	 * @param obj
	 *            L'objet à chercher.
	 * 
	 * @return L'indice dans le tableau, si l'objet est présent ou la valeur -1,
	 *         si l'objet n'est pas présent.
	 */

	// On prend en charge la sécurité du code de la méthode.
	// On assume que la classe des objets du tableau implémente l'interface
	// Comparable. L'annotation @SuppressWarnings permet de supprimer
	// l'avertissement du compilateur.
	@SuppressWarnings("unchecked")

	@Override
	public int chercher( Object obj ) {
		// Recherche binaire (recherche dichotomique).

		int indTrouve = -1; // Suppose inexistant.
		int indMin = 0;
		int indMax = this.nbObjets - 1;
		int indMilieu;
		boolean finRecherche = false;

		while ( indMin <= indMax && !finRecherche ) {
			indMilieu = ( indMin + indMax ) / 2;

			if ( obj.equals( this.tabObjets[indMilieu] ) ) {
				// On a trouvé.
				indTrouve = indMilieu;
				finRecherche = true;

				// Il n'y a pas de méthode compareTo() dans la classe Object.
				// On doit convertir en type de l'interface Comparable pour
				// accéder à la méthode compareTo().

			} else if ( ( (Comparable<Object>) obj ).compareTo( this.tabObjets[indMilieu] ) < 0 ) {

				// On cherche à gauche du milieu.
				indMax = indMilieu - 1;
			} else {
				// On cherche à droite du milieu.
				indMin = indMilieu + 1;
			}
		}

		return indTrouve;
	}

	/**
	 * Implémentation de la méthode ajouter() qui permet d'ajouter un objet dans
	 * le tableau d'objets. L'ordre croissant est conservé.
	 * 
	 * @param obj
	 *            L'objet à ajouter.
	 * 
	 * @return true si l'objet a été ajouté dans le tableau ou false dans le cas
	 *         contraire.
	 */

	// On prend en charge la sécurité du code de la méthode.
	@SuppressWarnings("unchecked")

	@Override
	public boolean ajouter( Object obj ) {
		boolean insertionOk = false;

		if ( !this.estPlein() ) {

			// Commence par l'indice de fin.

			int indice = this.nbObjets - 1;

			// Tant que l'objet du tableau est plus grand que celui
			// que l'on veut insérer, on le copie à droite.

			while ( indice >= 0 && ( (Comparable<Object>) this.tabObjets[indice] ).compareTo( obj ) > 0 ) {

				this.tabObjets[indice + 1] = this.tabObjets[indice];
				--indice;
			}

			// Insérer l'objet dans le tableau.

			this.tabObjets[indice + 1] = obj;
			++this.nbObjets; // Un objet de plus dans le tableau.
			insertionOk = true;
		}

		return insertionOk;
	}

	/**
	 * Implémentation de la méthode supprimer() qui permet de supprimer un objet
	 * dans le tableau des objets.
	 * 
	 * @param indice
	 *            L'indice de l'objet à supprimer.
	 * 
	 * @return L'objet qui a été supprimé ou null s'il est impossible de
	 *         supprimer l'objet.
	 */

	@Override
	public Object supprimer( int indice ) {
		Object objSup = null; // L'objet qui sera supprimé.

		if ( !this.estVide() ) {

			if ( indice >= 0 && indice < this.nbObjets ) {

				// Conserver l'objet qui sera supprimé.

				objSup = this.tabObjets[indice];

				// Transférer les objets.

				for ( int ind = indice + 1; ind < this.nbObjets; ++ind ) {
					this.tabObjets[ind - 1] = this.tabObjets[ind];
				}

				--this.nbObjets; // Un objet de moins dans le tableau.
				this.tabObjets[this.nbObjets] = null;
			}
		}

		return objSup;
	}

	/**
	 * Implémentation de la méthode supprimer() qui permet de supprimer un objet
	 * dans le tableau des objets.
	 * 
	 * @param obj
	 *            L'objet à supprimer.
	 * 
	 * @return L'objet qui a été supprimé ou null s'il est impossible de
	 *         supprimer l'objet.
	 */

	@Override
	public Object supprimer( Object obj ) {
		Object objSup = null; // L'objet qui sera supprimé.
		int indice; // L'indice de l'objet à supprimer.

		if ( !this.estVide() ) {

			// Chercher à quel indice se trouve l'objet à supprimer et
			// le supprimer.

			indice = this.chercher( obj );

			objSup = this.supprimer( indice );
		}

		return objSup;
	}

	/**
	 * Redéfinition de la méthode toString() de la classe Object.
	 * 
	 * @return Les informations de chaque objet du tableau sous forme d'une
	 *         chaîne de caractères.
	 */
	@Override
	public String toString() {
		String infos;
		int i;

		infos = this.getClass().getName() + "[";

		for ( i = 0; i < this.nbObjets - 1; ++i ) {
			infos += this.tabObjets[i] + ",";
		}

		infos += this.tabObjets[i] + "]";

		return infos;
	}

	/**
	 * La méthode publique statique lireFicBin() permet de lire un objet de type
	 * TabObjets du fichier binaire.
	 * 
	 * @param ficLecture
	 *            Nom logique du fichier binaire déjà ouvert en mode lecture.
	 * 
	 * @return Un objet de type TabObjets ou null si fin de fichier.
	 */

	public static TabObjets lireFicBin( ObjectInputStream ficLecture ) {

		TabObjets tabObjets;

		try {
			tabObjets = (TabObjets) ficLecture.readObject();
		}

		catch ( EOFException errEOF ) {
			tabObjets = null;
		}

		catch ( ClassNotFoundException errClasse ) {
			System.out.println( "\nErreur, impossible de lire un objet de type TabObjets du fichier binaire." );
			tabObjets = null;
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'entrée-sortie avec le fichier binaire." );
			tabObjets = null;
		}

		return tabObjets;
	}

	/**
	 * La méthode ecrireFicBin() permet d'écrire l'objet courant dans le fichier
	 * binaire.
	 * 
	 * @param ficEcriture
	 *            Nom logique du fichier binaire déjà ouvert en mode écriture.
	 */

	public void ecrireFicBin( ObjectOutputStream ficEcriture ) {

		/* this fait référence à l'objet courant de type TabObjets. */

		try {
			ficEcriture.writeObject( this );
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'écriture d'un objet TabObjets dans le fichier binaire." );
		}
	}
}