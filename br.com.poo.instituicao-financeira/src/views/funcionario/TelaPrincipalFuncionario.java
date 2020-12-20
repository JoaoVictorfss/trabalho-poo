package views.funcionario;
import java.awt.BorderLayout;
import java.awt.Color;
    
import javax.swing.JFrame;

import views.templates.Menu;
import views.templates.Painel;

public class TelaPrincipalFuncionario extends JFrame {
    public TelaPrincipalFuncionario() {
        organizarLayout();

        setTitle("Funcionarios");

        //Tamanho da tela
        setSize(500, 600);

        //Aplicação abre no centro da tela
        setLocationRelativeTo(null);

        //Fica Visível
        setVisible(true);
    }

    private void organizarLayout() {
        setLayout(new BorderLayout());

        Painel painelFuncionario = new Painel("Gerenciador de funcionarios");
        add(painelFuncionario, BorderLayout.NORTH);

        Menu menu = new Menu("Salvar funcionario(s)", "funcionario");
        add(menu, BorderLayout.CENTER);
    }
}
