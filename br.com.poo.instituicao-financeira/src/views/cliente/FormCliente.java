package views.cliente;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormCliente extends JPanel {

	public FormCliente() {
		setBackground(Color.GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));// 20 como valor na vertical e 40 na horizontal

		JTextField campoNome = new JTextField();
		campoNome.setSize(300, 20);
		JLabel nome = new JLabel("Nome:");
        add(nome);
        add(campoNome);

		JTextField campoCpf = new JTextField();
		JLabel cpf = new JLabel("CPF:");
        add(campoCpf);
        add(cpf);
        
		JTextField campoEstadoCivil = new JTextField();
		JLabel estadoCivil = new JLabel("Estado Civil:");
        add(campoEstadoCivil);
        add(estadoCivil);
        
		JTextField campoDataNasc = new JTextField();
		JLabel dataNasc = new JLabel("Nacimento: dd/mm/aa: ");
        add(campoDataNasc);
        add(dataNasc);
		
        /*JTextField campoPaisnew = new JTextField();
		
		JTextField campoUf = new JTextField();
		JTextField campoCep = new JTextField();
		JTextField campoCidade = new JTextField();
		JTextField campoRua = new JTextField();
		JTextField campoNumero = new JTextField();
		JTextField NroConta = new JTextField();

		JLabel pais = new JLabel("Pais:");
		JLabel uf = new JLabel("Estado:");
		JLabel cep = new JLabel("CEP:");
		JLabel cidade = new JLabel("Cidade:");
		JLabel rua = new JLabel("Rua:");
		JLabel numero = new JLabel("Número:");
		JLabel conta = new JLabel("Número da conta:");*/
	}

}
