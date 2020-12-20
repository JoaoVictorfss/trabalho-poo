package controllers;

import java.util.ArrayList;

import models.Agencia;
import persist.Persist;

/*
 * @desc classe rensposável por controlar os dados das agências,
 *       usando uma lista para adicionar, excluir, listar e por fim
 *       guardar em um arquivo binário os dados dentro da mesma.
 */
public class ControladorAgencia implements controller {
	private ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	private final String arquivo = "agencias.bin";

	// Cadastra agência na lista, não aceita agências duplicadas
	public void cadastrar(Agencia a) {
		Agencia existente = this.buscar(a.getNroAgencia());

		if (existente == null) {
			this.agencias.add(a);
		}

		else {
			throw new RuntimeException("Erro. Agência duplicada");
		}
	}

	// Lista agências cadastradas
	public void listar() {
		if (agencias.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			agencias.forEach(a -> a.mostrarDados());
		}
	}

	// Busca agência pelo número da agência, retorna uma agência caso encontrada e
	// null caso contrário
	public Agencia buscar(int nroAgencia) {
		Agencia agencia = null;

		for (Agencia a : this.agencias) {
			if (a.getNroAgencia() == nroAgencia) {
				agencia = a;
				break;
			}
		}

		return agencia;
	}

	// Exclui agência pelo número
	public void excluir(int nro) {
		Agencia c = this.buscar(nro);

		if (c != null) {
			this.agencias.remove(c);
		} else {
			throw new RuntimeException("Agência inexistente");
		}
	}

	public int qtdTotal() {
		return this.agencias.size();
	}

	// Salva as agências no arquivo binário
	public void gravarAgencias() {
		boolean salvo = true;

		if (!this.agencias.isEmpty()) {
			for (Agencia a : this.agencias) {
				salvo = salvo && Persist.gravar(a, this.arquivo);
			}

			if (salvo)
				System.out.println("Sucesso. Agências salvas com sucesso!");
			else
				throw new RuntimeException("Erro. Ocorreu um erro ao salvar as agências, tente novamente!");
		} else {
			throw new RuntimeException("Erro. Sem registros para salvar!");
		}

	}
}
