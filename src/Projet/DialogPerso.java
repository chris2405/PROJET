package Projet;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DialogPerso extends JDialog{
	
	private JButton b;
	private JTextField text;
	
	public DialogPerso(){

		
		setSize(200,100);
		b= new JButton("test2");
		text=new JTextField(10);
		Container contenu= getContentPane();
		contenu.setLayout(new FlowLayout());
		contenu.add(b);
		contenu.add(text);
		
		
}
}