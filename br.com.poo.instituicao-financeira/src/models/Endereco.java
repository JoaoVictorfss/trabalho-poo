package models;

import java.io.Serializable;

public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	private String rua;
	private int numero;
	private String cep;
	private String uf;
	private String cidade;
	private String pais;

    //constructor
	public Endereco(String rua, int numero, String cep, String uf, String cidade, String pais) {
		this.setRua(rua);
		this.setNumero(numero);
		this.setCep(cep);
		this.setUf(uf);
		this.setCidade(cidade);
		this.setPais(pais);
	}
	
	//getters e setters
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero >= 0)
			this.numero = numero;
		else
			this.numero = 0;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
