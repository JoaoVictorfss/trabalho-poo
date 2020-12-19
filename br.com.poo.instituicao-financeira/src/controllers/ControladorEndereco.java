package controllers;

import java.util.ArrayList;

import models.Endereco;
import persist.Persist;

/*
 *   @desc classe rensposável por controlar os dados dos endereços,
 *         usando uma lista para adicionar, excluir, listar e por fim
 *	       guardar em um arquivo binário os dados dentro da mesma.
 */
public class ControladorEndereco implements controller {
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

	// Cadastra endereço na lista, não aceita endereços duplicados
	public void cadastrar(Endereco c) {
		Endereco existente = this.buscar(c.getCep());

		if (existente == null) {
			this.enderecos.add(c);// Adiciona o endereco
		}

		else {
			throw new RuntimeException("Erro. Endereço duplicado");
		}
	}

	// Lista endereços cadastrados
	public void listar() {
		if (enderecos.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			enderecos.forEach(c -> this.mostrarDados(c));
		}
	}

	// Busca endereço pelo cep, retorna um endereço caso encontrado ou null caso
	// contrário
	public Endereco buscar(String cep) {
		Endereco endereco = null;

		for (Endereco c : this.enderecos) {
			if (c.getCep().equals(cep)) {
				endereco = c;
				break;
			}
		}

		return endereco;
	}

	// Exclui um cliente pelo cep, retorna false se o cliente não existir
	public boolean excluir(String cep) {
		Endereco c = this.buscar(cep);

		if (c != null) {
			this.enderecos.remove(c);
			return true;
		} else {
			return false;
		}
	}

	public int qtdTotal() {
		return this.enderecos.size();
	}

	// Salva os endereços em um arquivo binário
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
