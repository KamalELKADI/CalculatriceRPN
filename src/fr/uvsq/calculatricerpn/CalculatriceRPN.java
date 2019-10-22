package fr.uvsq.calculatricerpn;

import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;
import fr.uvsq.calculatricerpn.exceptions.OperationImpossibleException;

/*
 * 6 : Classe enume qui contient le programme principal (Main)
 */
public enum CalculatriceRPN {
	CALCULATRICE;
	
	public void run(String[] args) {

		try {
			SaisieRPN saisie = new SaisieRPN();
			saisie.afficheValues();
			saisie.saisie();
		}
		
		// Exception correspondant au probl�me de pile
		catch(OperationImpossibleException e) { 
			System.out.println(e.getMessage());		
		}
		
		// Exeption correspondant aux bornes des valeurs
		catch(BorneSupInfException e) {
			SaisieRPN LimiteBorne=new SaisieRPN();
			//affiche le msg d'erreur Op�rande non situ�e entre les bornes de la calculatrice : MIN_VALUE = -10000.0 et MAX_VALUE = 10000.0.
			System.out.println(e.getMessage() + LimiteBorne.getMoteur().specifieMinMaxValue() + "!!!!----->");
		}
		
		// Exception correspondant A�la division par z�ro
		catch(DivisionParZeroException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		CALCULATRICE.run(args);
	}
}
