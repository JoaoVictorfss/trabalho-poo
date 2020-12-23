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
			throw new RuntimeException("Número residencial informado é inválido");
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + numero;
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (numero != other.numero)
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	public void mostrarDados() {
		System.out.println("______________________________________");
		System.out.println("\nDados do endereco\n");
		System.out.println("CEP: " + this.getCep());
		System.out.println("País: " + this.getPais());
		System.out.println("Cidade: " + this.getCidade());
		System.out.println("Estado: " + this.getUf());
		System.out.println("Rua: " + this.getRua());
		System.out.println("Número: " + this.getNumero());
		System.out.println("______________________________________\n");
	}

}
