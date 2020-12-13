package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

abstract class Conta implements Serializable{
	private int nroConta;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private byte status;
	private Agencia agencia;
	private Date dataAbertura;
	private double saldoAtual;
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
		if(clienteCriado) this.totalCliente ++;
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

	// transações
	public boolean saque(double valor, Date dataTrans, Agencia agencia, int idTrans) {
		if (valor <= this.saldoAtual && valor > 0) {
			this.saldoAtual -= valor;
			return true;
		} else
			return false;// -1 como valor de erro
	}

	public boolean deposito(double valor, Date dataTrans, Agencia agencia, int idTrans) {
		if (valor > 0) {
			this.saldoAtual += valor;
			return true;
		} else
			return false;
	}

	public boolean transferencia(double valor, Date dataTrans, Agencia agencia, int idTrans) {
		if (valor <= this.saldoAtual && valor > 0) {
			this.saldoAtual -= valor;
			return true;
		} else
			return false;
	}
	
	public int getTotalCliente() {
		return this.totalCliente;
	}

	public abstract double calculaTarifa();

}
