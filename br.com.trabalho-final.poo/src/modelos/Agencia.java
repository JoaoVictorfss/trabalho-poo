package modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Agencia implements Serializable{
	private int nroAgencia;
	private String nome;
	private Endereco endereco;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private Gerente gerente;

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

	public Agencia(int nroAgencia, Endereco endereco, Gerente gerente) {
		this.setNroAgencia(nroAgencia);
		this.setEndereco(endereco);
		this.setGerente(gerente);
	}

	// getters and setters
	public int getNroAgencia() {
		return nroAgencia;
	}

	public void setNroAgencia(int nroAgencia) {
		if (nroAgencia >= 0)
			this.nroAgencia = nroAgencia;
		else
			nroAgencia = 0;
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

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
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

}
