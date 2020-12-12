package View;

import java.util.Date;

public class ContaPoupanca extends Conta{
		private double rendimento;
		
		public ContaPoupanca() {
			super();
			this.rendimento = 0;
		}

		public ContaPoupanca(double rendimento, int nroConta, Agencia agencia,
				Cliente cliente, char status) {
			super(nroConta, agencia, cliente, status, new Date());
			this.setRendimento(rendimento);
		}

		public ContaPoupanca(Agencia agencia, double rendimento) {
			super(agencia);
            this.setRendimento(rendimento);
		}

		public double getRendimento() {
			return rendimento;
		}

		public void setRendimento(double rendimento) {
			if(rendimento >= 0) this.rendimento = rendimento;
			else rendimento = 0;
		}
		
}
