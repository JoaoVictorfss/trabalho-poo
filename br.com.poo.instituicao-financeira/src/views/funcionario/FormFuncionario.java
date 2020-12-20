package views.funcionario;

import javax.swing.*;

import models.Endereco;
import models.Funcionario;
import models.Gerente;
import views.templates.Botao;
import views.templates.Alerta;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormFuncionario extends JPanel {

    private String nomeFuncionario;
    private String cpfFuncionario;
    private Date dataNasc;
    private char sexo;
    private String endPais;
    private String endUf;
    private String endCep;
    private String endCidade;
    private String endRua;
    private int endNumero;
    private String estadoCiv;
    private Date dataAd;
    private boolean possuiCurso = true;
    private String nomeCurso;
    private double salario;
    private double bonificacao;

    private boolean valido = true;

    public FormFuncionario() {
		setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        JTextField campoNome = new JTextField("Antonio Carlos");
        JLabel nome = adicionarLabel("Nome:");
        campoNome.setPreferredSize(new Dimension(170, 30));
        add(nome);
        add(campoNome);

        JTextField campoCpf = new JTextField("52094901653");
        campoCpf.setPreferredSize(new Dimension(150, 30));
        JLabel cpf = adicionarLabel("CPF:");
        add(cpf);
        add(campoCpf);

        JTextField campoDataNasc = new JTextField("1964/06/12");
        campoDataNasc.setPreferredSize(new Dimension(120, 30));
        JLabel dataNasc = adicionarLabel("Nascimento:");
        add(dataNasc);
        add(campoDataNasc);

        JTextField campoSexo = new JTextField("M");
        campoSexo.setPreferredSize(new Dimension(150, 30));
        JLabel sexo = adicionarLabel("Sexo:");
        add(sexo);
        add(campoSexo);

        JTextField campoPais = new JTextField("Brasil");
        campoPais.setPreferredSize(new Dimension(150, 30));
        JLabel pais = adicionarLabel("País:");
        add(pais);
        add(campoPais);

        JTextField campoUf = new JTextField("MG");
        campoUf.setPreferredSize(new Dimension(150, 30));
        JLabel uf = adicionarLabel("Estado:");
        add(uf);
        add(campoUf);

        JTextField campoCep = new JTextField("38408-118");
        campoCep.setPreferredSize(new Dimension(150, 30));
        JLabel cep = adicionarLabel("CEP:");
        add(cep);
        add(campoCep);

        JTextField campoCidade = new JTextField("Uberlândia");
        campoCidade.setPreferredSize(new Dimension(150, 30));
        JLabel cidade = adicionarLabel("Cidade:");
        add(cidade);
        add(campoCidade);

        JTextField campoRua = new JTextField("Av. Rondon Pacheco");
        campoRua.setPreferredSize(new Dimension(150, 30));
        JLabel rua = adicionarLabel("Rua:");
        add(rua);
        add(campoRua);

        JTextField campoNumero = new JTextField("1500");
        campoNumero.setPreferredSize(new Dimension(150, 30));
        JLabel numero = adicionarLabel("Número:");
        add(numero);
        add(campoNumero);

        JTextField campoEstadoCiv = new JTextField("Casado");
        campoEstadoCiv.setPreferredSize(new Dimension(90, 30));
        JLabel civil = adicionarLabel("Estado Civil:");
        add(civil);
        add(campoEstadoCiv);

        JTextField campoDataAd = new JTextField("2010/06/12");
        campoDataAd.setPreferredSize(new Dimension(110, 30));
        JLabel dataAd = adicionarLabel("Data Admissão:");
        add(dataAd);
        add(campoDataAd);

        JCheckBox possuiCurso = new JCheckBox();
        possuiCurso.setSelected(true);
        possuiCurso.setPreferredSize(new Dimension(20, 20));
        JLabel curso = adicionarLabel("Possui Curso:");
        add(curso);
        add(possuiCurso);

        JTextField nomeCurso = new JTextField("Adiministração");
        nomeCurso.setPreferredSize(new Dimension(160, 30));
        JLabel cursoNome = adicionarLabel("Nome do Curso:");
        add(cursoNome);
        add(nomeCurso);

        JTextField salario = new JTextField("12000");
        salario.setPreferredSize(new Dimension(90, 30));
        JLabel salBase = adicionarLabel("Salário Base:");
        add(salBase);
        add(salario);

        JTextField bonificacao = new JTextField("200");
        bonificacao.setPreferredSize(new Dimension(90, 30));
        JLabel bonus = adicionarLabel("Bonificação:");
        add(bonus);
        add(bonificacao);

        Botao botao = new Botao("Cadastrar");
        botao.setPreferredSize(new Dimension(140, 40));
        botao.setBackground(new Color(183, 158, 20));

        add(botao);

        botao.addActionListener(event -> {

            if (naoVazio(campoNome.getText()))
                this.nomeFuncionario = campoNome.getText();
            if (naoVazio(campoCpf.getText()))
                this.cpfFuncionario = campoCpf.getText();
            if (naoVazio(campoSexo.getText()))
                transformChar(campoSexo.getText());
            if (naoVazio(campoDataNasc.getText()))
                transformaData(campoDataNasc.getText(), "Nasc");
            if (naoVazio(campoPais.getText()))
                this.endPais = campoPais.getText();
            if (naoVazio(campoUf.getText()))
                this.endUf = campoUf.getText();
            if (naoVazio(campoCep.getText()))
                this.endCep = campoCep.getText();
            if (naoVazio(campoCidade.getText()))
                this.endCidade = campoCidade.getText();
            if (naoVazio(campoRua.getText()))
                this.endRua = campoRua.getText();
            if (naoVazio(campoNumero.getText()))
                this.endNumero = transformaNumero(campoNumero.getText());
            if (naoVazio(campoEstadoCiv.getText()))
                this.estadoCiv = campoEstadoCiv.getText();
            if (naoVazio(campoDataAd.getText()))
                transformaData(campoDataAd.getText(), "Ad");
            this.possuiCurso = possuiCurso.isSelected();
            if (naoVazio(nomeCurso.getText()))
                this.nomeCurso = nomeCurso.getText();
            if (naoVazio(salario.getText()))
                this.salario = transformaStrDouble(salario.getText());
            if (naoVazio(bonificacao.getText()))
                this.bonificacao = transformaStrDouble(bonificacao.getText());
            if (this.valido) {
                cadastraFuncionario();
            }
        });
    }

    // Converte string para data
    private void transformaData(String data, String type) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date strToDate = format.parse(data);
            if(type.equals("Nasc"))
                this.dataNasc = strToDate;
            else
                this.dataAd = strToDate;
            this.valido = this.valido && true;
        } catch (ParseException e) {
            this.valido = false;
            new Alerta("Erro ao converter de string para data. Verifique se o campo está no formato válido!");
        }
    }
    
    private double transformaStrDouble(String n) {
        try {
            double numeroConvertido = Double.parseDouble(n);

            this.valido = this.valido && true;
            return numeroConvertido;
        } catch (NumberFormatException e) {
            this.valido = false;
            new Alerta("Erro ao converter de string para Double. Verifique o campo preenchido!");
            return -1;
        }
    }

    private void transformChar(String sexo){
        // Creating array of string length
        char[] charSexo = new char[sexo.length()];

        // Copy character by character into array
            charSexo[0] = sexo.charAt(0);
            this.sexo = charSexo[0];
    }

    // Converte string para número
    private int transformaNumero(String nro) {
        try {
            int numeroConvertido = Integer.parseInt(nro);

            this.valido = this.valido && true;
            return numeroConvertido;
        } catch (NumberFormatException e) {
            this.valido = false;
            new Alerta("Erro ao converter de string para número. Verifique o campo preenchido!");
            return -1;
        }
    }


    // Verifica se o campo está naoVazio
    private boolean naoVazio(String campo) {
        if (!campo.isEmpty()) {
            this.valido = this.valido && true;
            return true;
        } else {
            this.valido = false;
            return false;
        }
    }

    @SuppressWarnings("unused")
	private void cadastraFuncionario() {
        try {
            Endereco enderecoFuncionario = new Endereco(endRua, endNumero, endCep, endUf, endCidade, endPais);
            Gerente gerente = null;

            gerente = new Gerente(nomeFuncionario, cpfFuncionario, enderecoFuncionario, estadoCiv, dataNasc, dataAd, sexo, possuiCurso, nomeCurso);
            Gerente.setBonificacao(bonificacao);
            Funcionario.salBase = salario;
            
            if (gerente == null) {
            	 new Alerta("Erro. Dados incorretos! Verique todos e tente novamente");
            } else {
                MemoriaFuncionario.getInstancia().adicionarFuncionario(gerente);
                new Alerta("Sucesso. Dados cadastrados!");
            }
        } catch (RuntimeException e) {
        	 new Alerta("Erro." + e.getMessage());
        }
    }

    private JLabel adicionarLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Courier", Font.BOLD, 16));
        return label;
    }
}
