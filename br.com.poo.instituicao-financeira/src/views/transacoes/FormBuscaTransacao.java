package views.transacoes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Agencia;
import models.Conta;
import models.Transacao;
import views.agencia.MemoriaAgencia;
import views.conta.MemoriaConta;
import views.templates.Alerta;
import views.templates.Botao;

public class FormBuscaTransacao extends JPanel {
	private Transacao t;
	private int idTrans;

	public FormBuscaTransacao() {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JLabel id = new JLabel("Id:");
		id.setFont(new Font("Courier", Font.BOLD, 16));
		add(id);

		JTextField campoId = new JTextField();
		campoId.setPreferredSize(new Dimension(30, 30));
		add(campoId);

		JLabel nroConta = new JLabel("Nro Conta:");
		nroConta.setFont(new Font("Courier", Font.BOLD, 16));
		add(nroConta);

		JTextField campoNro = new JTextField();
		campoNro.setPreferredSize(new Dimension(120, 30));
		add(campoNro);

		JLabel nroAg = new JLabel("Nro Agência:");
		nroAg.setFont(new Font("Courier", Font.BOLD, 16));
		add(nroAg);

		JTextField campoNroAg = new JTextField();
		campoNroAg.setPreferredSize(new Dimension(120, 30));
		add(campoNroAg);

		Botao botao = new Botao("Buscar");
		botao.setPreferredSize(new Dimension(120, 30));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);
		botao.addActionListener(event -> {
			if (!(campoNro.getText().isEmpty() || campoNroAg.getText().isEmpty() || campoId.getText().isEmpty())) {
				this.idTrans = transformaNumero(campoId.getText());

				try {
					Conta c = MemoriaConta.getInstancia().buscaConta(campoNro.getText());
					Agencia a = MemoriaAgencia.getInstancia().buscaAgencias(campoNroAg.getText());

					if (verificaAgencia(a) && verificaConta(c)) {
						t = c.getTransacao().get(idTrans);
						new MostraTransacao(t);
					}

					else {
						throw new RuntimeException("Agencia ou conta não existe");
					}

				} catch (RuntimeException e) {
					new Alerta("Erro." + e.getMessage());
				}
			} else {
				new Alerta("Erro. Os campos são obrigatórios.");
			}
		});

	}

	private boolean verificaConta(Conta c) {
		if (c != null) {
			return true;
		} else {
			new Alerta("Erro. Conta inexistente");
			return false;
		}
	}

	private boolean verificaAgencia(Agencia a) {
		if (a != null) {
			return true;
		} else {
			new Alerta("Erro. Agência inexistente");
			return false;
		}
	}

	private int transformaNumero(String nro) {
		try {
			int numeroConvertido = Integer.parseInt(nro);
			return numeroConvertido;
		} catch (NumberFormatException e) {
			throw new RuntimeException("Erro ao converter de string para número. Verifique o campo preenchido!");
		}
	}
}
