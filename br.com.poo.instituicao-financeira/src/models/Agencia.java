package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Agencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private int nroAgencia;
	private String nome;
	private Endereco endereco;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private Funcionario gerente;

	// constructor
	public Agencia(int nroAgencia, String nome, Endereco endereco, ArrayList<Cliente> clientes, Gerente gerente,
			ArrayList<Conta> contas) {
		this.setNroAgencia(nroAgencia);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setGerente(gerente);
		clientes.forEach(item -> this.clientes.add(item));
		contas.forEach(item -> this.contas.add(item));
	}
	
	public Agencia(String nome, int nroAgencia, Endereco endereco, Funcionario gerente) {
		this.setNome(nome);
		this.setNroAgencia(nroAgencia);
		this.setEndereco(endereco);
		this.setGerente(gerente);
	}

	public Agencia(int nroAgencia, Endereco endereco, Gerente gerente) {
		this.setNroAgencia(nroAgencia);
		this.setEndereco(endereco);
		this.setGerente(gerente);
	}

	// getters e setters
	public int getNroAgencia() {
		return nroAgencia;
	}

	public void setNroAgencia(int nroAgencia) {
		if (nroAgencia >= 0)
			this.nroAgencia = nroAgencia;
		else
			throw new RuntimeException("Número de agência inválido!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario getGerente() {
		return gerente;
	}

	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setConta(Conta conta) {
		this.contas.add(conta);
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result + ((contas == null) ? 0 : contas.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((gerente == null) ? 0 : gerente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + nroAgencia;
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
		Agencia other = (Agencia) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (gerente == null) {
			if (other.gerente != null)
				return false;
		} else if (!gerente.equals(other.gerente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nroAgencia != other.nroAgencia)
			return false;
		return true;
	}

	public String mostrarDados() {
		final String endereco = this.getEndereco().getCidade() + ", " + this.getEndereco().getRua() + ", "
				+ this.getEndereco().getNumero() + " - " + this.getEndereco().getUf() + ", " + this.getEndereco().getCep() + "("
				+ this.getEndereco().getPais() + ").\n";


		return "Nome:" + this.getNome()
				+ ".\n" + "N° Agencia: " + this.getNroAgencia()
				+ ".\n" + "Quantidade de conta(s):  " + this.getContas().size()
				+ ".\n" + "Endereço: " + endereco
				+ "Nome Gerente: " + this.gerente.getNome() + ".\n";
	}

}
