package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;
	private String escolaridade;
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private Agencia agencia;

	// constructor
	public Cliente(Agencia agencia) {
		super();
		this.setAgencia(agencia);
		this.escolaridade = "";
	}

	public Cliente(String nome, String cpf, Endereco endereco, String estadoCivil, String escolaridade,
			Date dataNasc) {
		super(nome, cpf, endereco, estadoCivil, dataNasc);
		this.setEscolaridade(escolaridade);
		this.setAgencia(agencia);
	}
	
	public Cliente(String nome, Agencia agencia, String cpf, Endereco endereco, String estadoCivil, String escolaridade,
			Date dataNasc, Conta conta) {
		super(nome, cpf, endereco, estadoCivil, dataNasc);
		this.setEscolaridade(escolaridade);
		this.setAgencia(agencia);
		this.setConta(conta);
	}

	public Cliente(String nome, Agencia agencia, String cpf, Endereco endereco, String estadoCivil, String escolaridade,
			Date dataNasc) {
		super(nome, cpf, endereco, estadoCivil, dataNasc);
		this.setEscolaridade(escolaridade);
		this.setAgencia(agencia);
	}

	//getters e setters
	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public ArrayList<Conta> getContas() {
		ArrayList<Conta> contasClone = new ArrayList<Conta>();
		contasClone.addAll(this.contas);
		return contasClone;
	}

	public void setConta(Conta conta) {
		this.contas.add(conta);
	}

	public Agencia getAgencia() {
		return this.agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	public String mostrarDados() {

		final String endereco = this.getEndereco().getCidade() + ", " + this.getEndereco().getRua() + ", "
				+ this.getEndereco().getNumero() + " - " + this.getEndereco().getUf() + ", " + this.getEndereco().getCep() + "("
				+ this.getEndereco().getPais() + ").\n";
		
		final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		final String dataNasc = formato.format(this.getDataNasc());

		return "Nome:" + this.getNome() + ".\n" + "CPF: " + this.getCpf() + ".\n" + "Quantidade de conta(s):  "
				+ this.getContas().size() + ".\n" + "Endereço: " + endereco + "Estado Civil: " + this.getEstadoCivil() + ".\n"
				+ "Data de Nascimento: " +dataNasc + ".\n" + "Escolaridade: " + this.getEscolaridade() + ".\n";
	}
}
