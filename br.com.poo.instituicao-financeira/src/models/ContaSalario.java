package models;

import java.util.Date;

public class ContaSalario extends Conta {
	private static final long serialVersionUID = 1L;
	private double salMinimo;
	private double tarifaConta;

	//Constructor
	public ContaSalario() {
		super();
		this.salMinimo = 0;
	}

	public ContaSalario(Agencia agencia, double salMinimo) {
		super(agencia);
		this.setSalMinimo(salMinimo);
		setTarifaConta(salMinimo);
	}
	
	public ContaSalario(int nroConta, Agencia agencia, String status, double salMinimo, double tarifa) {
		super(nroConta, agencia, "conta salário", status, new Date());
		this.setSalMinimo(salMinimo);
		this.setTarifaConta(tarifa);
	}


	public ContaSalario(int nroConta, Agencia agencia, Cliente cliente, String status, double salMinimo) {
		super(nroConta, agencia, cliente, status, new Date());
		this.setSalMinimo(salMinimo);
	}

	//getters e setters
	public double getSalMinimo() {
		return salMinimo;
	}

	public void setSalMinimo(double salMinimo) {
		if (salMinimo > 0)
			this.salMinimo = salMinimo;
		else
			throw new RuntimeException("Salário mínimo informado é inválido");
	}
	
	//Cálculo de tarifa
	@Override
	public double calculaTarifa() {
		return 0;
	}

	public double getTarifaConta() {
		return tarifaConta;
	}

	public void setTarifaConta(double salario) {
		this.tarifaConta = salario/1000;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(salMinimo);
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
		ContaSalario other = (ContaSalario) obj;
		if (Double.doubleToLongBits(salMinimo) != Double.doubleToLongBits(other.salMinimo))
			return false;
		if (Double.doubleToLongBits(tarifaConta) != Double.doubleToLongBits(other.tarifaConta))
			return false;
		return true;
	}
	
	

}
