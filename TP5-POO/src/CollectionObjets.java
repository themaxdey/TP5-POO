/**
 * Auteur  : Christian Mongeon
 * Fichier : CollectionObjets.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

/**
 * L'interface CollectionObjets permet d'indiquer les opérations de base pour
 * la gestion d'une collection d'objets. Cette interface ne précise pas
 * comment les objets sont organisés, mais définit le comportement
 * d'une collection d'objets.
 */

public interface CollectionObjets {
	
	/**
	 * La méthode taille() permet de connaître le nombre d'objets de la
	 * collection.
	 * 
	 * @return Le nombre d'objets de la collection.
	 */
	
	public abstract int taille();

	/**
	 * La méthode estVide() permet de vérifier si la collection est vide.
	 * 
	 * @return true si la collection est vide ou false dans le cas contraire.
	 */
	
	public abstract boolean estVide();

	/**
	 * La méthode estPlein() permet de vérifier si la collection est pleine.
	 * 
	 * @return true si la collection est pleine ou false dans le cas contraire.
	 */
	
	public abstract boolean estPlein();

	/**
	 * La méthode chercher() permet de chercher un objet dans la collection.
	 * 
	 * @param obj
	 *            L'objet à chercher.
	 * 
	 * @return L'indice dans la collection, si l'objet est présent ou 
	 *         la valeur -1, si l'objet n'est pas présent.
	 */	
	
	public abstract int chercher( Object obj );
	
	/**
	 * La méthode ajouter() permet d'ajouter un objet dans la collection.
	 * 
	 * @param obj
	 *            L'objet à ajouter.
	 * 
	 * @return true si l'objet a été ajouté ou false dans le cas contraire.
	 */
	
	public abstract boolean ajouter( Object obj );

	/**
	 * La méthode supprimer() permet de supprimer l'objet qui se trouve à une
	 * certaine position dans la collection.
	 * 
	 * @param indice
	 *            L'indice de l'objet à supprimer.
	 * 
	 * @return L'objet qui a été supprimé ou null s'il est impossible de
	 *         supprimer l'objet.
	 */
	
	public abstract Object supprimer( int indice );

	/**
	 * La méthode supprimer() permet de supprimer un objet dans la collection.
	 * 
	 * @param obj
	 *            L'objet à supprimer.
	 * 
	 * @return L'objet qui a été supprimé ou null s'il est impossible de
	 *         supprimer l'objet.
	 */
	
	public abstract Object supprimer( Object obj );
}