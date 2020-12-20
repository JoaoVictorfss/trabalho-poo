package views.templates;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Botao extends JButton {
	    //Monta o botão
		public Botao(String texto) {
			setText(texto);
			setFont(new Font("courier", Font.PLAIN, 22));
			setOpaque(true);
			setBackground(new Color(229, 197, 25));
			setForeground(Color.white);
			setBorder(BorderFactory.createBevelBorder(0));
		}
}
