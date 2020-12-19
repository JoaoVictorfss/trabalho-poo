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

	public ContaSalario(int nroConta, Agencia agencia, Cliente cliente, char status, double salMinimo) {
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

}
