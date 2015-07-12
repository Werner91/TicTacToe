import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import de.fhwgt.tictactoe.TicTacToeLogic;
import de.fhwgt.tictactoe.TicTacToeEvent;



/**
 * Hauptfenster von TicTacToe
 * 
 * Autor: Werner Steinbinder
 */


public class Hauptfenster extends JFrame{
	
	private TicTacToeLogic tictactoelogik;
	private Spielfeld spielfeld;
	private int spielfeld_matrix = 3;
	private JMenuBar menubar;
	private Navigator navigator;
	
	/*THread für das blinken*/
	private Thread t_spielfeld;
	
	
	
	public static void main(String args[]){

		new Hauptfenster(); // Erzeuge das Hauptfenster
	}
	
	
	public Hauptfenster(){
		super("TicTacToe"); //Fenster erstellen und Fenster einen Name geben
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // größe kann nich verändert werden
		this.setLayout(new BorderLayout()); // Dem Fenster ein BorderLayout geben
		this.init_TicTacToe();
		
		
		this.setJMenuBar(menubar = new MenuBar(this)); //Menubar im Norden des Fenster einsetzen
		this.setLocationRelativeTo(null); //Ort des Fensters auf dem Bildschirm festlegen
		navigator = new Navigator(this, this);
		this.addComponentListener(new ListenerFenster(navigator));
		this.addKeyListener(new ListenerKey());
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
	
	//Dialog nach dem Spiel
	public void drawGameResultDialog(){
		int playerchoise = 0;
		String playerchoicestrings[] = { "Neues Spiel", "Abbrechen" };
		
		if(tictactoelogik.getWinner() == TicTacToeLogic.SPIELER){
			playerchoise = JOptionPane.showOptionDialog(this, "Sie haben gewonnen!", "Gewonnen!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, playerchoicestrings, null);
		}
		if(tictactoelogik.getWinner() == TicTacToeLogic.TicTacToe){
			playerchoise = JOptionPane.showOptionDialog(this, "Sie haben verlorem!", "Verloren!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, playerchoicestrings, null);
		}
		if(tictactoelogik.getWinner() == TicTacToeLogic.FINISH){
			playerchoise = JOptionPane.showOptionDialog(this, "Unentschieden, gut gespielt", "Unentschieden!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, playerchoicestrings, null);
		}
		
		
		/*gedrueckter Dialogbutton auswerten*/
		if(playerchoise == 0){
			this.startNewGame();
		}
	}
	
	/*ein neues Spiel starten*/
	public void startNewGame(){
		this.remove(spielfeld);
		this.init_TicTacToe();
		this.pack();
	}
	
	
	//Thread erstellen
	public void createSpielfeldThread(Color color){
		t_spielfeld = new SpielfeldThread(this, color);
		t_spielfeld.start();
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