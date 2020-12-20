package views.transacoes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import views.templates.Botao;
import views.templates.Painel;

public class TelaPrincipalTransacao extends JFrame {
	public TelaPrincipalTransacao() {
		organizarLayout();

		setTitle("Operações bancárias");

		setSize(500, 550);

		setLocationRelativeTo(null);

		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new BorderLayout());
		Painel painel = new Painel("Transações");
		add(painel, BorderLayout.NORTH);

		JPanel menu = new JPanel();
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

		Botao saque = adicionarBotao("Saque");
		saque.addActionListener(e -> {
			new TelaEfetuarTransacao("Saque");
		});

		menu.add(saque);

		Botao trans = adicionarBotao("Transferência");
		trans.addActionListener(e -> {
			new TelaEfetuarTransacao("Transferencia");
		});
		menu.add(trans);

		Botao dep = adicionarBotao("Depósito");
		dep.addActionListener(e -> {
			new TelaEfetuarTransacao("Deposito");
		});
		menu.add(dep);
		add(menu);

		Botao cons = adicionarBotao("Consultar");
		cons.addActionListener(e -> {
			new TelaConsultaTransacao();
		});
		menu.add(cons);
		add(menu);
	}

	private Botao adicionarBotao(String texto) {
		Botao botao = new Botao(texto);
		botao.setPreferredSize(new Dimension(400, 50));
		return botao;
	}

}
