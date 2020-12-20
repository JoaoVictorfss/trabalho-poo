package views.conta;


import controllers.ControladorConta;
import models.Conta;
import views.templates.Alerta;

public class MemoriaConta {
    private ControladorConta dadosContas = new ControladorConta();
    private static final MemoriaConta instancia = new MemoriaConta();

    public static MemoriaConta getInstancia() {
        return instancia;
    }

    public void adicionarAgencia(Conta c){
        dadosContas.cadastrar(c);
    }
    
    public void exluirAgencia(String nro) {
		dadosContas.excluir(this.transformaNumero(nro));
	}
	
	public Conta buscaConta(String nro) {
		return dadosContas.buscar(this.transformaNumero(nro));
	}

	public void salvar() {
		this.dadosContas.gravarcontas();
	}
	
	private int transformaNumero(String nro) {
		try {
			int numeroConvertido = Integer.parseInt(nro);
			return numeroConvertido;
		} catch (NumberFormatException e) {
			new Alerta("Erro ao converter de string para número. Verifique o campo preenchido!");
			return -1;
		}
	} 
}
