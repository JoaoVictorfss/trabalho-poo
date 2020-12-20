package views.conta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Agencia;
import models.Conta;
import views.agencia.MemoriaAgencia;
import views.templates.Alerta;
import views.templates.Botao;

import java.util.Date;

public class FormAtualizaConta extends JPanel {
	private Conta conta;
	private int nroConta;
	private String agencia;
	private Date dataCria;
	private String status;
	private JFrame telaAnt;

	private boolean valido = true;

	public FormAtualizaConta(Conta c, JFrame telaAtualiza) {
		this.telaAnt = telaAtualiza;
		this.conta = c;

		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));
		JTextField campoNroConta = new JTextField(Integer.toString(c.getNroConta()));
		campoNroConta.setPreferredSize(new Dimension(150, 30));
		JLabel nroConta = adicionarLabel("N° Conta:");
		add(nroConta);
		add(campoNroConta);

		JTextField campoAgencia = new JTextField(Integer.toString(c.getAgencia().getNroAgencia()));
		campoAgencia.setPreferredSize(new Dimension(120, 30));
		JLabel agencia = adicionarLabel("N° Agência:");
		add(agencia);
		add(campoAgencia);

		JTextField campoStatus = new JTextField(c.getStatus());
		campoStatus.setPreferredSize(new Dimension(120, 30));
		JLabel status = adicionarLabel("Status:");
		add(status);
		add(campoStatus);

		JTextField campoCategoria = new JTextField(c.getTipo());
		JLabel categoria = adicionarLabel("Categoria:");
		campoCategoria.setPreferredSize(new Dimension(170, 30));
		add(categoria);
		add(campoCategoria);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		JTextField campoDataCria = new JTextField(formato.format(c.getDataAbertura()));
		campoDataCria.setPreferredSize(new Dimension(110, 30));
		JLabel dataCria = adicionarLabel("Data de Criação:");
		add(dataCria);
		add(campoDataCria);

		Botao botao = new Botao("Atualizar");
		botao.setPreferredSize(new Dimension(140, 40));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);

		botao.addActionListener(event -> {

			if (naoVazio(campoNroConta.getText()))
				this.nroConta = transformaNumero(campoNroConta.getText());
			if (naoVazio(campoAgencia.getText()))
				this.agencia = campoAgencia.getText();
			if (naoVazio(campoStatus.getText()))
				this.status = campoStatus.getText();
			if (naoVazio(campoDataCria.getText()))
				transformaData(campoDataCria.getText());

			if (this.valido) {
				atualizarConta();
			} else {
				new Alerta("Dados incorretos. Tente novamente!");
				this.telaAnt.dispose();
			}
		});
	}

	private JLabel adicionarLabel(String labelText) {
		JLabel label = new JLabel(labelText);

		label.setFont(new Font("Courier", Font.BOLD, 16));
		return label;
	}

	@SuppressWarnings("unused")
	private void atualizarConta() {
		try {
			Agencia ag = MemoriaAgencia.getInstancia().buscaAgencias(agencia);

			if (ag == null)
				throw new RuntimeException("Agencia não encontrada.");

			conta.setNroConta(this.nroConta);
			conta.setAgencia(ag);
			conta.setDataAbertura(this.dataCria);
			conta.setStatus(status);

			new Alerta("Sucesso. Dados Atualizados!");
		} catch (RuntimeException e) {
			new Alerta("Erro." + e.getMessage());
		}
	}

	// Verifica se o campo não está Vazio
	private boolean naoVazio(String campo) {
		if (!campo.isEmpty()) {
			this.valido = this.valido && true;

			return true;
		} else {
			this.valido = false;
			return false;
		}
	}

	// Converte string para data
	private void transformaData(String data) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		try {
			Date strToDate = format.parse(data);

			this.dataCria = strToDate;
			this.valido = this.valido && true;
		} catch (ParseException e) {
			this.valido = false;
			new Alerta("Erro ao converter de string para data. Verifique se o campo está no formato válido!");
		}
	}

	// Converte string para número
	private int transformaNumero(String nro) {
		try {
			int numeroConvertido = Integer.parseInt(nro);

			this.valido = this.valido && true;
			return numeroConvertido;
		} catch (NumberFormatException e) {
			this.valido = false;
			new Alerta("Erro ao converter de string para número. Verifique o campo preenchido!");
			return -1;
		}
	}

}
