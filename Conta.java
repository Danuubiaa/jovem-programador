import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

abstract class Conta implements OperacoesConta {

    protected String titular;
    protected double saldo;
    protected List<String> historico = new ArrayList<>();

    protected String formatar(double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valor);
    }

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        historico.add("Conta criada com saldo: R$ " + formatar(saldo));
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add("Depósito: R$ " + formatar(valor));
            System.out.println("Depósito realizado!");
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            destino.saldo += valor;

            historico.add("Transferência enviada: R$ " + formatar(valor));
            destino.historico.add("Transferência recebida: R$ " + formatar(valor));

            System.out.println("Transferência realizada!");
            return true;
        } else {
            System.out.println("Erro na transferência!");
            return false;
        }
    }

    public abstract boolean sacar(double valor);

    public void exibirSaldo() {
        System.out.println("\nTitular: " + titular);
        System.out.println("Saldo: R$ " + formatar(saldo));
    }

    public void mostrarHistorico() {
        System.out.println("\nHISTÓRICO:");
        for (String h : historico) {
            System.out.println(h);
        }
    }

    public void limparHistorico() {
        historico.clear();
        historico.add("Histórico limpo.");
        System.out.println("Histórico apagado!");
    }
}