package fr.uvsq.calculatricerpn.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JPanel {
    private JLabel screen;
    private JPanel container;
    
    public Calculator() {
		container = new JPanel(new BorderLayout(5,5));
		add(container);
		createScreen();
		createButtons();
	}
    private void createScreen()
    {
    	screen = new JLabel("0");
    	container.add("North",screen);
    	screen.setPreferredSize(new Dimension(200, 50));
    	screen.setBorder(BorderFactory.createEtchedBorder());
    	screen.setFont(new Font("Consolas",Font.PLAIN, 26));
    	screen.setHorizontalAlignment(JLabel.RIGHT);
    	screen.setOpaque(true);//rendre la couleur du label 
    	screen.setBackground(new Color(200, 200, 200));
    }
    private void createButtons()
    {
    	JPanel p = new JPanel(new GridLayout(4,4,6,6));
    	container.add("Center", p);
    	char t[][]={
    			{'7','8','9','/'},
    			{ '4','5','6','*'},
    			{'1','2','3','-'},
    			{'0',',','+','E'}
    	};
    	 
    	for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				JButton b = new JButton(""+t[i][j]);
				b.setFont(new Font("Calibri",Font.PLAIN, 18));
				b.setForeground(new Color(50, 50, 140));
				b.setFocusable(false);
				p.add(b);
			}
		} 
    	 
    	
    }
}
