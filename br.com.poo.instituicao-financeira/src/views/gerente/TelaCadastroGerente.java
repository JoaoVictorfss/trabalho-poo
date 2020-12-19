package views.gerente;
import java.awt.BorderLayout;

import views.Painel;

public class TelaCadastroGerente extends javax.swing.JFrame {
    public TelaCadastroGerente() {
        organizarLayout();

        setTitle("Cadastro de Gerente");

        // Tamanho da tela
        setSize(550, 800);

        // Aplicação abre no centro da tela
        setLocationRelativeTo(null);

        // Para finalizar a aplicação
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Fica Visível
        setVisible(true);

    }

    void organizarLayout() {
        Painel painelGerente = new Painel("Cadastro de Gerente");
        add(painelGerente, BorderLayout.NORTH);

        FormGerente form = new FormGerente();
        add(form);

    }

    public static void main(String[] args) {
        new TelaCadastroGerente();
    }
}
