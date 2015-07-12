import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Navigator extends JWindow implements ActionListener{

	private JPanel rahmen;
	private JButton neuesSpielButton;
	private Hauptfenster hauptfenster;
	
	public Navigator (JFrame parent, Hauptfenster _hauptfenster){
		
		super(parent); //Konstruktor für das Vaterfenster
		hauptfenster = _hauptfenster;
		rahmen = new JPanel(); // Instanz von JPanel erzeugen
		rahmen.setLayout(new BorderLayout());
		neuesSpielButton = new JButton();
		neuesSpielButton.setText("Neues Spiel");
		neuesSpielButton.addActionListener(this);
		rahmen.add(BorderLayout.CENTER, neuesSpielButton);
		this.add(rahmen);
		this.setNavLocation();
		this.setVisible(true);
		this.pack();
		this.setFocusableWindowState(false);
		
	}
	
	public void setNavLocation(){
		//Navigator rechts neben dem Fenster platzieren
		this.setLocation(getParent().getLocation().x + getParent().getWidth() + 50, getParent().getLocation().y);
	}
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == neuesSpielButton){
			hauptfenster.startNewGame();
		}
	}
	
}