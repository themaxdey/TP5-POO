/**
 * Auteur  : Christian Mongeon
 * Fichier : MainTp5.java
 * Cours   : 420-ZE4-MO (TP5, MomoTech)
 * Date    : 15 mai 2018
 */

// Packages du système.
import java.io.*;
import java.nio.file.*;

// Package du programmeur.
import outilsjava.*;

/**
 * La classe MainTp5 contient la classe principale pour le TP5. Programme de
 * réemploi de matériel informatique par l'entreprise MomoTech.
 */

public class MainTp5 {

	public static void main( String[] args ) {
		boolean peutContinuer = true;

		String nomFicTest;
		// On suppose une lecture des données du clavier.
		BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );

		char type = OutilsLecture.lireCaractereDisparate( "\nEntrez le type de test du programme (C avec clavier, " + 
														  "F avec fichier) : ", "CF" );

		if ( type == OutilsLecture.LECTURE_FICHIER ) {

			nomFicTest = OutilsFichier.lireNomFichier( "\nEntrez le nom du fichier qui contient les jeux d'essai : " );

			if ( nomFicTest.equalsIgnoreCase( "test2p2.txt" ) ) {
				try {
					Files.delete( Paths.get( "momotech" ) );
				}
				catch ( IOException errIO ) {
				}
			}

			fic = OutilsFichier.ouvrirFicTexteLecture( nomFicTest );

			if ( fic == null ) {
				peutContinuer = false;
			}
		}

		if ( peutContinuer ) {

			// Lire du clavier ou d'un fichier.
			OutilsLecture.fic = fic;
			OutilsLecture.type = type;

			/**
			 * Une instance de la classe PrincipalTp5 permet de gérer le 
			 * réemploi de matériel informatique par l'entreprise MomoTech.
			 */

			new PrincipalTp5();

		} else {
			System.out.println( "\nImpossible de tester le programme." );
		}
	}
}