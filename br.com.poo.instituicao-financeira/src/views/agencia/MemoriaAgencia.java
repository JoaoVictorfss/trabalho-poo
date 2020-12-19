package views.agencia;

import controllers.ControladorAgencia;
import models.Agencia;

public class MemoriaAgencia {
    private ControladorAgencia dadosAgencia = new ControladorAgencia();
    private static final MemoriaAgencia instancia = new MemoriaAgencia();

    public static MemoriaAgencia getInstancia() {
        return instancia;
    }

    public void adicionarAgencia(Agencia c){
        dadosAgencia.cadastrar(c);
        dadosAgencia.listar();
    }
}
