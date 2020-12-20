package views.templates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import views.cliente.MemoriaCliente;
import views.funcionario.MemoriaFuncionario;

public class FormExclui extends JPanel {

	public FormExclui(String tipo, String textoLabel) {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JLabel label = new JLabel("Cpf:");
		label.setFont(new Font("Courier", Font.BOLD, 16));
		add(label);

		JTextField campo = new JTextField(textoLabel);
		campo.setPreferredSize(new Dimension(300, 30));
		add(campo);

		Botao botao = new Botao("Excluir");
		botao.setPreferredSize(new Dimension(100, 30));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);

		// Escuta o evento de click do botão cadastrar
		botao.addActionListener(event -> {
			if (!campo.getText().isEmpty()) {
				try {
					if(tipo.equalsIgnoreCase("Cliente")) {
						MemoriaCliente.getInstancia().exluirCliente(campo.getText());
					}
					else if(tipo.equalsIgnoreCase("Funcionario") || tipo.equalsIgnoreCase("Gerente") ) {
						MemoriaFuncionario.getInstancia().exluirFuncionario(campo.getText());
					}
					else if(tipo.equalsIgnoreCase("Conta")) {
						//
					}
					else {
						//agência
					}
					new Alerta("Sucesso. " + tipo + " excluído!");
				} catch (RuntimeException e) {
					new Alerta("Erro." + e.getMessage());
				}
			} else {
				new Alerta("Erro. O campo é obrigatório.");
			}
		});

	}
}
