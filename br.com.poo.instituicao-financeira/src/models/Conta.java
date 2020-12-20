package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int nroConta;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
	private byte status;
	private Agencia agencia;
	private double saldoAtual;
	private Date dataAbertura;
	private int totalCliente;

	public Conta() {
		this(0, null, null, 'I', new Date());
	}

	public Conta(Agencia agencia) {
		this(0, agencia, null, 'I', new Date());
	}

	// constructor
	public Conta(int nroConta, Agencia agencia, Cliente cliente, char status, Date dataAbertura) {
		this.setNroConta(nroConta);
		this.setCliente(cliente);
		this.setStatus(status);
		this.setAgencia(agencia);
		this.setDataAbertura(dataAbertura);
	}

	// getters e setters
	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	// getters and setters
	public int getNroConta() {
		return nroConta;
	}

	public void setNroConta(int nroConta) {
		if (nroConta >= 0)
			this.nroConta = nroConta;
		else
			this.nroConta = 0;
	}

	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> clientesClone = new ArrayList<Cliente>();
		clientesClone.addAll(this.clientes);
		return clientesClone;
	}

	public boolean setCliente(Cliente cliente) {
		final boolean clienteCriado = this.clientes.add(cliente);
		if (clienteCriado)
			this.totalCliente++;
		return clienteCriado;
	}

	public String getStatus() {
		if (this.status == 1)
			return "Ativa";
		else if (this.status == 2)
			return "Inativa";
		else
			return "Analise";
	}

	public void setStatus(char status) {
		if (status == 'A')
			this.status = 1;
		else if (status == 'N')
			this.status = 3;
		else
			this.status = 2;
	}

	public boolean saque(double valor) {
		if (valor <= saldoAtual && valor > 0) {
			saldoAtual -= valor;
			transacoes.add(new Transacao(new Date(), "saque", valor, this.agencia));
			return true;
		} else
			throw new RuntimeException("Valor inválido para saque!");
	}

	public boolean deposito(double valor) {
		if (valor > 0) {
			saldoAtual += valor;
			transacoes.add(new Transacao(new Date(), "deposito", valor, this.agencia));
			return true;
		} else {
			throw new RuntimeException("Valor do depósito não pode ser um valor negativo!");
		}
	}

	public boolean transferencia(double valor, Conta contaDestino) {
		if (valor <= saldoAtual && valor > 0) {
			saldoAtual -= valor;
			transacoes.add(new Transacao(new Date(), "transferencia", valor, this.agencia, contaDestino));
			return true;
		} else
			throw new RuntimeException("Valor inválido para transferência!");
	}

	public void printTransacoes(){
		transacoes.forEach((n) -> System.out.println(n.toString()));
		System.out.println("Saldo Atual : " + getSaldoAtual());
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public int getTotalCliente() {
		return this.totalCliente;
	}

	public abstract double calculaTarifa();
	
	public void mostrarDados() {
		System.out.println("______________________________________");
		System.out.println("\nDados do Conta\n");
		System.out.println("Número: " + this.nroConta);
		System.out.println("Status: " + this.getStatus());
		System.out.println("Número da Agencia: " + this.getAgencia().getNroAgencia());
		System.out.println("Quantidade de clientes: " + this.getTotalCliente());
		System.out.println("Data de abertura: " + this.getDataAbertura());
		System.out.println("______________________________________");
	}

}
