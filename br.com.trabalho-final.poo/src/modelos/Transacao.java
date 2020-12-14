package modelos;

import java.util.Date;

/*
 * @desc Classe utilizada na classe Conta para fazer uma operação bancária
 */
public class Transacao {
    private static int id;
    private Date dataTransacao;
    private String tipoTransacao;
    private double valorTransacao;
    private Agencia agencia;
    private Conta contaDestino;

    //constructor
    public Transacao(Date dataTransacao, String tipoTransacao, double valorTransacao, Agencia agencia) {
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.agencia = agencia;
        Transacao.id++;
    }

    public Transacao(Date dataTransacao, String tipoTransacao, double valorTransacao, Agencia agencia, Conta contaDestino) {
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.agencia = agencia;
        this.contaDestino = contaDestino;
        Transacao.id++;
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

}
