package models;

import java.util.Date;

public class ContaCorrente extends Conta {
	private static final long serialVersionUID = 1L;
	private double limiteChequeEspecial;
	private double taxaAdministrativa;
	private String categoria;

	//constructor
	public ContaCorrente() {
		super();
		this.limiteChequeEspecial = 0;
		this.taxaAdministrativa = 0;
	}

	public ContaCorrente(double limiteChequeEspecial, double taxaAdministrativa, int nroConta, Agencia agencia,
			Cliente cliente, char status) {
		super(nroConta, agencia, cliente, status, new Date());
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setTaxaAdministrativa(taxaAdministrativa);
	}

	public ContaCorrente(double limiteChequeEspecial, double taxaAdministrativa, Agencia agencia) {
		super(agencia);
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setTaxaAdministrativa(taxaAdministrativa);
	}

	//getters e setters
	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		if (limiteChequeEspecial > 0)
			this.limiteChequeEspecial = limiteChequeEspecial;
		else
			this.limiteChequeEspecial = 0;
	}

	public double getTaxaAdministrativa() {
		return taxaAdministrativa;
	}

	public void setTaxaAdministrativa(double taxaAdministrativa) {
		if (taxaAdministrativa > 0)
			this.taxaAdministrativa = taxaAdministrativa;
		else
			this.taxaAdministrativa = 0;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	//Cálculo de tarifa
	@Override
	public double calculaTarifa() {
		return 10.00 + this.taxaAdministrativa;
	}

}
