/**
 * Auteur  : Christian Mongeon
 * Fichier : TabObjets.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du syst�me.
import java.io.*;

/**
 * La classe TabObjets impl�mente l'interface CollectionObjets et permet de
 * faire la gestion d'un tableau d'objets de type quelconque. Cette classe fait
 * donc la gestion d'un tableau universel. Cette classe est compos�e d'un
 * tableau d'objets de type Object et du nombre d'objets dans le tableau.
 * 
 * Cette classe impl�mente �galement l'interface Serializable.
 */

public class TabObjets implements CollectionObjets, Serializable {

	// Num�ro d'identification pour la sauvegarde d'une collection d'objets.
	static final long serialVersionUID = 1;

	// Champs d'instance priv�s.

	private Object[] tabObjets; // Tableau d'objets.

	private int nbObjets; // Nombre d'objets dans le tableau.

	/**
	 * Constructeur qui permet d'initialiser le tableau des objets. Au d�but le
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
	 * Impl�mentation de la m�thode taille() qui permet de conna�tre le nombre
	 * d'objets dans le tableau.
	 * 
	 * @return Le nombre d'objets dans le tableau.
	 */

	@Override
	public int taille() {
		return this.nbObjets;
	}

	/**
	 * Impl�mentation de la m�thode estVide() qui permet de v�rifier si le
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
	 * Impl�mentation de la m�thode estPlein() qui permet de v�rifier si le
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
	 * La m�thode publique obtenirObjet() permet de retourner l'objet qui est �
	 * un certain indice dans le tableau d'objets.
	 * 
	 * @param indice
	 *            L'indice de l'objet � retourner.
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
	 * Impl�mentation de la m�thode chercher() qui permet de chercher un objet
	 * dans le tableau d'objets. On assume que la classe des objets du tableau a
	 * red�finit la m�thode equals() de la classe Object et a impl�ment� la
	 * m�thode compareTo() de l'interface Comparable. Le tableau est en ordre
	 * croissant. On utilise l'algorithme de la recherche binaire (recherche
	 * dichotomique).
	 * 
	 * @param obj
	 *            L'objet � chercher.
	 * 
	 * @return L'indice dans le tableau, si l'objet est pr�sent ou la valeur -1,
	 *         si l'objet n'est pas pr�sent.
	 */

	// On prend en charge la s�curit� du code de la m�thode.
	// On assume que la classe des objets du tableau impl�mente l'interface
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
				// On a trouv�.
				indTrouve = indMilieu;
				finRecherche = true;

				// Il n'y a pas de m�thode compareTo() dans la classe Object.
				// On doit convertir en type de l'interface Comparable pour
				// acc�der � la m�thode compareTo().

			} else if ( ( (Comparable<Object>) obj ).compareTo( this.tabObjets[indMilieu] ) < 0 ) {

				// On cherche � gauche du milieu.
				indMax = indMilieu - 1;
			} else {
				// On cherche � droite du milieu.
				indMin = indMilieu + 1;
			}
		}

		return indTrouve;
	}

	/**
	 * Impl�mentation de la m�thode ajouter() qui permet d'ajouter un objet dans
	 * le tableau d'objets. L'ordre croissant est conserv�.
	 * 
	 * @param obj
	 *            L'objet � ajouter.
	 * 
	 * @return true si l'objet a �t� ajout� dans le tableau ou false dans le cas
	 *         contraire.
	 */

	// On prend en charge la s�curit� du code de la m�thode.
	@SuppressWarnings("unchecked")

	@Override
	public boolean ajouter( Object obj ) {
		boolean insertionOk = false;

		if ( !this.estPlein() ) {

			// Commence par l'indice de fin.

			int indice = this.nbObjets - 1;

			// Tant que l'objet du tableau est plus grand que celui
			// que l'on veut ins�rer, on le copie � droite.

			while ( indice >= 0 && ( (Comparable<Object>) this.tabObjets[indice] ).compareTo( obj ) > 0 ) {

				this.tabObjets[indice + 1] = this.tabObjets[indice];
				--indice;
			}

			// Ins�rer l'objet dans le tableau.

			this.tabObjets[indice + 1] = obj;
			++this.nbObjets; // Un objet de plus dans le tableau.
			insertionOk = true;
		}

		return insertionOk;
	}

	/**
	 * Impl�mentation de la m�thode supprimer() qui permet de supprimer un objet
	 * dans le tableau des objets.
	 * 
	 * @param indice
	 *            L'indice de l'objet � supprimer.
	 * 
	 * @return L'objet qui a �t� supprim� ou null s'il est impossible de
	 *         supprimer l'objet.
	 */

	@Override
	public Object supprimer( int indice ) {
		Object objSup = null; // L'objet qui sera supprim�.

		if ( !this.estVide() ) {

			if ( indice >= 0 && indice < this.nbObjets ) {

				// Conserver l'objet qui sera supprim�.

				objSup = this.tabObjets[indice];

				// Transf�rer les objets.

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
	 * Impl�mentation de la m�thode supprimer() qui permet de supprimer un objet
	 * dans le tableau des objets.
	 * 
	 * @param obj
	 *            L'objet � supprimer.
	 * 
	 * @return L'objet qui a �t� supprim� ou null s'il est impossible de
	 *         supprimer l'objet.
	 */

	@Override
	public Object supprimer( Object obj ) {
		Object objSup = null; // L'objet qui sera supprim�.
		int indice; // L'indice de l'objet � supprimer.

		if ( !this.estVide() ) {

			// Chercher � quel indice se trouve l'objet � supprimer et
			// le supprimer.

			indice = this.chercher( obj );

			objSup = this.supprimer( indice );
		}

		return objSup;
	}

	/**
	 * Red�finition de la m�thode toString() de la classe Object.
	 * 
	 * @return Les informations de chaque objet du tableau sous forme d'une
	 *         cha�ne de caract�res.
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
	 * La m�thode publique statique lireFicBin() permet de lire un objet de type
	 * TabObjets du fichier binaire.
	 * 
	 * @param ficLecture
	 *            Nom logique du fichier binaire d�j� ouvert en mode lecture.
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
			System.out.println( "\nErreur d'entr�e-sortie avec le fichier binaire." );
			tabObjets = null;
		}

		return tabObjets;
	}

	/**
	 * La m�thode ecrireFicBin() permet d'�crire l'objet courant dans le fichier
	 * binaire.
	 * 
	 * @param ficEcriture
	 *            Nom logique du fichier binaire d�j� ouvert en mode �criture.
	 */

	public void ecrireFicBin( ObjectOutputStream ficEcriture ) {

		/* this fait r�f�rence � l'objet courant de type TabObjets. */

		try {
			ficEcriture.writeObject( this );
		}

		catch ( IOException errIO ) {
			System.out.println( "\nErreur d'�criture d'un objet TabObjets dans le fichier binaire." );
		}
	}
}