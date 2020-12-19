package views.templates;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Alerta extends JPanel{
	
	public Alerta(String mensagem) {
		SwingUtilities.invokeLater(() -> {
			JOptionPane.showMessageDialog(this, mensagem);
		});
	}
}
