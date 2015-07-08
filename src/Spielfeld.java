import java.awt.*;

import javax.swing.*;

import de.fhwgt.tictactoe.TicTacToeEvent;



/**
 * Spielfeld von TicTacToe
 * 
 * Autor: Werner Steinbinder
 */


public class Spielfeld extends JPanel{
	
	private Hauptfenster hauptfenster;
	private JLabel spielfeld [][]; //Matrix Array
	//private TicTacToeEvent tictactoeevent;
	private int zeilen;
	private int spalten;
	
	public Spielfeld(Hauptfenster _hauptfenster){ //Konstruktor für das Spielfeld
		hauptfenster = _hauptfenster;
		zeilen = hauptfenster.gettictactoelogik().getSize();
		spalten = hauptfenster.gettictactoelogik().getSize();
		//tictactoeevent = new TicTacToeEvent();
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
				this.spielfeld[y_achse][x_achse].addMouseListener(new ListenerMaus(hauptfenster));
				this.spielfeld[y_achse][x_achse].setOpaque(true); //Labels sichtbar machen
				//Das Array mit den Labels zum Panel hinzufügen
				this.add(spielfeld[y_achse][x_achse]);
			}
		}
	}	
	
	public void drawSpielfeld(TicTacToeEvent e){

			if(hauptfenster.gettictactoelogik().getactivePoint() != null){
				if(e.getSpieler() == 1){
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
	
	/*
	public void clearSpielfeld(){
		for(int y_achse = 0; y_achse < zeilen; y_achse++){
			for(int x_achse = 0; x_achse < spalten; x_achse++){
				spielfeld[y_achse][x_achse].setText("");
			}
		}
	}
	*/
	
	public JLabel[][] getspielfeld_labels(){
		return spielfeld; //liefer das Spielfeld zurueck
	}
	
}