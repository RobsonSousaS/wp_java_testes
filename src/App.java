import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta c1 = new Conta("Titular 1", "12345", "Agencia A", 100.0);
        Conta c2 = new Conta("Titular 2", "67890", "Agencia B", 0.0);
        Conta novaConta = null;

        int opcao;

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||                                                           ||");
        System.out.println("|| BEM VINDO AO BANCO DA PELADA, QUAL OPERACAO DESEJA FAZER? ||");
        System.out.println("|| 1° CRIAR NOVA CONTA                                       ||");
        System.out.println("|| 2° VER SALDO DE SUA CONTA                                 ||");
        System.out.println("|| 3° DEPOSITAR EM SUA CONTA                                 ||");
        System.out.println("|| 4° SACAR DE SUA CONTA                                     ||");
        System.out.println("|| 5° TRANSFERIR PARA OUTRA CONTA                            ||");
        System.out.println("|| 0° SAIR DO BANCO                                          ||");
        System.out.println("||                                                           ||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");

        do {
            System.out.println("selecione uma opcao:");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        novaConta = criarNovaConta(scanner);
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
                    System.out.println("Digite o número da conta de origem:");
                    String numeroOrigem = scanner.next();
                    Conta origem = null;

                    // Verificar se a conta de origem existe e atribuí-la à variável origem
                    if (numeroOrigem.equals(c1.getnumeroConta())) {
                        origem = c1;
                    } else if (numeroOrigem.equals(c2.getnumeroConta())) {
                        origem = c2;
                    } else {
                        System.out.println("Conta de origem não encontrada.");
                        break;
                    }

                    System.out.println("Digite o número da conta de destino:");
                    String numeroDestino = scanner.next();
                    Conta destino = null;

                    // Verificar se a conta de destino existe e atribuí-la à variável destino
                    if (numeroDestino.equals(c1.getnumeroConta())) {
                        destino = c1;
                    } else if (numeroDestino.equals(c2.getnumeroConta())) {
                        destino = c2;
                    } else {
                        System.out.println("Conta de destino não encontrada.");
                        break;
                    }

                    System.out.println("Digite o valor para transferir:");
                    double valorTransferencia = scanner.nextDouble();
                    transferir(origem, destino, valorTransferencia);
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

    public static Conta criarNovaConta(Scanner scanner) {
        System.out.println("Digite o nome do titular da nova conta:");
        String titular = scanner.next();

        System.out.println("Digite o número da nova conta:");
        String numero = scanner.next();

        System.out.println("Digite o nome da agência da nova conta:");
        String agencia = scanner.next();

        System.out.println("Digite o saldo inicial da nova conta:");
        double saldoInicial = scanner.nextDouble();

        Conta novaConta = new Conta(titular, numero, agencia, saldoInicial);
        System.out.println("Nova conta criada com sucesso!");
        return novaConta;
    }
}
