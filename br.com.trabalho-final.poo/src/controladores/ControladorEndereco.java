package controladores;

import java.util.ArrayList;

import modelos.Agencia;
import modelos.Endereco;
import repositorio.Persist;

public class ControladorEndereco {
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	private final String arquivo = "enderecos.bin";

	private void mostrarDados(Endereco endereco) {
		System.out.println("______________________________________");
		System.out.println("\nDados do endereco\n");
		System.out.println("CEP: " + endereco.getCep());
		System.out.println("País: " + endereco.getPais());
		System.out.println("Cidade: " + endereco.getCidade());
		System.out.println("Estado: " + endereco.getUf());
		System.out.println("Rua: " + endereco.getRua());
		System.out.println("Número: " + endereco.getNumero());
		System.out.println("______________________________________\n");
	}
	

	public void cadastrar(Endereco c) {
		Endereco existente = this.buscar(c.getCep());

		if (existente == null) {
			this.enderecos.add(c);// Adiciona o endereco

			System.out.println("Sucesso. Endereço cadastrado com sucesso!");
			System.out.println("A quantidade total de enderecos agora eh: " + this.enderecos.size());
		}

		else {
			System.out.println("Erro. Endereco duplicado");
		}
	}

	public void listar() {
		if (enderecos.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			enderecos.forEach(c -> this.mostrarDados(c));
		}
	}

	public Endereco buscar(int cep) {
		Endereco endereco = null;

		for (Endereco c : this.enderecos) {
			if (c.getCep() == cep) {
				endereco = c;
				break;
			}
		}

		return endereco;
	}

	public boolean excluir(int cep) {
		Endereco c = this.buscar(cep);

		if (c != null) {
			this.enderecos.remove(c);
			return true;
		} else {
			return false;
		}
	}

	public void gravarEnderecos() {
		boolean salvo = true;

		if (!this.enderecos.isEmpty()) {
			for (Endereco c : this.enderecos) {
				salvo = salvo && Persist.gravar(c, this.arquivo);
			}

			if (salvo)
				System.out.println("Sucesso. Endereços salvos com sucesso!");
			else
				System.out.println("Erro. Ocorreu um erro ao salvar os endereços, tente novamente!");
		} else
			System.out.println("Erro. Sem registros para salvar!");

	}
}
