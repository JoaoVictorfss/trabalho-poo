package views.conta;
import java.awt.BorderLayout;
import java.awt.Color;

import views.templates.Painel;

public class TelaCadastroContaPoup extends javax.swing.JFrame {
    public TelaCadastroContaPoup() {
        organizarLayout();

        setTitle("Cadastro de Conta");

        // Tamanho da tela
        setSize(550, 550);

        // Aplicação abre no centro da tela
        setLocationRelativeTo(null);

        // Para finalizar a aplicação
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Fica Visível
        setVisible(true);
    }

    void organizarLayout() {
        Painel painelConta = new Painel("Cadastro de Conta Poupança");
        add(painelConta, BorderLayout.NORTH);

        FormContaPoupanca form = new FormContaPoupanca();
        add(form);
    }

    public static void main(String[] args) {
        new TelaCadastroContaPoup();
    }
}