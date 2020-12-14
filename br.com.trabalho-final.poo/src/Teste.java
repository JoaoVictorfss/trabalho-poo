
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controllers.ControladorAgencia;
import controllers.ControladorCliente;
import controllers.ControladorConta;
import controllers.ControladorEndereco;
import controllers.ControladorFuncionario;
import models.Agencia;
import models.Cliente;
import models.ContaCorrente;
import models.ContaPoupanca;
import models.Endereco;
import models.Funcionario;
import models.Gerente;

public class Teste {
	public static void main(String[] args) throws ParseException {
		Endereco enderecoJoao = new Endereco("Rua Maria", 200, 3817001, "MG", "Perdizes", "Brasil");
		Endereco enderecoAgencia = new Endereco("Centro", 400, 3817000, "MG", "Perdizes", "Brasil");
		Endereco enderecoGerente = new Endereco("Rua Imidia", 89, 3817002, "MG", "Perdizes", "Brasil");

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascGerente = formato.parse("10/11/1980");
		Date dataAdGerente = formato.parse("20/01/2000");

		Funcionario.salBase = 3000;
		Gerente gerente = new Gerente("Maria", "36700127025", enderecoGerente, "solteiro", dataNascGerente,
				dataAdGerente, 'f', true, "Adminstração");
		Gerente.setBonificacao(300);

		Agencia one = new Agencia("one 123", 12, enderecoAgencia, gerente);

		Cliente joao = new Cliente("Joao", one, "60792520076", enderecoJoao, "casado", "cursando superior", new Date());
		Cliente maria = new Cliente("maria", one, "69582822058", enderecoJoao, "casada", "Doutorado", new Date());
		
		one.setCliente(joao);
		one.setCliente(maria);
		
		ContaPoupanca contaCasal = new ContaPoupanca(0, 11, one, joao, 'A', 8);
		contaCasal.setCliente(maria);
		maria.setConta(contaCasal);
		joao.setConta(contaCasal);
		
		
		ContaCorrente mario = new ContaCorrente("premium", 13, one, joao, 'A', 800);
		System.out.println(mario.calculaTarifa());

		contaCasal.setRendimento(0.8);
		contaCasal.deposito(2000, new Date());
		contaCasal.saque(1000, new Date());

		one.setConta(contaCasal);

		ControladorAgencia dadosAgencias = new ControladorAgencia();
		dadosAgencias.cadastrar(one);
		dadosAgencias.listar();
		dadosAgencias.excluir(12);
		dadosAgencias.listar();
		dadosAgencias.gravarAgencias();

		ControladorCliente dadosClientes = new ControladorCliente();
		dadosClientes.cadastrar(joao);
		dadosClientes.cadastrar(maria);
		dadosClientes.cadastrar(maria);
		dadosClientes.excluir("60792520076");
		dadosClientes.listar();
		dadosClientes.gravarClientes();
		Cliente maria2 = dadosClientes.buscar("69582822058");
		System.out.println(maria2.getNome());

		ControladorConta dadosContas = new ControladorConta();
		dadosContas.cadastrar(contaCasal);
		dadosContas.listar();
		dadosContas.excluir(11);

		dadosContas.gravarcontas();

		ControladorFuncionario dadosFuncionarios = new ControladorFuncionario();
		dadosFuncionarios.cadastrar(gerente);
		dadosFuncionarios.listar();
		dadosFuncionarios.gravarFuncionarios();

		ControladorEndereco dadosEnderecos = new ControladorEndereco();
		dadosEnderecos.cadastrar(enderecoAgencia);
		dadosEnderecos.cadastrar(enderecoGerente);
		dadosEnderecos.listar();
		dadosEnderecos.excluir(3817000);
		dadosEnderecos.listar();
		dadosEnderecos.gravarEnderecos();

	}

}
