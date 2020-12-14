package modelos;

import java.util.Date;

public class ContaCorrente extends Conta {
	private static final long serialVersionUID = 1L;
	private double limiteChequeEspecial;
	private double tarifaConta;
	private String categoria;

	//constructor
	public ContaCorrente() {
		super();
		this.limiteChequeEspecial = 0;
		this.tarifaConta = 0;
	}

	public ContaCorrente( String categoria, int nroConta, Agencia agencia, Cliente cliente, char status) {
		super(nroConta, agencia, cliente, status, new Date());
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setCategoria(categoria);
	}

	public ContaCorrente(double limiteChequeEspecial, String categoria, Agencia agencia) {
		super(agencia);
		this.setLimiteChequeEspecial(limiteChequeEspecial);
		this.setCategoria(categoria);
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
		this.categoria = categoria;
	}
	
	//Calculo de tarifa
	@Override
	public double calculaTarifa() {
		if("Standard".equals(this.categoria) == true || "standard".equals(this.categoria) == true) {
			return this.tarifaConta = 12.00; //tarifa conta corrente standard
		}
		else if("Premium".equals(this.categoria) == true || "premium".equals(this.categoria) == true) {
			return this.tarifaConta = 11.00 ; //tarifa conta corrente premium
		}
		return 0;
	}

}
