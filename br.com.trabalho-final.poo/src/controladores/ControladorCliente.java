package controladores;

import java.util.ArrayList;

import modelos.Cliente;
import repositorio.Persist;

public class ControladorCliente {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private final String arquivo = "clientes.bin";

	private void mostrarDados(Cliente cliente) {
		System.out.println("______________________________________");
		System.out.println("\nDados do cliente\n");
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Estado Civil: " + cliente.getEstadoCivil());
		System.out.println("Data de Nascimento: " + cliente.getDataNasc());
		System.out.println("Escolaridade: " + cliente.getEscolaridade());
		System.out.println("Agência de número: " + cliente.getAgencia().getNroAgencia());
		System.out.println("______________________________________");
	}

	public void cadastrar(Cliente c) {
		Cliente existente = this.buscar(c.getCpf());

		if (existente == null) {
			this.clientes.add(c);// Adiciona o cliente

			System.out.println("Sucesso.Cliente cadastrado com sucesso!");
			System.out.println("A quantidade total de clientes agora eh: " + this.clientes.size());
		}

		else {
			System.out.println("Erro. Cliente duplicado");
		}
	}

	public void listar() {
		if (clientes.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			clientes.forEach(c -> this.mostrarDados(c));
		}
	}

	public Cliente buscar(String cpf) {
		Cliente cliente = null;

		for (Cliente c : this.clientes) {
			if (c.getCpf().equals(cpf)) {
				cliente = c;
				break;
			}
		}

		return cliente;
	}

	public boolean excluir(String cpf) {
		Cliente c = this.buscar(cpf);

		if (c != null) {
			this.clientes.remove(c);
			return true;
		} else {
			return false;
		}
	}

	public void gravarClientes() {
		boolean salvo = true;

		if (!this.clientes.isEmpty()) {
			for (Cliente c : this.clientes) {
				salvo = salvo && Persist.gravar(c, this.arquivo);
			}

			if (salvo)
				System.out.println("Sucesso. Clientes salvos com sucesso!");
			else
				System.out.println("Erro. Ocorreu um erro ao salvar os clientes, tente novamente!");
		} else
			System.out.println("Erro. Sem registros para salvar!");

	}
}
