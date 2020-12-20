/*package teste;
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


/*
 * @desc Utilização da pasta "models" para armazenar as classes que representam os objetos da instituição 
 *       financeira.
 * 
 * @desc Utilização da pasta "controllers" armazenar as classes reponsáveis pela manipulação dos dados do 
 *       sistema, sendo que há um controller para cada classe que representa um objeto da instituição financeira. 
 *       Esses controllers são responsáveis pelo cadastro, exclusão, listagem, busca e por salvar os dados referentes 
 *       a cada classe em seu respectivo arquivo binário.
 *       
 *@desc Foi criado a interface que faz obrigatório a implentação do requisito de devolver a quantidade de dados 
 *      cadastrados em sua respectiva lista de dados, dentro do controller. Essa interface está na pasta de
 *      controllers.
 *      
 *@desc Utilização da pasta "persist" para guardar a classe que tem como objetivo escrever os dados das listas 
 *      dentro dos controllers em um arquivo binário.
 *      
 * @author João Victor Fernandes de Souza Silva
 * @author Luiz André da Silva Carvalho
 * @author Brunno Fabrício Moraes Viegas
 * 
 * @date 14/12/2020
 * 
 

public class Teste {
	public static void te(String[] args) throws ParseException {
		Endereco enderecoJoao = new Endereco("Rua Maria", 200, "3817001", "MG", "Perdizes", "Brasil");
		Endereco enderecoAgencia = new Endereco("Centro", 400, "3817000", "MG", "Perdizes", "Brasil");
		Endereco enderecoGerente = new Endereco("Rua Imidia", 89, "3817002", "MG", "Perdizes", "Brasil");

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascGerente = formato.parse("10/11/1980");
		Date dataAdGerente = formato.parse("20/01/2000");

		Funcionario.salBase = 3000;
		Gerente gerente = new Gerente("Maria", "36700127025", enderecoGerente, "solteiro", dataNascGerente,
				dataAdGerente, 'f', true, "Adminstração");
		Gerente.setBonificacao(300);

		Agencia one = new Agencia("one 123", 12, enderecoAgencia, gerente);

		Cliente joao = new Cliente("Joao", one, "60792520076", enderecoJoao, "casado", "cursando superior", new Date());
		Cliente maria = new Cliente("maria", one, "69582822058", enderecoJoao, "casado", "Doutorado", new Date());
		
		one.setCliente(joao);
		one.setCliente(maria);
		
		ContaPoupanca contaCasal = new ContaPoupanca(0, 11, one, joao, "A", 8);
		contaCasal.setCliente(maria);
		maria.setConta(contaCasal);
		joao.setConta(contaCasal);
		
		
		ContaCorrente mario = new ContaCorrente("premium", 13, one, joao, "A", 800);
		System.out.println(mario.calculaTarifa());

		contaCasal.setRendimento(0.8);
		contaCasal.deposito(2000);
		contaCasal.saque(1000);
		contaCasal.printTransacoes();

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
		dadosEnderecos.excluir("3817000");
		dadosEnderecos.listar();
		dadosEnderecos.gravarEnderecos();

	}

}*/
