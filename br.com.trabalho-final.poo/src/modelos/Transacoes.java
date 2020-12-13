package modelos;

import java.util.Date;

public class Transacoes {
    private int id;
    // transações
    public boolean saque(double valor, Date dataTrans, Agencia agencia, int idTrans, double saldoAtual) {
        if (valor <= saldoAtual && valor > 0) {
            saldoAtual -= valor;
            return true;
        } else
            return false;// -1 como valor de erro
    }

    public boolean deposito(double valor, Date dataTrans, Agencia agencia, int idTrans, double saldoAtual) {
        if (valor > 0) {
            saldoAtual += valor;
            return true;
        } else
            return false;
    }

    public boolean transferencia(double valor, Date dataTrans, Agencia agencia, int idTrans, double saldoAtual) {
        if (valor <= saldoAtual && valor > 0) {
            saldoAtual -= valor;
            return true;
        } else
            return false;
    }
}
