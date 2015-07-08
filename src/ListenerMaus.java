import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;




/**
 * Klasse realisiert den Listener fuer Mausereignisse. Die Klasse ist abgeleitet
 * von  <code>MouseAdapter</code> und implementiert
 * das Interface <code>ActionListener</code>. 
 *   
 * @author Werner Steinbinder
 * 
 */



public class ListenerMaus extends MouseAdapter implements ActionListener{
	
	Hauptfenster hauptfenster;
	JLabel labelArray[][];
	
	
	public ListenerMaus(Hauptfenster _hauptfenster){
		hauptfenster = _hauptfenster;
	}
	
	
	public void actionPerformed(ActionEvent e){
	
	}
	
	
	/**
	 * Eventhandler fuer das Event <code>mouseClicked</code>
	 * 
	 */
	
	public void mouseClicked(MouseEvent e){
		
		System.out.println("mauslistener angekommen");
		int size_x = hauptfenster.gettictactoelogik().getSize();
		int size_y = hauptfenster.gettictactoelogik().getSize();;	
		
		//Linksklick
		if(e.getButton() == 1) {	

			/* groesse des Spielfelds */
			//size_x = hauptfenster.getDionaRapModel().getGrid().getGridSizeX();
			//size_y = hauptfenster.getDionaRapModel().getGrid().getGridSizeY();
			
			
			/* lege Spielfeld an */
			labelArray = new JLabel[size_x][size_y];
			labelArray = hauptfenster.getSpielfeld().getspielfeld_labels();
			
			/* pruefen auf welches Label der Linksklick gemacht wurde */
			for(int i = 0; i < size_y; i++){
				for(int j = 0; j < size_x; j++){
				
					if(e.getSource() == labelArray[i][j]){

						hauptfenster.gettictactoelogik().setField(i, j);
						hauptfenster.getSpielfeld().repaint();

					}
				}
			}		
		}
	}	
	
	
}