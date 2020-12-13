package controladores;

import java.util.ArrayList;

import modelos.Funcionario;
import repositorio.Persist;

public class ControladorFuncionario {
	private ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	private final String arquivo = "funcionarios.bin";

	private void mostrarDados(Funcionario funcionario) {
		System.out.println("______________________________________");
		System.out.println("\nDados do Funcionário\n");
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("CPF: " + funcionario.getCpf());
		System.out.println("Estado Civil: " + funcionario.getEstadoCivil());
		System.out.println("Data de Admissão: " + funcionario.getDataAd());
		System.out.println("Sexo: " + funcionario.getSexo());
		System.out.println("Cargo: " + funcionario.getCargo());
		System.out.println("______________________________________");
	}
	
	public void cadastrar(Funcionario f) {
		Funcionario existente = this.buscar(f.getCpf());

		if (existente == null) {
			this.Funcionarios.add(f);// Adiciona o Funcionario

			System.out.println("Sucesso. Funcionário cadastrado com sucesso!");
			System.out.println("A quantidade total de Funcionarios agora eh: " + this.Funcionarios.size());
		}

		else {
			System.out.println("Erro. Funcionário duplicado");
		}
	}

	public void listar() {
		if (Funcionarios.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			Funcionarios.forEach(f -> this.mostrarDados(f));
		}
	}

	public Funcionario buscar(String cpf) {
		Funcionario funcionario = null;

		for (Funcionario f : this.Funcionarios) {
			if (f.getCpf().equals(cpf)) {
				funcionario = f;
				break;
			}
		}

		return funcionario;
	}

	public boolean excluir(String cpf) {
		Funcionario f = this.buscar(cpf);

		if (f != null) {
			this.Funcionarios.remove(f);
			return true;
		} else {
			return false;
		}
	}

	public void gravarFuncionarios() {
		boolean salvo = true;

		if (!this.Funcionarios.isEmpty()) {
			for (Funcionario f : this.Funcionarios) {
				salvo = salvo && Persist.gravar(f, this.arquivo);
			}

			if (salvo)
				System.out.println("Sucesso. Funcionários salvos com sucesso!");
			else
				System.out.println("Erro. Ocorreu um erro ao salvar os funcionarios, tente novamente!");
		} else
			System.out.println("Erro. Sem registros para salvar!");

	}
}
