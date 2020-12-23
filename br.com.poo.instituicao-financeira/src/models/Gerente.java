package models;

import java.util.Date;

public class Gerente extends Funcionario {
	private static final long serialVersionUID = 1L;
	private boolean possuiCurso;
	private String nomeCurso;
	private static double bonificacao;

	// constructor
	public Gerente(String nome, String cpf, Endereco endereco, String estadoCivil, Date dataNasc, Date dataAd,
			char sexo, boolean possuiCurso, String nomeCurso) {
		super(nome, cpf, endereco, estadoCivil, dataNasc, dataAd, sexo, "gerente");
		this.setPossuiCurso(possuiCurso);
		this.setNomeCurso(nomeCurso);
	}

	//getters e setters
	public boolean getPossuiCurso() {
		return possuiCurso;
	}

	public void setPossuiCurso(boolean possuiCurso) {
		this.possuiCurso = possuiCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		if (this.possuiCurso)
			this.nomeCurso = nomeCurso;
		else
			this.nomeCurso = "Nao possui";
	}

	public static double getBonificacao() {
		return bonificacao;
	}

	public static void setBonificacao(double bonificacao) {
		if (bonificacao >= 0)
			Gerente.bonificacao = bonificacao;
		else
			throw new RuntimeException("Valor de bonificação é inválido");
	}
	
    //Cálculo de salário
	public double calcSal() {
		@SuppressWarnings("deprecation")
		final int anoAtual = new Date().getYear();
		@SuppressWarnings("deprecation")
		final int anoEntrada = this.getDataAd().getYear();
		final int anos = anoAtual - anoEntrada;
		return Gerente.salBase + Gerente.getBonificacao() * anos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nomeCurso == null) ? 0 : nomeCurso.hashCode());
		result = prime * result + (possuiCurso ? 1231 : 1237);
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
		Gerente other = (Gerente) obj;
		if (nomeCurso == null) {
			if (other.nomeCurso != null)
				return false;
		} else if (!nomeCurso.equals(other.nomeCurso))
			return false;
		if (possuiCurso != other.possuiCurso)
			return false;
		return true;
	}
	
	
}
