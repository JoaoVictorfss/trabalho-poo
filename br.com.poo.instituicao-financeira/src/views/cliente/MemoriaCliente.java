package views.cliente;

import java.util.Date;

import controllers.ControladorCliente;
import models.Cliente;
import models.Endereco;

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

	public void atualizarCliente(String nome, String cpf, String estadoCivil, String escolaridade, Date dataNasc,
			String endPais, String endUf, String endCep, String endCidade, String endRua, int endNumero,
			Cliente cliente) {

		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setDataNasc(dataNasc);
		cliente.setEscolaridade(escolaridade);
		cliente.setEstadoCivil(estadoCivil);

		cliente.getEndereco().setPais(endPais);
		cliente.getEndereco().setUf(endUf);
		cliente.getEndereco().setCep(endCep);
		cliente.getEndereco().setCidade(endCidade);
		cliente.getEndereco().setRua(endRua);
		cliente.getEndereco().setNumero(endNumero);

		dadosClientes.listar();
	}

}
