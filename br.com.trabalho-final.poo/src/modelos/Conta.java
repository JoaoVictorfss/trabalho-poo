package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public abstract class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int nroConta;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private byte status;
	private Agencia agencia;
	private double saldoAtual;
	private Date dataAbertura;
	private int totalCliente;

	// constructor
	public Conta() {
		this(0, null, null, 'I', new Date());
	}

	public Conta(Agencia agencia) {
		this(0, agencia, null, 'I', new Date());
	}

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
	
	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public int getTotalCliente() {
		return this.totalCliente;
	}

	//Operações bancárias
	public boolean saque(double valor, Date data) {
		if (valor <= saldoAtual && valor > 0) {
			saldoAtual -= valor;
			Transacao transacao = new Transacao(data, "saque", valor, this.agencia);
			
			System.out.println("______________________________________");
			System.out.println("Extrato");
			System.out.println("Data da transação: " + transacao.getDataTransacao());
			System.out.println("Id: " + transacao.getId());
			System.out.println("Valor: " + transacao.getValorTransacao());
			System.out.println("Tipo: " + transacao.getTipoTransacao());
			System.out.println("Saldo Atual: " + this.saldoAtual);
			System.out.println("______________________________________");
			return true;
		} else
			throw new IllegalArgumentException("Valor inválido para saque!");
	}

	public boolean deposito(double valor, Date data) {
		if (valor > 0) {
			saldoAtual += valor;			
			Transacao transacao = new Transacao(data, "deposito", valor, this.agencia);
			
			System.out.println("______________________________________");
			System.out.println("Extrato");
			System.out.println("Data da transação: " + transacao.getDataTransacao());
			System.out.println("Id: " + transacao.getId());
			System.out.println("Valor: " + transacao.getValorTransacao());
			System.out.println("Tipo: " + transacao.getTipoTransacao());
			System.out.println("Saldo Atual: " + this.saldoAtual);
			System.out.println("______________________________________");
			return true;
		} else {
			throw new IllegalArgumentException("Valor do depósito não pode ser um valor negativo!");
		}
	}

	public boolean transferencia(double valor, Conta contaDestino, Date data) {
		if (valor <= saldoAtual && valor > 0) {
			saldoAtual -= valor;		
			Transacao transacao = new Transacao(data, "transferencia", valor, this.agencia);
			
			System.out.println("______________________________________");
			System.out.println("Extrato");
			System.out.println("Data da transação: " + transacao.getDataTransacao());
			System.out.println("Id: " + transacao.getId());
			System.out.println("Valor: " + transacao.getValorTransacao());
			System.out.println("Tipo: " + transacao.getTipoTransacao());
			System.out.println("Saldo Atual: " + this.saldoAtual);
			System.out.println("______________________________________");
			return true;
		} else
			throw new IllegalArgumentException("Valor inválido para transferência!");
	}

    //Métado abstrato para cálculo de tarifa
	public abstract double calculaTarifa();

}
