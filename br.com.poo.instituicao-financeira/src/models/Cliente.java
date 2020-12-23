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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((contas == null) ? 0 : contas.hashCode());
		result = prime * result + ((escolaridade == null) ? 0 : escolaridade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		if (escolaridade == null) {
			if (other.escolaridade != null)
				return false;
		} else if (!escolaridade.equals(other.escolaridade))
			return false;
		return true;
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
