public class App {
    public static void main(String[] args) throws Exception {
        Conta c1 = new Conta("", "", "78388", 100.0);
        Conta c2 = new Conta("", "", "78388", 0.0);

        System.out.println("USUARIO: " + c1.getTitular() + " SALDO: " + c1.getSaldo());
        depositar(c1, 100.0);
        System.out.println("USUARIO: " + c1.getTitular() + " SALDO: " + c1.getMostrarSaldo());
        System.out.println("-------------------------------");
        sacar(c1, 50.0);
        System.out.println("USUARIO: " + c1.getTitular() + " SALDO: " + c1.getMostrarSaldo());
        System.out.println("-------------------------------");
        transferir(c1, c2, 50.0);
        System.out.println("USUARIO: " + c2.getTitular() + " SALDO: " + c2.getMostrarSaldo());
        System.out.println("USUARIO: " + c1.getTitular() + " SALDO: " + c1.getMostrarSaldo());
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