package views.conta;
import java.awt.BorderLayout;
import java.awt.Color;

import views.templates.Painel;

public class TelaCadastroConta extends javax.swing.JFrame {
    public TelaCadastroConta() {
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
        Painel painelConta = new Painel("Cadastro de Conta");
        add(painelConta, BorderLayout.NORTH);

        FormContaSalario form = new FormContaSalario();
        add(form);
    }

    public static void main(String[] args) {
        new TelaCadastroConta();
    }
}