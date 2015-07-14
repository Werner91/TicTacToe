import java.awt.event.*;

/*
 * Realisiert das Mitbewegen des Navigators beim bewegen des Hauptfenster
 */


public class ListenerFenster extends ComponentAdapter{
	
	private Navigator navigator;
	
	public ListenerFenster(Navigator _navigator){
		navigator = _navigator;
	}
	
	
	public void componentMoved (ComponentEvent e){
		/*Rufe Funktion zum setzen des Navigators auf*/
		this.navigator.setNavLocation();
	}
	
	
}