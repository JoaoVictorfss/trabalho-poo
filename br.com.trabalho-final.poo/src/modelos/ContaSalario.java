package modelos;

import java.util.Date;

public class ContaSalario extends Conta {
	private static final long serialVersionUID = 1L;
	private double salMinimo;

	public ContaSalario() {
		super();
		this.salMinimo = 0;
	}

	@Override
	public double calculaTarifa() {
		return 0;
	}

	public ContaSalario(Agencia agencia, double salMinimo) {
		super(agencia);
		this.setSalMinimo(salMinimo);
	}

	public ContaSalario(int nroConta, Agencia agencia, Cliente cliente, char status, double salMinimo) {
		super(nroConta, agencia, cliente, status, new Date());
		this.setSalMinimo(salMinimo);
	}

	public double getSalMinimo() {
		return salMinimo;
	}

	public void setSalMinimo(double salMinimo) {
		if (salMinimo > 0)
			this.salMinimo = salMinimo;
		else
			this.salMinimo = 0;
	}

}
