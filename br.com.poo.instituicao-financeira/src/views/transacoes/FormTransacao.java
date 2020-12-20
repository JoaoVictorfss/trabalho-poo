package views.transacoes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
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

public class FormTransacao extends JPanel {
	private String tipo;
	private String nroAgencia;
	private String nroConta;
	private double valor;
	private boolean valido = true;

	private JFrame telaAnt;

	public FormTransacao(String op, JFrame telaCadastro) {
		this.tipo = op;
		this.telaAnt = telaCadastro;
		
		setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

		JTextField campoNumero = new JTextField();
		JLabel numero = adicionarLabel("Número da Conta:");
		campoNumero.setPreferredSize(new Dimension(200, 30));
		add(numero);
		add(campoNumero);

		JTextField campoAgencia = new JTextField();
		JLabel agencia = adicionarLabel("Número da Agencia:");
		campoAgencia.setPreferredSize(new Dimension(200, 30));
		add(agencia);
		add(campoAgencia);

		JTextField campoValor = new JTextField();
		JLabel valor = adicionarLabel("Valor R$:");
		campoValor.setPreferredSize(new Dimension(300, 30));
		add(valor);
		add(campoValor);

		Botao botao = new Botao("Efetuar");
		botao.setPreferredSize(new Dimension(140, 40));
		botao.setBackground(new Color(183, 158, 20));

		add(botao);
		botao.addActionListener(event -> {
			if (naoVazio(campoAgencia.getText()))
				this.nroAgencia = campoAgencia.getText();
			if (naoVazio(campoNumero.getText()))
				this.nroConta = campoNumero.getText();
			if (naoVazio(campoValor.getText()))
				this.valor = transformaStrDouble(campoValor.getText());

			if (this.valido) {
				efetuar();
			} else {
				new Alerta("Dados incorretos. Tente novamente!");
				this.telaAnt.dispose();
			}
		});
	}

	private void efetuar() {
		try {
			  Conta conta =  MemoriaConta.getInstancia().buscaConta(this.nroConta);
		      Agencia agencia =  MemoriaAgencia.getInstancia().buscaAgencias(nroAgencia);
              
		      if(agencia == null || conta == null) {
  				new Alerta("Erro. Dados incorretos! Agência ou conta não existe!");
              }
		      
		      else {
		    	  Transacao transacao = new Transacao(new Date(), conta, agencia, valor);
		    	  if(this.tipo.equalsIgnoreCase("deposito")){
		    		  transacao.depositar(valor);
		    	  }else{
		    		  transacao.sacar(valor);
		    	  }
		      }
		      new Alerta("Sucesso. Transação efetuada");
		} catch (RuntimeException e) {
			new Alerta("Erro." + e.getMessage());
		}
     

	}

	// converte para double
	private double transformaStrDouble(String n) {
		try {
			double numeroConvertido = Double.parseDouble(n);

			this.valido = this.valido && true;
			return numeroConvertido;
		} catch (NumberFormatException e) {
			this.valido = false;
			new Alerta("Erro ao converter de string para Double. Verifique o campo preenchido!");
			return -1;
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

}
