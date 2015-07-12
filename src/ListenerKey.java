import java.awt.event.*;


public class ListenerKey extends KeyAdapter implements KeyListener{
	
	public void keyTyped(KeyEvent e){
		Hauptfenster hauptfenster = (Hauptfenster) e.getSource();
		
		
		if(e.getKeyChar() == '1'){
			hauptfenster.gettictactoelogik().setField(2, 0);
			hauptfenster.getSpielfeld().repaint();
		}
		
		
		if(e.getKeyChar() == '2'){
			hauptfenster.gettictactoelogik().setField(2, 1);
			hauptfenster.getSpielfeld().repaint();
		}
		
		if(e.getKeyChar() == '3'){
			hauptfenster.gettictactoelogik().setField(2, 2);
			hauptfenster.getSpielfeld().repaint();
		}
		
		if(e.getKeyChar() == '4'){
			hauptfenster.gettictactoelogik().setField(1, 0);
			hauptfenster.getSpielfeld().repaint();
		}
		
		
		if(e.getKeyChar() == '5'){
			hauptfenster.gettictactoelogik().setField(1, 1);
			hauptfenster.getSpielfeld().repaint();
		}
		
		if(e.getKeyChar() == '6'){
			hauptfenster.gettictactoelogik().setField(1, 2);
			hauptfenster.getSpielfeld().repaint();
		}
		
		if(e.getKeyChar() == '7'){
			hauptfenster.gettictactoelogik().setField(0, 0);
			hauptfenster.getSpielfeld().repaint();
		}
		
		if(e.getKeyChar() == '8'){
			hauptfenster.gettictactoelogik().setField(0, 1);
			hauptfenster.getSpielfeld().repaint();
		}
		
		if(e.getKeyChar() == '9'){
			hauptfenster.gettictactoelogik().setField(0, 2);
			hauptfenster.getSpielfeld().repaint();
		}
		
		
		
	}
	
	
	
}