package views.agencia;

import controllers.ControladorAgencia;
import models.Agencia;
import models.Funcionario;
import views.templates.Alerta;

public class MemoriaAgencia {
    private ControladorAgencia dadosAgencias = new ControladorAgencia();
    private static final MemoriaAgencia instancia = new MemoriaAgencia();

    public static MemoriaAgencia getInstancia() {
        return instancia;
    }

    public void adicionarAgencia(Agencia c){
        dadosAgencias.cadastrar(c);
    }
    
    public void exluirAgencia(String nro) {
		dadosAgencias.excluir(this.transformaNumero(nro));
	}
	
	public Agencia buscaAgencias(String nro) {
		return dadosAgencias.buscar(this.transformaNumero(nro));
	}

	public void salvar() {
		this.dadosAgencias.gravarAgencias();
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
