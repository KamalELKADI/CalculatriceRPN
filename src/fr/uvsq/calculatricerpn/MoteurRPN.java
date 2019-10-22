package fr.uvsq.calculatricerpn;


import java.util.Stack;

import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;


  /*
   * MoteurRPN permet d'enregistrer une op�rande, d'appliquer une op�ration sur les op�randes 
   * et de retourner l'ensemble des op�randes stock�es
   */
  
public class MoteurRPN {
 
	
	//Pile d'op�randes 
	private Stack<Double> pile;
	
	
	//La plus petite valeur de la calculatrice quand ne peut pas depass�
	private static final double MIN_VALUE = -10000.0;
	
	
	//La plus grande valeur de la calculatrice quand ne peut pas depass�
	
	private static final double MAX_VALUE = 10000.0;
	
	
	//Initisalisation de la pile dans le constructeur
	 
	public MoteurRPN() {
		pile = new Stack<Double>();
	}
	
	// 4-a : La M�thode qui permet d'enregistrer une op�rande 
	
	public Double enregistreOperande(double val)throws BorneSupInfException{
		if(Math.abs(val)>MAX_VALUE) throw new BorneSupInfException();
		if(Math.abs(val)<MIN_VALUE) throw new BorneSupInfException();
		return pile.push(val);
	}
		
	
	/*
	 * 4-b : M�thode qui fait le calcul de l'op�ration entre  les deux op�randes 
	 * et stocke le r�sultat dans la pile
	 */
	public Double calculeOperation(Operation op)throws DivisionParZeroException,BorneSupInfException{
		return enregistreOperande(op.eval(pile.pop(), pile.pop()));
	}

	
	/*
	 * Methode qui permet de savoir si une operation est possible 
	 * Test si la pile a au moins deux �l�ments
	 */
	public boolean operationPossible(){
		if(pile.size()>=2) return true;
		else return false;
	}

	/*
	 * Une M�thode qui permet d'afficher l'intervalle de nombre 
	 * entre min_value et max_value dans la console 
	 */
	
	public String specifieMinMaxValue(){
		return "MIN_VALUE = " + MIN_VALUE + " et MAX_VALUE = " + MAX_VALUE + ".";
	}

	//4-c : La M�thode qui retourne l'ensemble des operandes stock�es
	public String listeOperandes(){
		String string = "";
		for(Double val: pile){
			string += val + " ";
		}
		return string;
	}
	
	//Get de la pile du moteurRPN
	public Stack<Double> getPile() {
		return pile;
	}
}
