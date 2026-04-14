interface OperacoesConta {
    void depositar(double valor);
    boolean sacar(double valor);
    boolean transferir(Conta destino, double valor);
}