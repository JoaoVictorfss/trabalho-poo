package controladores;

import java.util.ArrayList;

import modelos.Conta;
import repositorio.Persist;

/*
 * @desc classe rensposável por controlar os dados das contas,
 *       usando uma lista para adicionar, excluir, listar e por fim
 *       guardar em um arquivo binário os dados dentro da mesma.
 */
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
	
	//Cadastra conta na lista, não aceita contas duplicadas
	public void cadastrar(Conta c) {
		Conta existente = this.buscar(c.getNroConta());

		if (existente == null) {
			this.contas.add(c);
			System.out.println("Sucesso.Conta cadastrada com sucesso!");
			System.out.println("A quantidade total de contas agora eh: " + this.contas.size());
		}

		else {
			System.out.println("Erro. Conta duplicado");
		}
	}

	//Lista contas cadastrados
	public void listar() {
		if (contas.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			contas.forEach(c -> this.mostrarDados(c));
		}
	}

	//Busca conta pelo número, retorna uma conta caso encontrada ou null caso contrário
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

	//Exclui uma conta pelo número, retorna false se a conta não existir
	public boolean excluir(int nro) {
		Conta c = this.buscar(nro);

		if (c != null) {
			this.contas.remove(c);
			return true;
		} else {
			return false;
		}
	}

	//Salva as contas em um arquivo binário
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
