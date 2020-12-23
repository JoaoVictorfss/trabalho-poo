package models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
	private String tipo;

	public Conta() {
	}

	public Conta(Agencia agencia) {
		this.setAgencia(agencia);
	}

	// constructor
	public Conta(int nroConta, Agencia agencia, Cliente cliente, String status, Date dataAbertura) {
		this.setNroConta(nroConta);
		this.setCliente(cliente);
		this.setStatus(status);
		this.setAgencia(agencia);
		this.setDataAbertura(dataAbertura);
	}
	
	public Conta(int nroConta, Agencia agencia, String tipo, String status, Date dataAbertura) {
		this.setNroConta(nroConta);
		this.setStatus(status);
		this.setAgencia(agencia);
		this.setDataAbertura(dataAbertura);
		this.setTipo(tipo);
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

	public void setStatus(String status) {
		if (status.equalsIgnoreCase("A"))
			this.status = 1;
		else if (status.equalsIgnoreCase("I"))
			this.status = 3;
		else
			this.status = 2;
	}

	public boolean saque(double valor) {
		if (valor <= saldoAtual && valor > 0) {
			saldoAtual -= valor;
			return true;
		} else
			throw new RuntimeException("Valor inválido para saque!");
	}

	public boolean deposito(double valor) {
		if (valor > 0) {
			saldoAtual += valor;
			return true;
		} else {
			throw new RuntimeException("Valor do depósito não pode ser um valor negativo!");
		}
	}

	public boolean transferencia(double valor, Conta contaDestino) {
		if (valor <= saldoAtual && valor > 0) {
			if(contaDestino.getNroConta() == this.getNroConta()) {
				throw new RuntimeException("Impossível fazer transferência para a mesma conta");
			}
			saldoAtual -= valor;
			contaDestino.deposito(valor);
			return true;
		} else
			throw new RuntimeException("Valor inválido para transferência!");
	}

	public void printTransacoes(){
		transacoes.forEach((n) -> System.out.println(n.mostrarExtrato()));
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	public void adicionaTransacao(Transacao t) {
		this.transacoes.add(t);
	}

	public void setNroAgencia(int agencia) {
		this.agencia.setNroAgencia(agencia);
	}

	public int getTotalCliente() {
		return this.totalCliente;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public  ArrayList<Transacao> getTransacao() {
		return this.transacoes;
	}

	public abstract double calculaTarifa();
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + nroConta;
		long temp;
		temp = Double.doubleToLongBits(saldoAtual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + status;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + totalCliente;
		result = prime * result + ((transacoes == null) ? 0 : transacoes.hashCode());
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
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (nroConta != other.nroConta)
			return false;
		if (Double.doubleToLongBits(saldoAtual) != Double.doubleToLongBits(other.saldoAtual))
			return false;
		if (status != other.status)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (totalCliente != other.totalCliente)
			return false;
		if (transacoes == null) {
			if (other.transacoes != null)
				return false;
		} else if (!transacoes.equals(other.transacoes))
			return false;
		return true;
	}

	public String mostrarDados() {
		final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		final String data = formato.format(this.getDataAbertura());
		
		return "Número: " + this.nroConta
		+ "\nStatus: " + this.getStatus()
		+ "\nNúmero da Agência: " + this.getAgencia().getNroAgencia()
		+ "\nData de abertura: " + data
		+ "\nTipo: " + this.getTipo()
		+"\nSaldo Atual: " + this.getSaldoAtual();

	}

}
