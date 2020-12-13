package controladores;

import java.util.ArrayList;

import modelos.Agencia;
import repositorio.Persist;

public class ControladorAgencia {
	private ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	private final String arquivo = "agencias.bin";

	private void mostrarDados(Agencia a) {

		System.out.println("______________________________________");
		System.out.println("\nDados da Agencia\n");
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

	public void cadastrar(Agencia a) {
		Agencia existente = this.buscar(a.getNroAgencia());

		if (existente == null) {
			this.agencias.add(a);// Adiciona o Agencia

			System.out.println("Sucesso. Agência cadastrada com sucesso!");
			System.out.println("A quantidade total de agências agora eh: " + this.agencias.size());
		}

		else {
			System.out.println("Erro. Agencia duplicado");
		}
	}

	public void listar() {
		if (agencias.isEmpty()) {
			System.out.println("Sem registros!");
		} else {
			agencias.forEach(a -> this.mostrarDados(a));
		}
	}

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

	public boolean excluir(int nro) {
		Agencia c = this.buscar(nro);

		if (c != null) {
			this.agencias.remove(c);
			return true;
		} else {
			return false;
		}
	}

	public void gravarAgencias() {
		boolean salvo = true;
        if(!this.agencias.isEmpty()) {
        	for (Agencia a : this.agencias) {
    			salvo = salvo && Persist.gravar(a, this.arquivo);
    		}

    		if (salvo)
    			System.out.println("Sucess. Agências salvos com sucesso!");
    		else
    			System.out.println("Erro. Ocorreu um erro ao salvar as agência, tente novamente!");
        }else {
			System.out.println("Erro. Sem registros para salvar!");
        }
		
	}
}
