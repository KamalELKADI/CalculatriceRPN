package fr.uvsq.calculatricerpn;

import java.util.Scanner;

import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;
import fr.uvsq.calculatricerpn.exceptions.OperationImpossibleException;

/*
 * 5 : Classe qui g�re les interactions avec l�utilisateur et invoque le moteur RPN. 
 */
public class SaisieRPN {
	
	//Attribut scanner qui permet de gerer les saisies 
	private Scanner scanner;
	
	//Attribut  moteur qui permet d'enregistrer une op�rande, d'appliquer une op�ration sur les op�randes .  
	private MoteurRPN moteur;

	
    //Constructeur de Saisie qui initialise les attributs moteur et scanner
	public SaisieRPN() {
		this.scanner = new Scanner(System.in);
		this.moteur = new MoteurRPN();
	}

    // Cette m�thode permet de g�rer les saisies de l'utilisateur
	public void saisie() throws OperationImpossibleException,BorneSupInfException,DivisionParZeroException{
		String string = "";
		boolean arret = false;
		System.out.println("Veillez Saisir un nombre, op�ration ou exit pour quitter la calculatrice.");
		while (arret == false) {
			
			if (scanner.hasNextDouble()) { // si la saisie est un nombre
				moteur.enregistreOperande(scanner.nextDouble()); // on met le nombre en haut de la pile
				System.out.println(moteur.listeOperandes()); // affichage op�rande
				string = scanner.nextLine(); // lecture de la prochaine saisie
			}
			
			else { // si la saisie est une op�ration ou une chaine de caract�re
				string = scanner.nextLine();
				if (this.testeOperation(string)) // si la saisie est une op�ration
					if (moteur.operationPossible()) { // si la pile a au moins deux �l�ments
						// enl�ve les deux premiers �l�ments, fait l'op�ration et met le r�sultat dans la pile 
						moteur.calculeOperation(renvoieOperation(string)); 
						System.out.println(moteur.listeOperandes());  
					} 
				     else throw new OperationImpossibleException(); // sinon si la pile n'a pas au moins deux �l�ments 		
				// si la saisie est "exit", on arrête le programme 
				else if (string.equals("exit")) {
					arret = true;
					System.out.println("END !!!");
				}
				
				
			}
		}
	}
	
    //M�thode permet de savoir si une chaine de caract�re correspond � PLUS, MOINS, MULT, DIV 
	public boolean testeOperation(String string) {
		if (string.length() != 1)
			return false;
	
		return renvoieOperation(string) != null;
	}

    //M�thode qui renvoie l'op�ration
	public Operation renvoieOperation(String string) {
		for (Operation op : Operation.values())
			if (string.charAt(0) == op.getSymbole())
				return op;
		return null;
	
	}
	
	// Get de l'attribut moteur	 
	public MoteurRPN getMoteur() {
		return this.moteur;
	}

	//M�thode qui permet d'afficher les op�randes qui sont stock�s dans la pile 
	public void afficheValues(){
		System.out.println(moteur.listeOperandes());
	}		
	
	
	
	

}
