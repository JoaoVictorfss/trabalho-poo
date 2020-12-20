package controllers;

import java.util.ArrayList;

import models.Conta;
import persist.Persist;

/*
 * @desc classe rensposável por controlar os dados das contas,
 *       usando uma lista para adicionar, excluir, listar e por fim
 *       guardar em um arquivo binário os dados dentro da mesma.
 */
public class ControladorConta implements controller {
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private final String arquivo = "contas.bin";

	// Cadastra conta na lista, não aceita contas duplicadas
	public void cadastrar(Conta c) {
		Conta existente = this.buscar(c.getNroConta());

		if (existente == null) {
			this.contas.add(c);
		}

		else {
			throw new RuntimeException("Erro. Conta duplicada");
		}

	}

	// Lista contas cadastrados
	public void listar() {
		if (contas.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			contas.forEach(c -> c.mostrarDados());
		}
	}

	// Busca conta pelo número, retorna uma conta caso encontrada ou null caso
	// contrário
	public Conta buscar(int nro) {
		Conta Conta = null;

		for (Conta c : this.contas) {
			if (c.getNroConta() == nro) {
				Conta = c;
				break;
			}
		}

		return Conta;
	}

	// Exclui uma conta pelo número
	public void excluir(int nro) {
		Conta c = this.buscar(nro);

		if (c != null) {
			this.contas.remove(c);
		} else {
			throw new RuntimeException("Conta inexistente");
		}
	}

	public int qtdTotal() {
		return this.contas.size();
	}

	// Salva as contas em um arquivo binário
	public void gravarcontas() {
		boolean salvo = true;

		if (!this.contas.isEmpty()) {
			for (Conta c : this.contas) {
				salvo = salvo && Persist.gravar(c, this.arquivo);
			}

			if (salvo)
				System.out.println("Sucesso. As contas foram salvas com sucesso!");
			else
				throw new RuntimeException("Erro. Ocorreu um erro ao salvar as contas, tente novamente!");
		} else
			throw new RuntimeException("Erro. Sem registros para salvar!");
	}

}
