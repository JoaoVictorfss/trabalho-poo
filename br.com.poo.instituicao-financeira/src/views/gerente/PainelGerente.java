package views.gerente;
import java.awt.BorderLayout;

import views.Painel;
import views.cliente.FormCliente;

public class PainelGerente extends javax.swing.JFrame {
    public PainelGerente() {
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
        Painel painelGerente = new Painel("Cadastro de gerente");
        add(painelGerente, BorderLayout.NORTH);

        FormGerente form = new FormGerente();
        add(form);

    }

    public static void main(String[] args) {
        new views.gerente.PainelGerente();
    }
}
