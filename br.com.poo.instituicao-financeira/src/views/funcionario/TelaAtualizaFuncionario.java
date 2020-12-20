package views.funcionario;

import java.awt.BorderLayout;

import models.Funcionario;
import views.templates.Painel;

public class TelaAtualizaFuncionario extends javax.swing.JFrame {
    private Funcionario c;

    public TelaAtualizaFuncionario(Funcionario funcionario) {
        this.c = funcionario;


        organizarLayout();

        setTitle("Atualização de Funcionario");

        // Tamanho da tela
        setSize(550, 780);

        // Aplicação abre no centro da tela
        setLocationRelativeTo(null);

        // Fica Visível
        setVisible(true);

    }

    void organizarLayout() {
        Painel painelFuncionario = new Painel("Atualização de Funcionario");
        add(painelFuncionario, BorderLayout.NORTH);

        FormAtualizaFuncionario form = new FormAtualizaFuncionario(this.c, this);
        add(form);
    }
}
