class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) {
        super(titular, saldo);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {

        if (valor > 0 && saldo + limite >= valor) {
            saldo -= valor;
            historico.add("Saque (com limite): R$ " + formatar(valor));
            System.out.println("Saque realizado!");
            return true;
        } else {
            System.out.println("Saldo + limite insuficiente!");
            return false;
        }
    }
}