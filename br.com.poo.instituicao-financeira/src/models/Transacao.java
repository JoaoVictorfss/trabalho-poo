package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {
    private static int id;
    private Date dataTransacao;
    private String tipoTransacao;
    private double valorTransacao;
    private Agencia agencia;

    public Transacao(Date dataTransacao, String tipoTransacao, double valorTransacao, Agencia agencia) {
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.agencia = agencia;
        Transacao.id++;
    }

    public String toString() {
        Date date = getDataTransacao();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String stringDate = DateFor.format(date);
        return "\nExtrato"
                + "\nId : " + getId()
                + "\nAgência : " + getAgencia().getNroAgencia()
                + "\nTipo de Operação : " + getTipoTransacao()
                + "\nData : " + stringDate
                + "\nValor : " + getValorTransacao()
                + "\n______________________________________";
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public int getId() {
        return Transacao.id;
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
