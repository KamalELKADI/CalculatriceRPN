package fr.uvsq.calculatricerpn.test;


import static org.junit.Assert.*;

import org.junit.Test;

import fr.uvsq.calculatricerpn.Operation;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;



//Classe de test OperationTest fait des testes sur les différentes methodes de l'Operation

public class OperationTest {
	
	private Operation op;
	
	//Test de la constante Plus de la classe Operation
	@Test
	public void testPlus() throws DivisionParZeroException {
		op= Operation.PLUS;
		boolean test=(op.eval(2,3)==5.0);
		assertEquals(test,true);
	}
	
	//Test de la constante Moins de la classe Operation
	@Test
	public void testMoins() throws DivisionParZeroException {
		op= Operation.MOINS;
		boolean test=(op.eval(2,3)==2.0);
		assertEquals(test,true);
	}
	
	//Test de la constante Mult de la classe Operation
	@Test
	public void testMult() throws DivisionParZeroException {
		op= Operation.MULT;
		boolean test=(op.eval(2,3)==6.0);
		assertEquals(test,true);
	}
	
	//Test de la constante Div de la classe Operation
	@Test
	public void testDiv() throws DivisionParZeroException {
		op= Operation.DIV;
		boolean test=(op.eval(2,3)==1.5);
		assertEquals(test,true);
	}
	
	//Ce test effectue l'operation de division par 0 et doit retourner une exception
	@Test(expected=DivisionParZeroException.class)
	public void testDivParZero() throws DivisionParZeroException {
		op= Operation.DIV;
		op.eval(0,3);
	}	
}
