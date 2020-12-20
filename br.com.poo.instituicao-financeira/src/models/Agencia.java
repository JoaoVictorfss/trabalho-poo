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
	
	public void mostrarDados() {
		System.out.println("______________________________________");
		System.out.println("\nDados da Agência\n");
		System.out.println("Nome: " + this.nome);
		System.out.println("Número: " + this.nroAgencia);
		System.out.println("Nome do gerente: " + this.gerente.getNome());
		System.out.print("Endereço: ");
		System.out.print(this.endereco.getCep() + ", ");
		System.out.print("rua: " + this.endereco.getRua() + ", ");
		System.out.print("número: " + this.endereco.getNumero() + " - ");
		System.out.print(this.endereco.getUf() + ", ");
		System.out.println(this.endereco.getCidade() + ".");
		if (!clientes.isEmpty()) {
			System.out.println("\nClientes: ");
			clientes.forEach(c -> System.out.println(c.getNome()));
		}
		System.out.println("______________________________________");

	}

}
