package fr.uvsq.calculatricerpn;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;


/*
 * Classe d'énumeration Operation qui permet de définir les differentes opérations des opérandes.
 */
public enum Operation {
	
	/*
	 * 3-d :  Constante qui définit l'opération + (ADDITION)
	 */
	PLUS('+') { 

		/*
		 * 3-e : Méthode de l'évaluation pour l'addition
		 */
		public double eval(double op1, double op2) {
			return op1 + op2;
		}
	},
	

	/*
	 * 3-d :Constante qui définit l'opération - (SOUSTRACTION)
	 */
	MOINS('-') {
		
		/*
		 * 3-e : Méthode de l'évaluation pour la soustraction
		 */
		public double eval(double op1, double op2) {
			return op2 - op1;
		}
	},
	
	
	/*
	 * 3-d :Constante qui définit l'opération * (MULTIPLICATION)
	 */
	MULT('*') {
		
		/*
		 * 3-e : Méthode de l'évaluation pour la multiplication
		 */
		public double eval(double op1, double op2) {
			return op1 * op2;
		}
	},
	
	
	/*
	 * 3-d :Constante qui définit l'opération / (DIVISION)
	 */
	DIV('/') {
		
		/*
		 * 3-e : Méthode de l'évaluation pour la division
		 */
		public double eval(double op1, double op2) throws DivisionParZeroException{
			if(op1==0) throw new DivisionParZeroException();
			return op2 / op1;
		}
	};
	
	
	/*
	 * 3-a : Attribut Symbole représentant l'opérateur 
	 */
	private char symbole;
	

	/*
	 * 3-b : Constructeur privée de l'énumération de l'opération
	 */
	private Operation(char symbole) {
		this.symbole=symbole;
	}
	
	/*
	 * 3-c : La méthode eval qui retourne retournant le résultat 
	 * de l’évaluation de l’opération sur deux opérandes.
	 */
	public abstract double eval(double op1, double op2)throws DivisionParZeroException;
	
	
	public char getSymbole() {
		return symbole;
	}
}

