package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel extends JPanel{
	private final JLabel titulo;	
  
    public Painel(String desc) {
		setBackground(new Color(192,192,192));

    	titulo = new JLabel(desc);
    	
		titulo.setForeground(Color.black);//cor da font

		titulo.setFont(new Font("SansSerif", Font.PLAIN, 30));
				
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));//10 como valor na vertical e 25 na horizontal

		
		add(titulo);
    }
}
