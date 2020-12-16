package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {
    private static int idCont;
    private int id;
    private Date dataTransacao;
    private String tipoTransacao;
    private double valorTransacao;
    private Agencia agencia;
    private Conta contaDestino;

    public Transacao(Date dataTransacao, String tipoTransacao, double valorTransacao, Agencia agencia) {
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.agencia = agencia;
        Transacao.idCont++;
        this.id = idCont;
    }

    public Transacao(Date dataTransacao, String tipoTransacao, double valorTransacao, Agencia agencia, Conta contaDestino) {
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.agencia = agencia;
        this.contaDestino = contaDestino;
        Transacao.idCont++;
        this.id = idCont;
    }

    public String toString() {
        Date date = getDataTransacao();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String stringDate = DateFor.format(date);
        return "______________________________________"
                + "\nExtrato"
                + "\nId : " + getId()
                + "\nAgência : " + getAgencia().getNroAgencia()
                + "\nOperação : " + getTipoTransacao()
                + "\nData : " + stringDate
                + "\nValor : " + getValorTransacao()
                + "\n______________________________________";
    }

    public static int getIdCont() {
        return idCont;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

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
