package views.funcionario;

import java.awt.BorderLayout;

import views.Painel;

public class PainelFuncionario extends javax.swing.JFrame {
    public PainelFuncionario() {
        organizarLayout();

        setTitle("Cadastro de Funcionário");

        // Tamanho da tela
        setSize(550, 720);

        // Aplicação abre no centro da tela
        setLocationRelativeTo(null);

        // Para finalizar a aplicação
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Fica Visível
        setVisible(true);
    }

    void organizarLayout() {
        Painel painelFuncionario = new Painel("Cadastro de funcionários");
        add(painelFuncionario, BorderLayout.NORTH);

        FormFuncionario form = new FormFuncionario();
        add(form);

    }

    public static void main(String[] args) {
        new PainelFuncionario();
    }
}
