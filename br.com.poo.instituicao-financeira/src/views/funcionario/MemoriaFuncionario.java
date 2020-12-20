package views.funcionario;

import controllers.ControladorFuncionario;
import models.Funcionario;

public class MemoriaFuncionario {
    private ControladorFuncionario dadosFuncionario = new ControladorFuncionario();
    private static final MemoriaFuncionario instancia = new MemoriaFuncionario();

    public static MemoriaFuncionario getInstancia() {
        return instancia;
    }

    public void adicionarFuncionario(Funcionario c){
        dadosFuncionario.cadastrar(c);
    }
    
	public void exluirFuncionario(String cpf) {
		dadosFuncionario.excluir(cpf);
	}
	
	public Funcionario buscaCliente(String cpf) {
		return dadosFuncionario.buscar(cpf);
	}

	public void salvar() {
		this.dadosFuncionario.gravarFuncionarios();
	}
}
