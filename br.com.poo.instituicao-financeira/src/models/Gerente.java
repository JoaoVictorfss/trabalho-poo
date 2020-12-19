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
}
