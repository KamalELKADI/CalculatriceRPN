package fr.uvsq.calculatricerpn.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.calculatricerpn.MoteurRPN;
import fr.uvsq.calculatricerpn.Operation;
import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;


public class MoteurRPNTest {
	
	private MoteurRPN m;
	
	/**
	 * Setter d'initialisation du moteur
	 */
	@Before
	public void setUp() {
		m=new MoteurRPN();
	}
 
	/**
	 * Test si la pile est vide sans rien mettre dedans
	 */
	@Test
	public void testPileVide() throws BorneSupInfException{
		assertEquals(m.getPile().empty(),true);
	}
	
	/**
	 * Test si la pile poss�de un �l�ment en mettant un �l�ment dedans
	 */
	@Test
	public void testPileRemplie() throws BorneSupInfException{
		m.enregistreOperande(2.0);
		assertEquals(m.getPile().empty(),false);
	}
	
	/**
	 * Test si l'op�rande est bien celle qu'on met dans la pile
	 */
	@Test
	public void testEnregistrerOperande() throws BorneSupInfException{
		m.enregistreOperande(2.0);
		boolean test=(m.getPile().pop()==2.0);
		assertEquals(test,true);
	}
	
	/**
	 * Test si on peut ajouter un �l�ment sup�rieur au max
	 */
	@Test (expected=BorneSupInfException.class)
	public void testEnregistrerOperandeMax() throws BorneSupInfException{
		m.enregistreOperande(10001.0);
	}
	
	/**
	 * Test si on peut ajouter un �l�ment inf�rieur au min
	 */
	@Test (expected=BorneSupInfException.class)
	public void testEnregistrerOperandeMin() throws BorneSupInfException{
		m.enregistreOperande(-10001.0);
	}
	
	/**
	 * Teste si l'op�ration PLUS fonctionne
	 */
	@Test
	public void testCalculerOperationPlus() throws BorneSupInfException, DivisionParZeroException{
		m.enregistreOperande(2.0);
		m.enregistreOperande(3.0);
		boolean test=(m.calculeOperation(Operation.PLUS)==5.0);
		assertEquals(test,true);
	}

	/**
	 * Teste si l'op�ration MOINS fonctionne
	 */
	@Test
	public void testCalculerOperationMoins() throws BorneSupInfException, DivisionParZeroException{
		m.enregistreOperande(3.0);
		m.enregistreOperande(1.0);
		boolean test=(m.calculeOperation(Operation.MOINS)==2.0);
		assertEquals(test,true);
	}
	
	/**
	 * Teste si l'op�ration MULT fonctionne
	 */
	@Test
	public void testCalculerOperationMult() throws BorneSupInfException, DivisionParZeroException{
		m.enregistreOperande(3.0);
		m.enregistreOperande(2.0);
		boolean test=(m.calculeOperation(Operation.MULT)==6.0);
		assertEquals(test,true);
	}
	
	/**
	 * Teste si l'op�ration DIV fonctionne
	 */
	@Test
	public void testCalculerOperationDiv() throws BorneSupInfException, DivisionParZeroException{
		m.enregistreOperande(3.0);
		m.enregistreOperande(2.0);
		boolean test=(m.calculeOperation(Operation.DIV)==1.5);
		assertEquals(test,true);
	}
	
	/**
	 * Teste si l'op�ration DIV par 0 renvoie bien une erreur
	 */
	@Test(expected=DivisionParZeroException.class)
	public void testCalculerOperationDivParZero() throws BorneSupInfException, DivisionParZeroException{
		m.enregistreOperande(3.0);
		m.enregistreOperande(0);
		m.calculeOperation(Operation.DIV);
	}
	
	/**
	 * Teste si l'op�ration est possible
	 */
	@Test
	public void testOperationPossibleTrue() throws BorneSupInfException{
		m.enregistreOperande(3.0);
		m.enregistreOperande(2.0);
		assertEquals(m.operationPossible(),true);
	}
	
	/**
	 * Teste si l'op�ration est bien impossible sans �l�ment
	 */
	@Test
	public void testOperationPossibleFalseAucunElem() throws BorneSupInfException{
		assertEquals(m.operationPossible(),false);
	}
	
	
	/**
	 * Teste si l'op�ration est bien impossible avec 1 seul �l�ment
	 */
	@Test
	public void testOperationPossibleFalseUnElem() throws BorneSupInfException{
		m.enregistreOperande(2.0);
		assertEquals(m.operationPossible(),false);
	}

}
