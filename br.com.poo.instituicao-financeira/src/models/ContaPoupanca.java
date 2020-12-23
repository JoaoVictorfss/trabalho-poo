package models;

import java.util.Date;

public class ContaPoupanca extends Conta {
	private static final long serialVersionUID = 1L;
	private double rendimento;
	private double tarifaConta;
	// constructor
	public ContaPoupanca() {
		super();
		this.rendimento = 0;
		this.tarifaConta = 0;
	}

	public ContaPoupanca(double rendimento, int nroConta, Agencia agencia, String status, double tarifaConta) {
		super(nroConta, agencia, "conta poupança", status, new Date());
		this.setRendimento(rendimento);
		this.setTarifaConta(tarifaConta);
	}
	
	public ContaPoupanca(double rendimento, int nroConta, Agencia agencia, Cliente cliente, String status, double tarifaConta) {
		super(nroConta, agencia, cliente, status, new Date());
		this.setRendimento(rendimento);
		this.setTarifaConta(tarifaConta);
	}

	public ContaPoupanca(Agencia agencia, double rendimento, double tarifaConta) {
		super(agencia);
		this.setRendimento(rendimento);
		this.setTarifaConta(tarifaConta);
	}

	// getters e setters
	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		if (rendimento >= 0)
			this.rendimento = rendimento;
		else
			throw new RuntimeException("Rendimento informado é invalido");
	}

	public double getTarifaConta() {
		return tarifaConta;
	}

	public void setTarifaConta(double tarifaConta) {
		if (tarifaConta > 0) {
			this.tarifaConta = tarifaConta;
		}
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(rendimento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tarifaConta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaPoupanca other = (ContaPoupanca) obj;
		if (Double.doubleToLongBits(rendimento) != Double.doubleToLongBits(other.rendimento))
			return false;
		if (Double.doubleToLongBits(tarifaConta) != Double.doubleToLongBits(other.tarifaConta))
			return false;
		return true;
	}

	// Calculo de tarifa
	@Override
	public double calculaTarifa() {
		return this.tarifaConta;
	}

}
