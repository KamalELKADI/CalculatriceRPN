package fr.uvsq.calculatricerpn.frame;

import javax.swing.JFrame;

public class CalculatorFrame extends JFrame {

	public CalculatorFrame() {
		super("Calculatrice");
		Calculator cal = new Calculator();
		setContentPane(cal);
		pack();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalculatorFrame();

	}

}
