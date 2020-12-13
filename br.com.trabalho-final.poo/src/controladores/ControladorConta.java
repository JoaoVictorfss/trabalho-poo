package controladores;

import java.util.ArrayList;

import modelos.Conta;

import repositorio.Persist;

public class ControladorConta {
	private ArrayList<Conta> contas= new ArrayList<Conta>();
	private final String arquivo = "contas.bin";

	private void mostrarDados(Conta conta) {
		System.out.println("______________________________________");
		System.out.println("\nDados do Conta\n");
		System.out.println("Número: " + conta.getNroConta());
		System.out.println("Status: " + conta.getStatus());
		System.out.println("Número da Agencia: " + conta.getAgencia().getNroAgencia());
		System.out.println("Quantidade de clientes: " + conta.getTotalCliente());
		System.out.println("Data de abertura: " + conta.getDataAbertura());
		System.out.println("______________________________________");
	}
	
	public void cadastrar(Conta c) {
		Conta existente = this.buscar(c.getNroConta());

		if (existente == null) {
			this.contas.add(c);// Adiciona o Conta
			System.out.println("______________________________________");
			System.out.println("Sucesso.Conta cadastrado com sucesso!");
			System.out.println("A quantidade total de contas agora eh: " + this.contas.size());
			System.out.println("______________________________________");
		}

		else {
			System.out.println("Erro. Conta duplicado");
		}
	}

	public void listar() {
		if (contas.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			contas.forEach(c -> this.mostrarDados(c));
		}
	}

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

	public boolean excluir(int nro) {
		Conta c = this.buscar(nro);

		if (c != null) {
			this.contas.remove(c);
			return true;
		} else {
			return false;
		}
	}

	public void gravarcontas() {
		boolean salvo = true;

		if (!this.contas.isEmpty()) {
			for (Conta c : this.contas) {
				salvo = salvo && Persist.gravar(c, this.arquivo);
			}

			if (salvo)
				System.out.println("Sucesso. As contas foram salvas com sucesso!");
			else
				System.out.println("Erro. Ocorreu um erro ao salvar os contas, tente novamente!");
		} else
			System.out.println("Erro. Sem registros para salvar!");

	}

}
