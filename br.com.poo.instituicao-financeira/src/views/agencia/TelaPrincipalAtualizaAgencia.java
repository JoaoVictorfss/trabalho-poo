package views.agencia;

import java.awt.BorderLayout;
import views.templates.Painel;

public class TelaPrincipalAtualizaAgencia extends javax.swing.JFrame {
    public TelaPrincipalAtualizaAgencia(){
        organizarLayout();

        setTitle("Atualizacao de Agencias");

        //Tamanho da tela
        setSize(400, 350);

        //Aplicação abre no centro da tela
        setLocationRelativeTo(null);

        //Fica Visível
        setVisible(true);
    }

    private void organizarLayout() {
        setLayout(new BorderLayout());

        Painel painelAgencia = new Painel("Atualizacao de Agencias");
        add(painelAgencia, BorderLayout.NORTH);

        TelaBuscaAgencia form = new TelaBuscaAgencia(false);
        add(form);
    }
}