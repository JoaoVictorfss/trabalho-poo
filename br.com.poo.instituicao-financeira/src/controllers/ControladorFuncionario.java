package controllers;

import java.util.ArrayList;

import models.Funcionario;
import persist.Persist;

/*
 *   @desc classe rensposável por controlar os dados dos funcionários,
 *         usando uma lista para adicionar, excluir, listar e por fim
 *	       guardar em um arquivo binário os dados dentro da mesma.
 */
public class ControladorFuncionario implements controller {
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private final String arquivo = "funcionarios.bin";

	// Cadastra funcionário na lista, não aceita funcionários duplicados
	public void cadastrar(Funcionario f) {
		Funcionario existente = this.buscar(f.getCpf());

		if (existente == null) {
			this.funcionarios.add(f);
		}

		else {
			throw new RuntimeException("Erro. Funcionário duplicado");
		}
	}

	// Lista endereços cadastrados
	public void listar() {
		if (funcionarios.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			funcionarios.forEach(f -> f.mostrarDados());
		}
	}

	// Busca endereço pelo cep, retorna um endereço caso encontrado ou null caso
	// contrário
	public Funcionario buscar(String cpf) {
		Funcionario funcionario = null;

		for (Funcionario f : this.funcionarios) {
			if (f.getCpf().equals(cpf)) {
				funcionario = f;
				break;
			}
		}

		return funcionario;
	}

	// Exclui um endereço pelo cep, retorna false se o endereço não existir
	public void excluir(String cpf) {
		Funcionario f = this.buscar(cpf);

		if (f != null) {
			this.funcionarios.remove(f);
		} else {
			throw new RuntimeException("Funcionário inexistente");
		}
	}

	public int qtdTotal() {
		return this.funcionarios.size();
	}

	// Salva os endereços em um arquivo binário
	public void gravarFuncionarios() {
		boolean salvo = true;

		if (!this.funcionarios.isEmpty()) {
			for (Funcionario f : this.funcionarios) {
				salvo = salvo && Persist.gravar(f, this.arquivo);
			}

			if (salvo)
				System.out.println("Sucesso. Funcionários salvos com sucesso!");
			else
				throw new RuntimeException("Erro. Ocorreu um erro ao salvar os funcionários, tente novamente!");
		} else
			throw new RuntimeException("Erro. Sem registros para salvar!");
	}

}
