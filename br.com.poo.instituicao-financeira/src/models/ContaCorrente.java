package models;

import java.util.Date;
import models.Agencia;

public class ContaCorrente extends Conta {
	private static final long serialVersionUID = 1L;
	private double limiteChequeEspecial;
	private double tarifaConta;
	private String categoria;
	// constructor
	public ContaCorrente() {
		super();
		this.limiteChequeEspecial = 0;
		this.tarifaConta = 0;
	}
	
	public ContaCorrente(String categoria, int nroConta, Agencia agencia, String status,
			double limiteChequeEspecial) {
		super(nroConta, agencia, "conta corrente",status, new Date());
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setCategoria(categoria);
	}

	public ContaCorrente(String categoria, int nroConta, Agencia agencia, Cliente cliente, String status,
			double limiteChequeEspecial) {
		super(nroConta, agencia, cliente, status, new Date());
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setCategoria(categoria);
	}

	public ContaCorrente(double limiteChequeEspecial, String categoria, Agencia agencia) {
		super(agencia);
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setCategoria(categoria);
	}

	// getters e setters
	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		if (limiteChequeEspecial > 0)
			this.limiteChequeEspecial = limiteChequeEspecial;
		else
			this.limiteChequeEspecial = 0;
	}

	public double getTarifaConta() {
		return tarifaConta;
	}

	public void setTarifaConta(double tarifaConta) {
		if (tarifaConta > 0)
			this.tarifaConta = tarifaConta;
		else
			this.tarifaConta = 0;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		if ("Standard".equalsIgnoreCase(categoria) || "Premium".equalsIgnoreCase(categoria)) {
			this.categoria = categoria;
		} else
			this.categoria = "NA";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		long temp;
		temp = Double.doubleToLongBits(limiteChequeEspecial);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(tarifaConta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ContaCorrente other = (ContaCorrente) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (Double.doubleToLongBits(limiteChequeEspecial) != Double.doubleToLongBits(other.limiteChequeEspecial))
			return false;
		if (Double.doubleToLongBits(tarifaConta) != Double.doubleToLongBits(other.tarifaConta))
			return false;
		return true;
	}

	// Cálculo de tarifa
	@Override
	public double calculaTarifa() {
		if ("Standard".equalsIgnoreCase(this.categoria)) {
			return this.tarifaConta = 12.00; // tarifa conta corrente standard
		} else if ("Premium".equalsIgnoreCase(this.categoria)) {
			return this.tarifaConta = 16.00; // tarifa conta corrente premium
		} else
			return 0;
	}

}
