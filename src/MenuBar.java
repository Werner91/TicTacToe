import javax.swing.*;
import java.awt.event.*;



public class MenuBar extends JMenuBar implements ActionListener{

	Hauptfenster hauptfenster;
	
	//Menuleiste Elemente
	private JMenu spiel;
	private JMenu hilfe;
	
	
	//Elemente im Tab "spiel"
	private JMenuItem neuesspiel;
	private JMenu lookandfeel;
	
	//Elemente im Tab "Hilfe"
	private JMenuItem spielebeschreibung;
	
	
	//Look and Feel Array
	private UIManager.LookAndFeelInfo lookandfeelinfoarray[];
	//Look and Feel Radiobutton Array
	private JRadioButtonMenuItem lookandfeelradiobuttonarray [];
	//aktiver Look and Feel Radiobutton
	private int active_radiobutton = 0;
	//Anzahl an vorhandenen Look and Feels
	private int lookandfeelcounter;
	
	
	public MenuBar (Hauptfenster _hauptfenster){
		
		hauptfenster = _hauptfenster;	
		spiel = new JMenu("Spiel");
		hilfe = new JMenu("Hilfe");
		spielebeschreibung = new JMenuItem("Spielebeschreibung");
		spielebeschreibung.addActionListener(this);
		neuesspiel = new JMenuItem("Neues Spiel");
		neuesspiel.addActionListener(this); // !!!!!!!!!!!!!!!!!!
	
		
		//Look and Feel
		lookandfeel = new JMenu("Look&Feel");
		lookandfeel.addActionListener(this);
		lookandfeelinfoarray  = UIManager.getInstalledLookAndFeels();
		lookandfeelcounter = lookandfeelinfoarray.length;
		lookandfeelradiobuttonarray = new JRadioButtonMenuItem[lookandfeelcounter];
		for(int i = 0; i < lookandfeelcounter; i++){
			//fuelle RadiobuttonMenu mit installierten Look and Feels
			lookandfeelradiobuttonarray[i] = new JRadioButtonMenuItem (lookandfeelinfoarray[i].getName());
			//fuege Menupunkt hinzu
			lookandfeel.add(lookandfeelradiobuttonarray[i]);
			lookandfeelradiobuttonarray[i].addActionListener(this);
			//lege aktuelles look and feel fest
			if(UIManager.getLookAndFeel().getName().equals(lookandfeelinfoarray[i].getName())){
				lookandfeelradiobuttonarray[i].setSelected(true);
				active_radiobutton = i;
			}
		}

		
		
		spiel.add(neuesspiel);
		spiel.add(lookandfeel);
		hilfe.add(spielebeschreibung);
		this.add(spiel); // Item zu Menuleiste hinzufuegen
		this.add(hilfe);
		

	}
	
	
	/*Events von den  Elementen in der Menuleiste werden verarbeitet*/
	public void actionPerformed (ActionEvent e){
		
		//Fenster mit der Spielebeschreibung �ffne
		if(e.getSource() == spielebeschreibung){
			new Spielebeschreibung(hauptfenster);
		}
		
		/*Welches Menuleistenelement hat das Event ausgeloest*/
		
		if(e.getSource() == neuesspiel){	
			JOptionPane.showMessageDialog(hauptfenster, "Es wird ein neues Spiel gestartet"); //Dialogfenster mit einer Nacchricht und "ok" button
			hauptfenster.startNewGame();
		}
		
		/* Look and Feel*/
		/* gehe alle Radio Buttons durch */
		for(int i=0; i < lookandfeelcounter; i++){
			if(e.getSource() == lookandfeelradiobuttonarray[i]){
				lookandfeelradiobuttonarray[active_radiobutton].setSelected(false);
				active_radiobutton = i;
				try{
					UIManager.setLookAndFeel(lookandfeelinfoarray[i].getClassName());
					SwingUtilities.updateComponentTreeUI(hauptfenster);
				}catch(ClassNotFoundException e1){
					//TODO Autogenerated catch block
					e1.printStackTrace();
				}catch(InstantiationException e1){
					//TODO Auto-generated catch block
					e1.printStackTrace();
				}catch(IllegalAccessException e1){
					//TODO Auto-generated catch block
					e1.printStackTrace();
				}catch(UnsupportedLookAndFeelException e1){
					//TODO autogenerated catch block
					e1.printStackTrace();
				}
				hauptfenster.pack();
			}
			
		}
		
	}
	
	
}
