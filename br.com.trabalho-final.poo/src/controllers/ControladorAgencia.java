package controllers;

import java.util.ArrayList;

import models.Agencia;
import persist.Persist;

/*
 * @desc classe rensposável por controlar os dados das agências,
 *       usando uma lista para adicionar, excluir, listar e por fim
 *       guardar em um arquivo binário os dados dentro da mesma.
 */
public class ControladorAgencia {
	private ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	private final String arquivo = "agencias.bin";

	private void mostrarDados(Agencia a) {

		System.out.println("______________________________________");
		System.out.println("\nDados da Agência\n");
		System.out.println("Nome: " + a.getNome());
		System.out.println("Número: " + a.getNroAgencia());
		System.out.println("Nome do gerente: " + a.getGerente().getNome());
		System.out.print("Endereço: ");
		System.out.print(a.getEndereco().getCep() + ", ");
		System.out.print("rua: " + a.getEndereco().getRua() + ", ");
		System.out.print("número: " + a.getEndereco().getNumero() + " - ");
		System.out.print(a.getEndereco().getUf() + ", ");
		System.out.println(a.getEndereco().getCidade() + ".");
		if (!a.getClientes().isEmpty()) {
			System.out.println("\nClientes: ");
			a.getClientes().forEach(c -> System.out.println(c.getNome()));
		}
		System.out.println("______________________________________");

	}

	//Cadastra agência na lista, não aceita agências duplicadas
	public void cadastrar(Agencia a) {
		Agencia existente = this.buscar(a.getNroAgencia());

		if (existente == null) {
			this.agencias.add(a);

			System.out.println("Sucesso. Agência cadastrada com sucesso!");
			System.out.println("A quantidade total de agências agora eh: " + this.agencias.size());
		}

		else {
			System.out.println("Erro. Agência duplicada");
		}
	}

	//Lista agências cadastradas
	public void listar() {
		if (agencias.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			agencias.forEach(a -> this.mostrarDados(a));
		}
	}

	//Busca agência pelo número da agência, retorna uma agência caso encontrada e null caso contrário
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

	//Exclui agência pelo número, retorna true se a agência existir e false caso contrário
	public boolean excluir(int nro) {
		Agencia c = this.buscar(nro);

		if (c != null) {
			this.agencias.remove(c);
			return true;
		} else {
			return false;
		}
	}

	//Salva as agências no arquivo binário
	public void gravarAgencias() {
		boolean salvo = true;
		
        if(!this.agencias.isEmpty()) {
        	for (Agencia a : this.agencias) {
    			salvo = salvo && Persist.gravar(a, this.arquivo);
    		}

    		if (salvo)
    			System.out.println("Sucesso. Agências salvas com sucesso!");
    		else
    			System.out.println("Erro. Ocorreu um erro ao salvar as agências, tente novamente!");
        }else {
			System.out.println("Erro. Sem registros para salvar!");
        }
		
	}
}
