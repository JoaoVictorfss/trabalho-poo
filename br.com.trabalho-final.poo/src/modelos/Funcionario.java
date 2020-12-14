package modelos;

import java.util.Date;

public class Funcionario extends Pessoa {
	private static final long serialVersionUID = 1L;
	private Date DataAd;
	private char sexo;
	private String cargo;
	public static double salBase;

	//constructor
	public Funcionario(String nome, String cpf, Endereco endereco, String estadoCivil, Date dataNasc, Date dataAd,
			char sexo, String cargo) {
		super(nome, cpf, endereco, estadoCivil, dataNasc);
		DataAd = dataAd;
		this.setSexo(sexo);
		this.setCargo(cargo);
	}

	//getters e setters
	public Date getDataAd() {
		return DataAd;
	}

	public void setDataAd(Date dataAd) {
		DataAd = dataAd;
	}

	public String getSexo() {
		if (this.sexo == 'M' || this.sexo == 'm')
			return "Masculino";
		else
			return "Feminino";
	}

	public void setSexo(char sexo) {
		if (sexo == 'M' || sexo == 'F' || sexo == 'f' || sexo == 'm')
			this.sexo = sexo;
		else
			this.sexo = 'N';
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	//Cálculo de salário
	public double calcSal() {
		return Funcionario.salBase;
	}

}
