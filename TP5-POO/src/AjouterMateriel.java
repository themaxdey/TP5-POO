/**
 * Auteurs : Maxime Dery & Jean-Sebastien Beaulne et Christian Mongeon
 * Fichier : AjouterMateriel.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Package du programmeur.
import outilsjava.*;

/**
 * La classe AjouterMateriel permet de faire des ajouts de matériel
 * informatique, pour le programme de réemploi de matériel informatique de
 * l'entreprise MomoTech. Cette classe implémente l'interface OutilsConstantes.
 */

public class AjouterMateriel implements OutilsConstantes {

	/**
	 * Le constructeur AjouterMateriel() permet de gérer les ajouts de matériel
	 * informatique, pour le programme de réemploi de matériel informatique de
	 * l'entreprise MomoTech.
	 * 
	 * @param momoTech
	 *            L'objet qui gère l'entreprise MomoTech.
	 */

	public AjouterMateriel( MomoTech momoTech ) {
		// Constantes locales.
		final String MESS_PLEIN = "\nImpossible d'ajouter du matériel. Le nombre maximum est atteint.";
		final String TITRE = "\nAjout de matériel informatique.";
		final String MESS_DEVENU_PLEIN = "\nAjout de matériel terminé. Le nombre maximum est atteint.";
		final String QUEST_AUTRE_MATERIEL = "\nVoulez-vous ajouter un autre matériel informatique (O ou N) ? ";

		char rep = NON;

		if ( momoTech.getTabMateriel().estPlein() ) {
			System.out.println( MESS_PLEIN );
		} else {
			MaterielInfo matTemp, materiel;
			int indiceMat;
			char typeMat;

			do {
				System.out.println( TITRE );

				matTemp = MaterielInfo.creerMaterielInfo();
				matTemp.lireNoMateriel();

				indiceMat = momoTech.getTabMateriel().chercher( matTemp );

				if ( indiceMat != 1 ) {

					System.out.println( "\nLe matériel informatique no " + matTemp.getNoMateriel() + " existe déjà." );

				} else {

					typeMat = OutilsLecture.lireCaractereDisparate( MaterielInfo.QUEST_TYPE_BASE,
							MaterielInfo.TYPES_MATERIEL );
					materiel = MaterielInfo.creerMaterielInfo( typeMat );

					materiel.setNoMateriel( matTemp.getNoMateriel() );
					materiel.lireAutresRenseignements();
					momoTech.getTabMateriel().ajouter( materiel );

					System.out.println( "Le matériel numéro " + materiel.getNoMateriel() + " de type "
							+ materiel.obtenirDescription() + " a été ajouté." );

				}

				// ---------------------------------------------------------
				// Avons-nous atteint le maximum de matériel informatique ?

				if ( momoTech.getTabMateriel().estPlein() ) {
					System.out.println( MESS_DEVENU_PLEIN );
					rep = NON;
				} else {
					rep = OutilsLecture.lireOuiNon( QUEST_AUTRE_MATERIEL );
				}
			} while ( rep == OUI );
		}
	}
}