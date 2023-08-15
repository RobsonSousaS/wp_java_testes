import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta c1 = new Conta("Titular 1", "12345", "Agencia A", 100.0);
        Conta c2 = new Conta("Titular 2", "67890", "Agencia B", 0.0);

        int opcao;

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|| BEM VINDO AO BANCO DA PELADA, QUAL OPERACAO DESEJA FAZER? ||");
        System.out.println("|| 1° CRIAR NOVA CONTA                                       ||");
        System.out.println("|| 2° VER SALDO DE SUA CONTA                                 ||");
        System.out.println("|| 3° DEPOSITAR EM SUA CONTA                                 ||");
        System.out.println("|| 4° SACAR DE SUA CONTA                                     ||");
        System.out.println("|| 5° TRANSFERIR PARA OUTRA CONTA                            ||");
        System.out.println("|| 0° SAIR DO BANCO                                          ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");

        do {
            System.out.println("selecione uma opcao:");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("SERA ADICIONADO EM UMA VERSAO POSTERIOR, PEDIMOS DESCULPAS!");
                        break;
                    case 2:
                        System.out.println(c1.getSaldo());
                        break;
                    case 3:
                        System.out.println("Digite o valor para depositar:");
                        double valorDeposito = scanner.nextDouble();
                        depositar(c1, valorDeposito);
                        break;
                    case 4:
                        System.out.println("Digite o valor para sacar:");
                        double valorSaque = scanner.nextDouble();
                        sacar(c1, valorSaque);
                        break;
                    case 5:
                        System.out.println("Digite o valor para transferir:");
                        double valorTransferencia = scanner.nextDouble();
                        transferir(c1, c2, valorTransferencia);
                        break;
                    case 0:
                        System.out.println("Saindo do banco. Obrigado!");
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, seleciona um opcao da nossa lista.");
                scanner.next();
                opcao = -1;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public static void sacar(Conta conta, double valor) {
        conta.sacar(valor);
    }

    public static void transferir(Conta origem, Conta destino, double valor) {
        origem.transferir(destino, valor);
    }
}
