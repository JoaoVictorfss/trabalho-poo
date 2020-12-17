package views.gerente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import views.Botao;

public class FormGerente extends JPanel {

    public FormGerente() {
        setBackground(new Color(220, 220, 220));
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        JTextField campoNome = new JTextField();
        ;
        JLabel nome = adicionarLabel("Nome:");
        campoNome.setPreferredSize(new Dimension(170, 30));
        add(nome);
        add(campoNome);

        JTextField campoCpf = new JTextField("111.111.111-11");
        campoCpf.setPreferredSize(new Dimension(150, 30));
        JLabel cpf = adicionarLabel("CPF:");
        add(cpf);
        add(campoCpf);

        JTextField campoDataNasc = new JTextField("dd-mm-yyyy");
        campoDataNasc.setPreferredSize(new Dimension(120, 30));
        JLabel dataNasc = adicionarLabel("Nascimento:");
        add(dataNasc);
        add(campoDataNasc);

        JTextField campoSexo = new JTextField();
        campoSexo.setPreferredSize(new Dimension(150, 30));
        JLabel sexo = adicionarLabel("Sexo:");
        add(sexo);
        add(campoSexo);

        JTextField campoPais = new JTextField();
        campoPais.setPreferredSize(new Dimension(150, 30));
        JLabel pais = adicionarLabel("País:");
        add(pais);
        add(campoPais);

        JTextField campoUf = new JTextField();
        campoUf.setPreferredSize(new Dimension(150, 30));
        JLabel uf = adicionarLabel("Estado:");
        add(uf);
        add(campoUf);

        JTextField campoCep = new JTextField();
        campoCep.setPreferredSize(new Dimension(150, 30));
        JLabel cep = adicionarLabel("CEP:");
        add(cep);
        add(campoCep);

        JTextField campoCidade = new JTextField();
        campoCidade.setPreferredSize(new Dimension(150, 30));
        JLabel cidade = adicionarLabel("Cidade:");
        add(cidade);
        add(campoCidade);

        JTextField campoRua = new JTextField();
        campoRua.setPreferredSize(new Dimension(150, 30));
        JLabel rua = adicionarLabel("Rua:");
        add(rua);
        add(campoRua);

        JTextField campoNumero = new JTextField();
        campoNumero.setPreferredSize(new Dimension(150, 30));
        JLabel numero = adicionarLabel("Número:");
        add(numero);
        add(campoNumero);

        JTextField campoEstadoCiv = new JTextField();
        campoEstadoCiv.setPreferredSize(new Dimension(90, 30));
        JLabel civil = adicionarLabel("Estado Civil:");
        add(civil);
        add(campoEstadoCiv);

        JTextField campoDataAd = new JTextField("dd-mm-yyyy");
        campoDataAd.setPreferredSize(new Dimension(110, 30));
        JLabel dataAd = adicionarLabel("Data Admissão:");
        add(dataAd);
        add(campoDataAd);

        JCheckBox possuiCurso = new JCheckBox();
        possuiCurso.setPreferredSize(new Dimension(20, 20));
        JLabel curso = adicionarLabel("Possui Curso:");
        add(curso);
        add(possuiCurso);

        JTextField nomeCurso = new JTextField();
        nomeCurso.setPreferredSize(new Dimension(160, 30));
        JLabel cursoNome = adicionarLabel("Nome do Curso:");
        add(cursoNome);
        add(nomeCurso);

        JTextField salario = new JTextField();
        salario.setPreferredSize(new Dimension(90, 30));
        JLabel salBase = adicionarLabel("Salário:");
        add(salBase);
        add(salario);

        JTextField bonificacao = new JTextField();
        bonificacao.setPreferredSize(new Dimension(90, 30));
        JLabel bonus = adicionarLabel("Bonificação:");
        add(bonus);
        add(bonificacao);

        Botao botao = new Botao("Cadastrar");
        botao.setPreferredSize(new Dimension(140, 40));
        botao.setBackground(Color.BLUE);

        add(botao);
    }

    private JLabel adicionarLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Courier", Font.BOLD, 16));
        return label;
    }
}
