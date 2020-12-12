package view;

import java.util.ArrayList;

public class Instituicao {
	private ArrayList<Agencia> agencias = new ArrayList<Agencia>();

//constructor
	public Instituicao(ArrayList<Agencia> agencias) {
		agencias.forEach(agencia -> this.agencias.add(agencia));
	}

	public Instituicao() {
	}

	public ArrayList<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencia(Agencia agencia) {
		this.agencias.add(agencia);
	}
}
