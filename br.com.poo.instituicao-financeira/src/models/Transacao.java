package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao{
    private static int idTrans = 0;
    private int id;
    private Agencia agencia;
    private double valor;
    private Date dataTransacao;
    private String tipo;
    private Conta contaOr;

    public Transacao(Date dataTransacao, Conta contaOr, Agencia agencia, double valor) {
        setdataTransacao(dataTransacao);
        setAgencia(agencia);
        setValor(valor);
        this.id = Transacao.idTrans;
        this.contaOr = contaOr;
        idTrans++;
    }

    public void sacar(double valor) {
        if (contaOr.saque(valor)) {
            setdataTransacao(new Date());
            setValor(valor);
            this.tipo = "Saque";
            contaOr.adicionaTransacao(this);
        }
    }


	public void depositar(double valor) {
        if (contaOr.deposito(valor)) {
            setdataTransacao(new Date());
            setValor(valor);
            this.tipo = "Deposito";
            contaOr.adicionaTransacao(this);
        }
    }

    public void transferir(Conta contaDes, double valor) {
        if (contaOr.transferencia(valor, contaDes)) {
            setdataTransacao(new Date());
            setValor(valor);
            this.tipo = "Transferencia";
            contaOr.adicionaTransacao(this);
            contaDes.adicionaTransacao(this);
        }
    }

    
	public String getTipo() {
		return tipo;
	}
	
    public long getId() {
        return this.id;
    }

    public Date getdataTransacao() {
        return this.dataTransacao;
    }

    public void setdataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Agencia getAgencia() {
        return this.agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        if (valor >= 0)
            this.valor = valor;
        else throw new RuntimeException("Valor de transação inválido");
    }

    public String mostrarExtrato() {
        Date date = getdataTransacao();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String stringDate = DateFor.format(date);
        return  "\nId : " + getId()
                + "\nNúmero da Agência: " + agencia.getNroAgencia()
                + "\nNúmero da Conta de origem: " + contaOr.getNroConta()
                + "\nTipo de Operação: " + this.tipo
                + "\nData da Transação: " + stringDate
                + "\nValor : " + this.valor;
    }

}