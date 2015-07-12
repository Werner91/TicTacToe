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
			hauptfenster.getSpielfeld().paintBackground(Color.GREEN);
			hauptfenster.getSpielfeld().removeMausListener();
			hauptfenster.createSpielfeldThread(Color.GREEN);
			hauptfenster.drawGameResultDialog();
			
		}
		
		if(hauptfenster.gettictactoelogik().getWinner() == TicTacToeLogic.TicTacToe){
			System.out.println("Spielelogik ist Gewinner");
			hauptfenster.getSpielfeld().paintBackground(Color.YELLOW);
			hauptfenster.getSpielfeld().removeMausListener();
			hauptfenster.createSpielfeldThread(Color.YELLOW);
			hauptfenster.drawGameResultDialog();
		}
		
		if(hauptfenster.gettictactoelogik().getWinner() == TicTacToeLogic.FINISH){
			System.out.println("Unentschieden");
			hauptfenster.getSpielfeld().paintBackground(Color.RED);
			hauptfenster.getSpielfeld().removeMausListener();
			hauptfenster.createSpielfeldThread(Color.RED);
			hauptfenster.drawGameResultDialog();
		}
	}
	
	
	
	
}