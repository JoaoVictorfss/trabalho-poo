package views.conta;

import javax.swing.*;

import views.templates.Botao;

import java.awt.*;

import models.*;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class FormContaCorrente extends JPanel {

    private String categoria;
	private int nroConta;
    private int agencia;
    private Date dataCria;
    private String status;
    
    private boolean valido = true;

    public FormContaCorrente() {
		setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        JTextField campoNroConta = new JTextField("12");
        campoNroConta.setPreferredSize(new Dimension(150, 30));
        JLabel nroConta = adicionarLabel("N° Conta:");
        add(nroConta);
        add(campoNroConta);

        JTextField campoAgencia = new JTextField("0800");
        campoAgencia.setPreferredSize(new Dimension(120, 30));
        JLabel agencia = adicionarLabel("N° Agência:");
        add(agencia);
        add(campoAgencia);

        /*JTextField campoCliente = new JTextField("60792520076");
        campoCliente.setPreferredSize(new Dimension(150, 30));
        JLabel cliente = adicionarLabel("CPF Cliente:");
        add(cliente);
        add(campoCliente);*/

        JTextField campoStatus = new JTextField("A");
        campoStatus.setPreferredSize(new Dimension(120, 30));
        JLabel status = adicionarLabel("Status:");
        add(status);
        add(campoStatus);

        JTextField campoCategoria = new JTextField("Standard");
        JLabel categoria = adicionarLabel("Categoria:");
        campoCategoria.setPreferredSize(new Dimension(170, 30));
        add(categoria);
        add(campoCategoria);

        JTextField campoDataCria = new JTextField("2020/12/20");
		campoDataCria.setPreferredSize(new Dimension(110, 30));
		JLabel dataCria = adicionarLabel("Data de Criação:");
		add(dataCria);
		add(campoDataCria);

        Botao botao = new Botao("Cadastrar");
        botao.setPreferredSize(new Dimension(140, 40));
        botao.setBackground(new Color(183, 158, 20));

        add(botao);

        botao.addActionListener(event -> {

			if (naoVazio(campoCategoria.getText()))
				this.categoria = campoCategoria.getText();
			if (naoVazio(campoNroConta.getText()))
				this.nroConta = transformaNumero(campoNroConta.getText());
			if (naoVazio(campoAgencia.getText()))
				this.agencia =  transformaNumero(campoAgencia.getText());
			if (naoVazio(campoStatus.getText()))
				this.status = campoStatus.getText();
            if (naoVazio(campoDataCria.getText()))
				transformaData(campoDataCria.getText());
            
            if (this.valido) {
				cadastraConta();
			}
		});
    }

    @SuppressWarnings("unused")
	private void cadastraConta() {
		try {
            ContaCorrente conta = null;

			conta = new ContaCorrente(nroConta, agencia, status, dataCria, categoria);

			if (conta == null) {
				this.mostrarAlerta("Erro. Dados incorretos! Verique todos e tente novamente");
			} else {
				MemoriaConta.getInstancia().adicionarConta(conta);
				this.mostrarAlerta("Sucesso. Dados cadastrados!");
			}
		} catch (RuntimeException e) {
			this.mostrarAlerta("Erro." + e.getMessage());
		}
    }
    
    private JLabel adicionarLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Courier", Font.BOLD, 16));
        return label;
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

			this.dataCria = strToDate;
			this.valido = this.valido && true;
		} catch (ParseException e) {
			this.valido = false;
			this.mostrarAlerta("Erro ao converter de string para data. Verifique se o campo está no formato válido!");
		}
    }

    private int transformaNumero(String nro) {
		try {
			int numeroConvertido = Integer.parseInt(nro);

			this.valido = this.valido && true;
			return numeroConvertido;
		} catch (NumberFormatException e) {
			this.valido = false;
			this.mostrarAlerta("Erro ao converter de string para número. Verifique o campo preenchido!");
			return -1;
		}
    }
    private void mostrarAlerta(String mensagem) {
		SwingUtilities.invokeLater(() -> {
			JOptionPane.showMessageDialog(this, mensagem);
		});
	}
}