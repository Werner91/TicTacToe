import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.io.IOException;


/*
* Klasse realisiert das laden und anzeigen der Spielebschreibung
*/


public class Spielebeschreibung extends JDialog{
	
	private Hauptfenster hauptfenster;


	private JScrollPane scrollpane;
	
	
	public Spielebeschreibung(Hauptfenster _hauptfenster){
		hauptfenster = _hauptfenster;
		this.setLayout(new BorderLayout());
		this.setTitle("Spielebeschreibung");
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setText("Hier wird die Spielebeschreibung angezeigt");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		/*Scrollblaken einfügen*/
		scrollpane = new JScrollPane(editorPane);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollpane, "Center");
		
		this.setSize(600, 300);
		// Fokus nicht zwingend auf dem Fenster
		this.setModal(false); // Geht nur bei JDialog
		this.setLocationRelativeTo(hauptfenster);
		this.setVisible(true);
	
	}
	
}