package views.cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import models.Cliente;
import views.templates.Botao;

public class TelaBuscaCliente extends JPanel {
	String label = "Atualizar";

	public TelaBuscaCliente(boolean telaBusca) {
		if(telaBusca) this.label = "Buscar";
		
		setBackground(new Color(220, 220, 220));
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JLabel cpf = new JLabel("Cpf:");
		cpf.setFont(new Font("Courier", Font.BOLD, 16));
		add(cpf);

		JTextField campoCpf = new JTextField("60792520076");
		campoCpf.setPreferredSize(new Dimension(300, 30));
		add(campoCpf);

		Botao botao = new Botao(label);
		botao.setPreferredSize(new Dimension(150, 30));
		botao.setBackground(Color.BLUE);

		add(botao);

		botao.addActionListener(event -> {
			if (!campoCpf.getText().isEmpty()) {
				try {
					Cliente c = MemoriaCliente.getInstancia().buscaCliente(campoCpf.getText());
					if (!telaBusca && verificaCliente(c))
						new TelaAtualizaCliente(c);
					else if (verificaCliente(c))
						new MostraCliente(c);
				} catch (RuntimeException e) {
					this.mostrarAlerta("Erro." + e.getMessage());
				}
			} else {
				this.mostrarAlerta("Erro. O campo é obrigatório.");
			}
		});

	}

	private boolean verificaCliente(Cliente c) {
		if (c != null) {
			return true;
		} else {
			this.mostrarAlerta("Erro. Cliente inexistente");
			return false;
		}
	}

	private void mostrarAlerta(String mensagem) {
		SwingUtilities.invokeLater(() -> {
			JOptionPane.showMessageDialog(this, mensagem);
		});
	}

}