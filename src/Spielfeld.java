import java.awt.*;

import javax.swing.*;
import de.fhwgt.tictactoe.TicTacToeEvent;
import de.fhwgt.tictactoe.TicTacToeLogic;


/**
 * Spielfeld von TicTacToe
 * 
 * Autor: Werner Steinbinder
 */


public class Spielfeld extends JPanel{
	
	private Hauptfenster hauptfenster;
	private JLabel spielfeld [][]; //Matrix Array
	private int zeilen;
	private int spalten;
	private ListenerMaus mauslistener; //mauslistener
	
	
	public Spielfeld(Hauptfenster _hauptfenster){ //Konstruktor für das Spielfeld
		hauptfenster = _hauptfenster;
		zeilen = hauptfenster.gettictactoelogik().getSize();
		spalten = hauptfenster.gettictactoelogik().getSize();
		mauslistener = new ListenerMaus(hauptfenster);
		this.createSpielfeld();//Spielfeld erzeugen
	}

	public void createSpielfeld(){
		this.setLayout( new GridLayout(zeilen, spalten)); //Das JLabel bekommt ein Gridlayout
		spielfeld = new JLabel [zeilen][spalten]; //Spielfeld ist ein Matrix Array (initialisieren)
		
		
		for(int y_achse = 0; y_achse < zeilen; y_achse++){
			for(int x_achse = 0; x_achse < spalten; x_achse++){
				// Label mit 70 x 70 pixel anlegen
				spielfeld[y_achse][x_achse] = new JLabel();
				spielfeld[y_achse][x_achse].setPreferredSize(new Dimension(70,70));
				spielfeld[y_achse][x_achse].setBorder(BorderFactory.createLineBorder(Color.black));
				/* Listener registrieren */
				this.spielfeld[y_achse][x_achse].addMouseListener(mauslistener);
				this.spielfeld[y_achse][x_achse].setOpaque(true); //Labels sichtbar machen
				//Das Array mit den Labels zum Panel hinzufügen
				this.add(spielfeld[y_achse][x_achse]);
			}
		}
	}	
	
	public void drawSpielfeld(TicTacToeEvent e){

			if(hauptfenster.gettictactoelogik().getactivePoint() != null){
				if(e.getSpieler() == TicTacToeLogic.SPIELER){
					this.spielfeld[hauptfenster.gettictactoelogik().getactivePoint().x][hauptfenster.gettictactoelogik().getactivePoint().y].setText("O");
					this.spielfeld[hauptfenster.gettictactoelogik().getactivePoint().x][hauptfenster.gettictactoelogik().getactivePoint().y].setHorizontalAlignment(JLabel.CENTER);
				}else{
					this.spielfeld[hauptfenster.gettictactoelogik().getactivePoint().x][hauptfenster.gettictactoelogik().getactivePoint().y].setText("X");
					this.spielfeld[hauptfenster.gettictactoelogik().getactivePoint().x][hauptfenster.gettictactoelogik().getactivePoint().y].setHorizontalAlignment(JLabel.CENTER);
				}
			}
			
			hauptfenster.gettictactoelogik().printBoard(); //Gibt die Besetzung des Spielfeldes als Text auf die Konsole aus
			System.out.println();
			System.out.println();
	}
	
	
	//entfernde den MausListener nach dem Spielende
		public void removeMausListener(){			
			for(int y_achse = 0; y_achse < zeilen; y_achse++){
				for(int x_achse = 0; x_achse < spalten; x_achse++){
					this.spielfeld[y_achse][x_achse].removeMouseListener(mauslistener);
				}
			}
		}
	
	public void paintBackground(Color color){
		for(int y_achse = 0; y_achse < zeilen; y_achse++){
			for(int x_achse = 0; x_achse < spalten; x_achse++){	
				spielfeld[y_achse][x_achse].setBackground(color);;
				this.add(spielfeld[y_achse][x_achse]);
			}
		}
	}
	
	public JLabel[][] getspielfeld_labels(){
		return spielfeld; //liefer das Spielfeld zurueck
	}
	
}