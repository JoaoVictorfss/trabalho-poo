package views.funcionario;

import javax.swing.*;

import models.Conta;
import models.Endereco;
import models.Funcionario;
import models.Gerente;
import views.conta.MemoriaConta;
import views.templates.Botao;
import views.templates.Alerta;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormAtualizaFuncionario extends JPanel {

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
    private double salario;
    private double bonificacao;

    private JFrame telaAnt;
    private Funcionario funcionario;

    private boolean valido = true;

    public FormAtualizaFuncionario(Funcionario c, JFrame telaAtualiza) {
        this.telaAnt = telaAtualiza;
        this.funcionario = c;
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        JTextField campoNome = new JTextField(funcionario.getNome());
        JLabel nome = adicionarLabel("Nome:");
        campoNome.setPreferredSize(new Dimension(170, 30));
        add(nome);
        add(campoNome);

        JTextField campoCpf = new JTextField("52094901653");
        campoCpf.setPreferredSize(new Dimension(150, 30));
        JLabel cpf = adicionarLabel("CPF:");
        add(cpf);
        add(campoCpf);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        JTextField campoDataNasc = new JTextField(formato.format(funcionario.getDataNasc()));
        campoDataNasc.setPreferredSize(new Dimension(120, 30));
        JLabel dataNasc = adicionarLabel("Nascimento:");
        add(dataNasc);
        add(campoDataNasc);

        JTextField campoSexo = new JTextField(funcionario.getSexo());
        campoSexo.setPreferredSize(new Dimension(150, 30));
        JLabel sexo = adicionarLabel("Sexo:");
        add(sexo);
        add(campoSexo);

        JTextField campoPais = new JTextField(funcionario.getEndereco().getPais());
        campoPais.setPreferredSize(new Dimension(150, 30));
        JLabel pais = adicionarLabel("País:");
        add(pais);
        add(campoPais);

        JTextField campoUf = new JTextField(funcionario.getEndereco().getUf());
        campoUf.setPreferredSize(new Dimension(150, 30));
        JLabel uf = adicionarLabel("Estado:");
        add(uf);
        add(campoUf);

        JTextField campoCep = new JTextField(funcionario.getEndereco().getCep());
        campoCep.setPreferredSize(new Dimension(150, 30));
        JLabel cep = adicionarLabel("CEP:");
        add(cep);
        add(campoCep);

        JTextField campoCidade = new JTextField(funcionario.getEndereco().getCidade());
        campoCidade.setPreferredSize(new Dimension(150, 30));
        JLabel cidade = adicionarLabel("Cidade:");
        add(cidade);
        add(campoCidade);

        JTextField campoRua = new JTextField(funcionario.getEndereco().getRua());
        campoRua.setPreferredSize(new Dimension(150, 30));
        JLabel rua = adicionarLabel("Rua:");
        add(rua);
        add(campoRua);

        JTextField campoNumero = new JTextField(Integer.toString(funcionario.getEndereco().getNumero()));
        campoNumero.setPreferredSize(new Dimension(150, 30));
        JLabel numero = adicionarLabel("Número:");
        add(numero);
        add(campoNumero);

        JTextField campoEstadoCiv = new JTextField(funcionario.getEstadoCivil());
        campoEstadoCiv.setPreferredSize(new Dimension(90, 30));
        JLabel civil = adicionarLabel("Estado Civil:");
        add(civil);
        add(campoEstadoCiv);


        JTextField campoDataAd = new JTextField(formato.format(funcionario.getDataAd()));
        campoDataAd.setPreferredSize(new Dimension(110, 30));
        JLabel dataAd = adicionarLabel("Data Admissão:");
        add(dataAd);
        add(campoDataAd);

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

        Botao botao = new Botao("Atualizar");
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
            if (naoVazio(salario.getText()))
            	this.salario = transformaStrDouble(salario.getText());
            if (naoVazio(bonificacao.getText()))
                this.bonificacao = transformaStrDouble(bonificacao.getText());
            
            if (this.valido) {
                atualizaFuncionario();
            }else{
				new Alerta("Dados incorretos. Tente novamente!");
				this.telaAnt.dispose();
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

    private void transformChar(String sexo){
        // Creating array of string length
        char[] charSexo = new char[sexo.length()];

        // Copy character by character into array
        charSexo[0] = sexo.charAt(0);
        this.sexo = charSexo[0];
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
    private void atualizaFuncionario() {
        try {
            funcionario.setNome(this.nomeFuncionario);           
            funcionario.setCpf(this.cpfFuncionario);
            funcionario.setDataAd(this.dataAd);
            funcionario.setDataNasc(this.dataNasc);
            funcionario.setSexo(this.sexo);
            funcionario.setEstadoCivil(this.estadoCiv);
            funcionario.getEndereco().setCep(this.endCep);
            funcionario.getEndereco().setRua(this.endRua);
            funcionario.getEndereco().setCidade(this.endCidade);
            funcionario.getEndereco().setUf(this.endUf);
            funcionario.getEndereco().setNumero(this.endNumero);
            funcionario.getEndereco().setPais(this.endPais);
            
            Funcionario.salBase = this.salario;
            Gerente.setBonificacao(this.bonificacao);
            
            new Alerta("Sucesso! Funcionário cadastrado com sucesso.");
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
