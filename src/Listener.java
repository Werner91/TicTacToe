import de.fhwgt.tictactoe.TicTacToeEvent;
import de.fhwgt.tictactoe.TicTacToeListener;
import de.fhwgt.tictactoe.TicTacToeLogic;
import java.awt.*;


public class Listener implements TicTacToeListener{
	
	private Hauptfenster hauptfenster;
	
	Listener(Hauptfenster _hauptfenster){
		this.hauptfenster = _hauptfenster;
	}
	
	
	//es wurde ein Feld im Spielfeld gesetzt
	public void ModelChanged(TicTacToeEvent e) { 
		//spielfeld neu zeichnen, da ein spieler ein kreuz gesetzt hat, oder die spielelogik
		hauptfenster.repaintGame(e);
	}
	
	
	/*Spielzustand hat sich geändert
	 *Zustände sind: 
	 *	- Spieler hat gewonnen
	 *  - TicTacToe hat gewonnen
	 *  - unentschieden
	 */
	
	public void StatusChanged(TicTacToeEvent e) {
		
		
		if(hauptfenster.gettictactoelogik().getWinner() == TicTacToeLogic.NOWINNER){
			System.out.println("noch kein Gewinner, spiel läuft");
			
		}
		
		if(hauptfenster.gettictactoelogik().getWinner() == TicTacToeLogic.SPIELER){
			System.out.println("Spieler hat gewonnen");
			
		}
		
		if(hauptfenster.gettictactoelogik().getWinner() == TicTacToeLogic.TicTacToe){
			System.out.println("Spielelogik ist Gewinner");
	
		}
		
		if(hauptfenster.gettictactoelogik().getWinner() == TicTacToeLogic.FINISH){
			System.out.println("Unentschieden");

		}
	}
	
	public void paintBackground(Color color){
		hauptfenster.getSpielfeld().getspielfeld_labels();
	}
	
	
}