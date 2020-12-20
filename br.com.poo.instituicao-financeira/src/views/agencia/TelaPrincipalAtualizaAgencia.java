package views.agencia;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

import views.cliente.TelaBuscaCliente;
import views.templates.Menu;
import views.templates.Painel;

public class TelaPrincipalAtualizaAgencia extends JFrame {
    public TelaPrincipalAtualizaAgencia(){
        organizarLayout();

        setTitle("Atualizacao de Agencias");

        //Tamanho da tela
        setSize(500, 600);

        //Aplicação abre no centro da tela
        setLocationRelativeTo(null);

        //Fica Visível
        setVisible(true);
    }

    private void organizarLayout() {
        setLayout(new BorderLayout());

        Painel painelAgencia = new Painel("Atualizacao de agencias");
        add(painelAgencia, BorderLayout.NORTH);

        TelaBuscaAgencia form = new TelaBuscaAgencia(false);
        add(form);
    }
}