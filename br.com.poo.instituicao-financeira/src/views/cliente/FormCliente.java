package views.cliente;

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

import models.Cliente;
import models.Endereco;
import views.templates.Alerta;
import views.templates.Botao;

import java.util.Date;

public class FormCliente extends JPanel {
	private String nomeCliente;
	private String cpfCliente;
	private Date dataNasc;
	private String endPais;
	private String endUf;
	private String endCep;
	private String endCidade;
	private String endRua;
	private int endNumero;
	private String escolaridade;
	private String estadoCiv;

	private JFrame telaAnt;
	private boolean valido = true;

	public FormCliente(JFrame telaCadastro) {
		this.telaAnt = telaCadastro;

		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JTextField campoNome = new JTextField("joao");
		JLabel nome = adicionarLabel("Nome:");
		campoNome.setPreferredSize(new Dimension(170, 30));
		add(nome);
		add(campoNome);

		JTextField campoCpf = new JTextField("60792520076");
		campoCpf.setPreferredSize(new Dimension(150, 30));
		JLabel cpf = adicionarLabel("CPF:");
		add(cpf);
		add(campoCpf);

		JTextField campoDataNasc = new JTextField("1999/06/23");
		campoDataNasc.setPreferredSize(new Dimension(110, 30));
		JLabel dataNasc = adicionarLabel("Nascimento:");
		add(dataNasc);
		add(campoDataNasc);

		JTextField campoPais = new JTextField("Brasil");
		campoPais.setPreferredSize(new Dimension(140, 30));
		JLabel pais = adicionarLabel("País:");
		add(pais);
		add(campoPais);

		JTextField campoUf = new JTextField("MG");
		campoUf.setPreferredSize(new Dimension(150, 30));
		JLabel uf = adicionarLabel("Estado:");
		add(uf);
		add(campoUf);

		JTextField campoCep = new JTextField("111111-000");
		campoCep.setPreferredSize(new Dimension(150, 30));
		JLabel cep = adicionarLabel("CEP:");
		add(cep);
		add(campoCep);

		JTextField campoCidade = new JTextField("Uberlândia");
		campoCidade.setPreferredSize(new Dimension(150, 30));
		JLabel cidade = adicionarLabel("Cidade:");
		add(cidade);
		add(campoCidade);

		JTextField campoRua = new JTextField("Av Afonso Pena");
		campoRua.setPreferredSize(new Dimension(150, 30));
		JLabel rua = adicionarLabel("Rua:");
		add(rua);
		add(campoRua);

		JTextField campoNumero = new JTextField("10");
		campoNumero.setPreferredSize(new Dimension(150, 30));
		JLabel numero = adicionarLabel("Número:");
		add(numero);
		add(campoNumero);

		JTextField campoEscolaridade = new JTextField("cursando");
		campoEscolaridade.setPreferredSize(new Dimension(90, 30));
		JLabel escolaridade = adicionarLabel("Escolaridade:");
		add(escolaridade);
		add(campoEscolaridade);

		JTextField campoEstadoCiv = new JTextField("solteiro");
		campoEstadoCiv.setPreferredSize(new Dimension(60, 30));
		JLabel civil = adicionarLabel("Estado Civil:");
		add(civil);
		add(campoEstadoCiv);

		Botao botao = new Botao("Cadastrar");
		botao.setPreferredSize(new Dimension(140, 40));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);

		// Escuta o evento de click do botão cadastrar
		botao.addActionListener(event -> {

			if (naoVazio(campoNome.getText()))
				this.nomeCliente = campoNome.getText();
			if (naoVazio(campoCpf.getText()))
				this.cpfCliente = campoCpf.getText();
			if (naoVazio(campoDataNasc.getText()))
				transformaData(campoDataNasc.getText());
			if (naoVazio(campoPais.getText()))
				this.endPais = campoPais.getText();
			if (naoVazio(campoUf.getText()))
				this.endUf = campoUf.getText();
			if (naoVazio(campoCep.getText()))
				this.endCep = campoCep.getText();
			if (naoVazio(campoCidade.getText()))
				this.endCidade = campoCidade.getText();
			if (naoVazio(campoRua.getText()))
				this.endRua = campoRua.getText();
			if (naoVazio(campoNumero.getText()))
				this.endNumero = transformaNumero(campoNumero.getText());
			if (naoVazio(campoEscolaridade.getText()))
				this.escolaridade = campoEscolaridade.getText();
			if (naoVazio(campoEstadoCiv.getText()))
				this.estadoCiv = campoEstadoCiv.getText();

			if (this.valido) {
				cadastraCliente();
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
	private void cadastraCliente() {
		try {
			Endereco enderecoCliente = new Endereco(endRua, endNumero, endCep, endUf, endCidade, endPais);
			Cliente cliente = null;

			cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente, estadoCiv, escolaridade, dataNasc);

			if (cliente == null) {
				new Alerta("Erro. Dados incorretos! Verique todos e tente novamente");
			} else {
				MemoriaCliente.getInstancia().adicionarCliente(cliente);
				new Alerta("Sucesso. Dados cadastrados!");
			}
		} catch (RuntimeException e) {
			new Alerta("Erro." + e.getMessage());
		}
	}

	// Verifica se o campo está naoVazio
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

			this.dataNasc = strToDate;
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
