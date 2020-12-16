package views;

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
			setBackground(Color.BLACK);
			setForeground(Color.LIGHT_GRAY);
			setBorder(BorderFactory.createBevelBorder(0));
		}
}
