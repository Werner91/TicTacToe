import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import de.fhwgt.tictactoe.TicTacToeLogic;
import de.fhwgt.tictactoe.TicTacToeEvent;



/**
 * Hauptfenster von TicTacToe
 * 
 * Autor: Werner Steinbinder
 */


public class Hauptfenster extends JFrame{
	
	TicTacToeLogic tictactoelogik;
	private Spielfeld spielfeld;
	private int spielfeld_matrix = 3;
	
	
	public static void main(String args[]){

		new Hauptfenster(); // Erzeuge das Hauptfenster
	}
	
	
	public Hauptfenster(){
		super("TicTacToe"); //Fenster erstellen und Fenster einen Name geben
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // größe kann nich verändert werden
		this.setLayout(new BorderLayout()); // Dem Fenster ein BorderLayout geben
		this.init_TicTacToe();
		
		this.setLocationRelativeTo(null); //Ort des Fensters auf dem Bildschirm festlegen
		this.pack(); //Inhalt bzw. BorderLayout auf nötige größe skalieren
		this.setVisible(true); //Fenster sichtbar machen
		this.requestFocus(); //Um den Focus
	}
	
	
	public void init_TicTacToe(){
		tictactoelogik = new TicTacToeLogic(spielfeld_matrix);
		this.tictactoelogik.addTicTacToeListener(new Listener(this));

		this.spielfeld = new Spielfeld(this);
		this.add(BorderLayout.CENTER, spielfeld);
		
		
	}
	
	//Das Spielfeld neu Zeichnen
	public void repaintGame(TicTacToeEvent e){
		//this.getSpielfeld().clearSpielfeld();
		this.getSpielfeld().drawSpielfeld(e);
		
	}

	
	public TicTacToeLogic gettictactoelogik(){
		return tictactoelogik; //liefert die Spielelogik zurück
	}
	
	
	
	public Spielfeld getSpielfeld(){
		return spielfeld;
	}
	
}