package views.funcionario;

import java.awt.BorderLayout;

import views.templates.Painel;

public class TelaCadastroFuncionario extends javax.swing.JFrame {
    public TelaCadastroFuncionario() {
        organizarLayout();

        setTitle("Cadastro de Funcionário");

        // Tamanho da tela
        setSize(550, 800);

        // Aplicação abre no centro da tela
        setLocationRelativeTo(null);

        // Fica Visível
        setVisible(true);
    }

    void organizarLayout() {
        Painel painelFuncionario = new Painel("Cadastro de Gerente");
        add(painelFuncionario, BorderLayout.NORTH);

        FormFuncionario form = new FormFuncionario(this);
        add(form);
    }
}
