
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controladores.ControladorAgencia;
import controladores.ControladorCliente;
import modelos.Agencia;
import modelos.Cliente;
import modelos.ContaPoupanca;
import modelos.Endereco;
import modelos.Funcionario;
import modelos.Gerente;
import repositorio.Persist;

public class Teste {
	/*
	 * public static void mostraDadosGerente(Gerente gerente) {
	 * System.out.println("______________________________________");
	 * System.out.println("\nDados do gerente\n"); System.out.println("Nome: " +
	 * gerente.getNome()); System.out.println("CPF: " + gerente.getCpf());
	 * System.out.println("Estado Civil: " + gerente.getEstadoCivil());
	 * System.out.println("Data de Nascimento: " + gerente.getDataNasc());
	 * System.out.println("Data de Admissão: " + gerente.getDataAd());
	 * System.out.println("Sexo: " + gerente.getSexo());
	 * System.out.println("Salário total: R$ " + gerente.calcSal()); if
	 * (gerente.getPossuiCurso()) System.out.println("Curso: " +
	 * gerente.getNomeCurso());
	 * System.out.println("______________________________________"); }
	 * 
	 * public static void mostraDadosCliente(Cliente cliente) {
	 * System.out.println("______________________________________");
	 * System.out.println("\nDados do cliente\n"); System.out.println("Nome: " +
	 * cliente.getNome()); System.out.println("CPF: " + cliente.getCpf());
	 * System.out.println("Estado Civil: " + cliente.getEstadoCivil());
	 * System.out.println("Data de Nascimento: " + cliente.getDataNasc());
	 * System.out.println("Escolaridade: " + cliente.getEscolaridade());
	 * System.out.println("Agência de número: " +
	 * cliente.getAgencia().getNroAgencia());
	 * System.out.println("______________________________________"); }
	 * 
	 * public static void mostraDadosConta(ContaPoupanca conta) {
	 * System.out.println("______________________________________");
	 * System.out.println("\nDados da conta\n"); System.out.println("Número: " +
	 * conta.getNroConta()); System.out.println("Saldo: " + conta.getSaldoAtual());
	 * System.out.println("Rendimento: " + conta.getRendimento());
	 * System.out.println("Status: " + conta.getStatus());
	 * System.out.println("Número da agência: " +
	 * conta.getAgencia().getNroAgencia()); System.out.println("Total de clientes: "
	 * + conta.getTotalCliente());
	 * System.out.println("Nomes dos clientes na conta:"); ArrayList<Cliente>
	 * clientesContaCasal = conta.getClientes(); clientesContaCasal.forEach(cliente
	 * -> System.out.println(cliente.getNome()));
	 * System.out.println("______________________________________"); }
	 */

	public static void main(String[] args) throws ParseException {
		Endereco enderecoJoao = new Endereco("Rua Maria", 200, 3817000, "MG", "Perdizes", "Brasil");
		Endereco enderecoAgencia = new Endereco("Centro", 400, 3817000, "MG", "Perdizes", "Brasil");

		// Testa cliente
		Funcionario.salBase = 3000;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascGerente = formato.parse("10/11/1980");
		Date dataAdGerente = formato.parse("20/01/2000");

		Endereco enderecoGerente = new Endereco("Rua Imidia", 89, 3817000, "MG", "Perdizes", "Brasil");
		Gerente gerente = new Gerente("Maria", "36700127025", enderecoGerente, "solteiro", dataNascGerente,
				dataAdGerente, 'f', true, "Adminstração");
		Gerente.setBonificacao(300);

		Agencia one = new Agencia("one 123", 12, enderecoAgencia, gerente);

		Cliente joao = new Cliente("Joao", one, "60792520076", enderecoJoao, "casado", "cursando superior", new Date());

		Cliente maria = new Cliente("maria", one, "69582822058", enderecoJoao, "casada", "Doutorado", new Date());

		one.setCliente(joao);
		one.setCliente(maria);

		ContaPoupanca contaCasal = new ContaPoupanca(0, 11, one, joao, 'A');
		contaCasal.setCliente(maria);// adiciona outra pessoa na conta criada
		maria.setConta(contaCasal);
		joao.setConta(contaCasal);
		contaCasal.setRendimento(0.8);
		contaCasal.deposito(2000, new Date(), one, 1);
		contaCasal.saque(1000, new Date(), one, 2);

		one.setConta(contaCasal);

		ControladorCliente dadosClientes = new ControladorCliente();
		ControladorAgencia dadosAgencias = new ControladorAgencia();

		dadosAgencias.cadastrar(one);
		dadosAgencias.listar();
		dadosAgencias.excluir(12);
		dadosAgencias.listar();
		dadosAgencias.gravarAgencias();
		/*
		 * dadosClientes.cadastrar(joao); dadosClientes.cadastrar(maria);
		 * dadosClientes.cadastrar(maria);
		 * 
		 * 
		 * dadosClientes.excluir("60792520076"); dadosClientes.listar();
		 * dadosClientes.gravarClientes();
		 * 
		 * Cliente maria2 = dadosClientes.buscar("69582822058");
		 * System.out.println(maria2.getNome());
		 */

		/*
		 * 
		 * //Testa conta
		 * 
		 * Teste.mostraDadosConta(contaCasal);
		 * 
		 * //Testa Agência one.setConta(contaCasal);
		 * 
		 * ArrayList<Conta> contas = one.getContas(); contas.forEach(item ->
		 * System.out.println("\nNúmeros das contas cadastradas na agência: " +
		 * item.getNroConta()));
		 */
	}

}
