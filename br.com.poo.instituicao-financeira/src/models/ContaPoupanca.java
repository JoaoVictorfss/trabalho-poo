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

	// Calculo de tarifa
	@Override
	public double calculaTarifa() {
		return this.tarifaConta;
	}

}
