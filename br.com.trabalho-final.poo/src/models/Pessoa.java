package models;

import java.io.Serializable;
import java.util.Date;
import java.util.InputMismatchException;

public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private Endereco endereco;
	private String estadoCivil;
	private Date dataNasc;

	//constructor
	public Pessoa() {
		this(null, null, null, null, null);
	}

	public Pessoa(String nome, String cpf, Endereco endereco, String estadoCivil, Date dataNasc) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setEstadoCivil(estadoCivil);
		this.setDataNasc(dataNasc);
	}

	// Validação de cpf obtido no site
	private boolean cpfValido(String CPF) {
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (this.cpfValido(cpf))
			this.cpf = cpf;
		else
			this.cpf = "";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		estadoCivil = estadoCivil.toLowerCase();
		if (!(estadoCivil.equals("solteiro") || estadoCivil.equals("casado") || estadoCivil.equals("separado")
				|| estadoCivil.equals("vi�vo")))
			this.estadoCivil = "solteiro";
		else
			this.estadoCivil = estadoCivil;
	}

}
