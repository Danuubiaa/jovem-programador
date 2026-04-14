class ContaPoupanca extends Conta {

    public ContaPoupanca(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            historico.add("Saque: R$ " + formatar(valor));
            System.out.println("Saque realizado!");
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    public void aplicarRendimento(double taxa) {
        double rendimento = saldo * taxa;
        saldo += rendimento;

        historico.add("Rendimento: R$ " + formatar(rendimento));
        System.out.println("Rendimento aplicado!");
    }
}