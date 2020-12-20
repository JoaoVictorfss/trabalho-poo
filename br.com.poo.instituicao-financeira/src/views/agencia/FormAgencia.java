package views.agencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import models.*;
import views.funcionario.MemoriaFuncionario;
import views.templates.Alerta;
import views.templates.Botao;

public class FormAgencia extends JPanel {
	private int nroAgencia;
	private String nome;
	private String endPais;
	private String endUf;
	private String endCep;
	private String endCidade;
	private String endRua;
	private int endNumero;
	private String cpfGerente;
	private JFrame telaAnt;

	private boolean valido = true;

	public FormAgencia(JFrame telaAtualiza) {
		this.telaAnt = telaAtualiza;

		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JTextField campoNroAgencia = new JTextField("0800");
		campoNroAgencia.setPreferredSize(new Dimension(150, 30));
		JLabel nroConta = adicionarLabel("N° Agência:");
		add(nroConta);
		add(campoNroAgencia);

		JTextField campoNome = new JTextField("Bradesco");
		campoNome.setPreferredSize(new Dimension(120, 30));
		JLabel nome = adicionarLabel("Nome:");
		add(nome);
		add(campoNome);

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

		JTextField campoCep = new JTextField("38770-000");
		campoCep.setPreferredSize(new Dimension(150, 30));
		JLabel cep = adicionarLabel("CEP:");
		add(cep);
		add(campoCep);

		JTextField campoCidade = new JTextField("Uberlândia");
		campoCidade.setPreferredSize(new Dimension(150, 30));
		JLabel cidade = adicionarLabel("Cidade:");
		add(cidade);
		add(campoCidade);

		JTextField campoRua = new JTextField("Rondon Pacheco");
		campoRua.setPreferredSize(new Dimension(150, 30));
		JLabel rua = adicionarLabel("Rua:");
		add(rua);
		add(campoRua);

		JTextField campoNumero = new JTextField("1220");
		campoNumero.setPreferredSize(new Dimension(150, 30));
		JLabel numero = adicionarLabel("Número:");
		add(numero);
		add(campoNumero);

		JTextField campoGerente = new JTextField("52094901653");
		campoGerente.setPreferredSize(new Dimension(150, 30));
		JLabel gerente = adicionarLabel("CPF Gerente:");
		add(gerente);
		add(campoGerente);

		Botao botao = new Botao("Cadastrar");
		botao.setPreferredSize(new Dimension(140, 40));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);

		botao.addActionListener(event -> {

			if (naoVazio(campoNroAgencia.getText()))
				this.nroAgencia = transformaNumero(campoNroAgencia.getText());
			if (naoVazio(campoNome.getText()))
				this.nome = campoNome.getText();
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
			if (naoVazio(campoGerente.getText()))
				this.cpfGerente = campoGerente.getText();

			if (this.valido) {
				cadastraAgencia();
			} else {
				new Alerta("Dados incorretos. Tente novamente!");
				this.telaAnt.dispose();
			}
		});
	}

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

	@SuppressWarnings("unused")
	private void cadastraAgencia() {
		try {
			Endereco enderecoAgencia = new Endereco(endRua, endNumero, endCep, endUf, endCidade, endPais);
			Agencia agencia = null;
			Funcionario gerente = MemoriaFuncionario.getInstancia().buscaFuncionario(cpfGerente);
			if (gerente == null) {
				throw new RuntimeException("Gerente inexistente!");
			}

			agencia = new Agencia(nome, nroAgencia, enderecoAgencia, gerente);

			if (agencia == null) {
				new Alerta("Erro. Dados incorretos! Verique todos e tente novamente");
			} else {
				MemoriaAgencia.getInstancia().adicionarAgencia(agencia);
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

	private JLabel adicionarLabel(String labelText) {
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Courier", Font.BOLD, 16));
		return label;
	}
}
