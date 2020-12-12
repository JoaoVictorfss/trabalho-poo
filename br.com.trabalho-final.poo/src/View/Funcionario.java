package View;

import java.util.Date;

public class Funcionario extends Pessoa {
	private Date DataAd;
	private char sexo;
	private String cargo;
	static  double salBase;

	public Funcionario(String nome, String cpf, Endereco endereco, String estadoCivil, Date dataNasc, Date dataAd,
			char sexo, String cargo) {
		super(nome, cpf, endereco, estadoCivil, dataNasc);
		DataAd = dataAd;
		this.setSexo(sexo);
		this.setCargo(cargo);
	}

	public Date getDataAd() {
		return DataAd;
	}

	public void setDataAd(Date dataAd) {
		DataAd = dataAd;
	}

	public String getSexo() {
		if(this.sexo == 'M' || this.sexo == 'm') return "Masculino";
		else return "Feminino";
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
	
	public double calcSal() {
		return Funcionario.salBase;
	}

}
