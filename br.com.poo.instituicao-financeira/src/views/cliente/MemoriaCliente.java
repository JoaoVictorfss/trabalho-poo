package views.cliente;

import controllers.ControladorCliente;
import models.Cliente;


public class MemoriaCliente {
	private ControladorCliente dadosClientes = new ControladorCliente();
	private static final MemoriaCliente instancia = new MemoriaCliente();

	public static MemoriaCliente getInstancia() {
		return instancia;
	}

	public void adicionarCliente(Cliente c) {
		dadosClientes.cadastrar(c);
		dadosClientes.listar();
	}

	public void exluirCliente(String cpf) {
		dadosClientes.excluir(cpf);
	}

	public Cliente buscaCliente(String cpf) {
		return dadosClientes.buscar(cpf);
	}
	
	public void listar() {
		dadosClientes.listar();
	}
}
