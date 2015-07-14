import java.awt.Color;
import javax.swing.BorderFactory;

/*
 * Klasse realisiert Das Blinken des Spielfelds nach dem das Spiel zuende ist
 */

class SpielfeldThread extends Thread{
	
	private Hauptfenster hauptfenster;
	private Color color;
	private static final int blinktime = 500;
	
	public SpielfeldThread(Hauptfenster _hauptfenster, Color _color){
		hauptfenster = _hauptfenster;
		color = _color;
	}
	
	public void run(){
		for(int i=0; i<10; i++){
			
				if(i%2 == 0){
					//Aender die Farbe des Randes
					hauptfenster.getSpielfeld().setBorder(BorderFactory.createLineBorder(Color.red, 2));
					//Aendert die Hintergrundfarbe
					hauptfenster.getSpielfeld().paintBackground(color);
				}else{
					hauptfenster.getSpielfeld().setBorder(BorderFactory.createLineBorder(Color.black, 0));
					hauptfenster.getSpielfeld().paintBackground(null);
				}
				hauptfenster.getSpielfeld().updateUI();
			try{
				/*Thread schlafen legen*/
				Thread.sleep(blinktime);
			}catch(InterruptedException ex){
				System.out.println("Catch exception in SpielfeldThread");
				System.out.println(ex.getStackTrace());
			}
		}
	}	
}