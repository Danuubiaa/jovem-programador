import java.util.Scanner;
class Cliente{
    
    public String getIdentificacao(0) {

    public void exibirInformacoes(0) {


    }
}
public class CaixaEletronico {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome da conta 1: ");
        String nome1 = sc.nextLine();

        System.out.print("Nome da conta 2: ");
        String nome2 = sc.nextLine();

        System.out.println("Tipo conta 1: 1-Corrente  2-Poupança");
        int tipo1 = sc.nextInt();

        System.out.println("Tipo conta 2: 1-Corrente  2-Poupança");
        int tipo2 = sc.nextInt();

        Conta conta1 = (tipo1 == 1)
                ? new ContaCorrente(nome1, 0, 500)
                : new ContaPoupanca(nome1, 0);

        Conta conta2 = (tipo2 == 1)
                ? new ContaCorrente(nome2, 0, 500)
                : new ContaPoupanca(nome2, 0);

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 Depositar");
            System.out.println("2 Sacar");
            System.out.println("3 Transferir");
            System.out.println("4 Saldo");
            System.out.println("5 Histórico");
            System.out.println("6 Limpar Histórico");
            System.out.println("7 Rendimento");
            System.out.println("0 Sair");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Conta (1 ou 2): ");
                    int d = sc.nextInt();
                    System.out.print("Valor: ");
                    double vd = sc.nextDouble();
                    if (d == 1) conta1.depositar(vd);
                    else conta2.depositar(vd);
                    break;

                case 2:
                    System.out.print("Conta (1 ou 2): ");
                    int s = sc.nextInt();
                    System.out.print("Valor: ");
                    double vs = sc.nextDouble();
                    if (s == 1) conta1.sacar(vs);
                    else conta2.sacar(vs);
                    break;

                case 3:
                    System.out.print("Origem (1 ou 2): ");
                    int o = sc.nextInt();
                    System.out.print("Valor: ");
                    double vt = sc.nextDouble();
                    if (o == 1) conta1.transferir(conta2, vt);
                    else conta2.transferir(conta1, vt);
                    break;

                case 4:
                    System.out.print("Conta: ");
                    int c = sc.nextInt();
                    if (c == 1) conta1.exibirSaldo();
                    else conta2.exibirSaldo();
                    break;

                case 5:
                    System.out.print("Conta: ");
                    int h = sc.nextInt();
                    if (h == 1) conta1.mostrarHistorico();
                    else conta2.mostrarHistorico();
                    break;

                case 6:
                    System.out.print("Conta: ");
                    int l = sc.nextInt();
                    if (l == 1) conta1.limparHistorico();
                    else conta2.limparHistorico();
                    break;

                case 7:
                    System.out.print("Conta: ");
                    int r = sc.nextInt();
                    System.out.print("Taxa (ex: 0.02): ");
                    double taxa = sc.nextDouble();

                    if (r == 1 && conta1 instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta1).aplicarRendimento(taxa);
                    } else if (r == 2 && conta2 instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta2).aplicarRendimento(taxa);
                    } else {
                        System.out.println("Não é conta poupança!");
                    }
                    break;

                case 0:
                    System.out.println("Encerrado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
}