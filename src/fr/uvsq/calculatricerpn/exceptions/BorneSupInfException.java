package fr.uvsq.calculatricerpn.exceptions;
/*
 * 1 : Exception pour la division par zero
 */
public class BorneSupInfException extends Exception{

	
	/**
     * Initialise une instance de <code>BorneSupInfException</code>.
     */
	public BorneSupInfException() {
		super("<------!!!! Op�rande non situ�e entre les bornes de la calculatrice :");
	}
	
}
