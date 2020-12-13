
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controladores.ControladorAgencia;
import controladores.ControladorCliente;
import controladores.ControladorConta;
import controladores.ControladorEndereco;
import controladores.ControladorFuncionario;
import modelos.Agencia;
import modelos.Cliente;
import modelos.ContaPoupanca;
import modelos.Endereco;
import modelos.Funcionario;
import modelos.Gerente;

public class Teste {
	public static void main(String[] args) throws ParseException {
		Endereco enderecoJoao = new Endereco("Rua Maria", 200, 3817001, "MG", "Perdizes", "Brasil");
		Endereco enderecoAgencia = new Endereco("Centro", 400, 3817000, "MG", "Perdizes", "Brasil");

		Funcionario.salBase = 3000;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascGerente = formato.parse("10/11/1980");
		Date dataAdGerente = formato.parse("20/01/2000");

		Endereco enderecoGerente = new Endereco("Rua Imidia", 89, 3817002, "MG", "Perdizes", "Brasil");
		Gerente gerente = new Gerente("Maria", "36700127025", enderecoGerente, "solteiro", dataNascGerente,
				dataAdGerente, 'f', true, "Adminstração");
		Gerente.setBonificacao(300);

		Agencia one = new Agencia("one 123", 12, enderecoAgencia, gerente);

		Cliente joao = new Cliente("Joao", one, "60792520076", enderecoJoao, "casado", "cursando superior", new Date());

		Cliente maria = new Cliente("maria", one, "69582822058", enderecoJoao, "casada", "Doutorado", new Date());

		one.setCliente(joao);
		one.setCliente(maria);

		ContaPoupanca contaCasal = new ContaPoupanca(0, 11, one, joao, 'A');
		contaCasal.setCliente(maria);
		
		maria.setConta(contaCasal);
		joao.setConta(contaCasal);
		
		contaCasal.setRendimento(0.8);
		contaCasal.deposito(2000);
		contaCasal.saque(1000);

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
        dadosClientes.excluir("60792520076"); dadosClientes.listar();
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
