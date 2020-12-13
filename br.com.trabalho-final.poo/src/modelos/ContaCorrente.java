package modelos;

import java.util.Date;

public class ContaCorrente extends Conta {
	private double limiteChequeEspecial;
	private double taxaAministrativa;

	public ContaCorrente() {
		super();
		this.limiteChequeEspecial = 0;
		this.taxaAministrativa = 0;
	}
	
	public ContaCorrente(double limiteChequeEspecial, double taxaAministrativa, int nroConta, Agencia agencia,
			Cliente cliente, char status) {
		super(nroConta, agencia, cliente, status, new Date());
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setTaxaAministrativa(taxaAministrativa);
	}
	
	public ContaCorrente(double limiteChequeEspecial, double taxaAministrativa, Agencia agencia) {
		super(agencia);
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setTaxaAministrativa(taxaAministrativa);
	}

	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		if (limiteChequeEspecial > 0)
			this.limiteChequeEspecial = limiteChequeEspecial;
		else
			this.limiteChequeEspecial = 0;
	}

	public double getTaxaAministrativa() {
		return taxaAministrativa;
	}

	public void setTaxaAministrativa(double taxaAministrativa) {
		if (taxaAministrativa > 0)
			this.taxaAministrativa = taxaAministrativa;
		else
			this.taxaAministrativa = 0;
	}

}
