package threadFilaBanco;

public class Caixa extends Thread {

    private int id;
    private int saldo;
    private int qtdClientes;

    public Caixa(int id, int saldoInicial, int qtdClientes) {
        this.id = id;
        this.saldo = saldoInicial;
        this.qtdClientes = qtdClientes;
    }

    @Override
    public void run() {
        System.out.println("Caixa " + this.id + " começou a operar.");
        for (int i = 0; i < this.qtdClientes; i++) {
            int randomValue = geraInteiroAleatorio(1, 50);
            int opcao = binariaAleatoria();
            if (opcao == 0) { // Saque
                if (this.saldo < randomValue) {
                    System.out.println(
                            String.format("Cliente %d tentou sacar %d mas caixa %d só tinha %d de saldo", i, randomValue, this.id, this.saldo));
                } else {
                    System.out.println(
                            String.format("Cliente %d sacou %d de caixa %d. Saldo: %d -> %d", i, randomValue, this.id, this.saldo, this.saldo - randomValue));
                    this.saldo -= randomValue;
                }
                Banco.saques++;
            } else { // Deposito
                this.saldo += randomValue;
                System.out.println(
                        String.format("Cliente %d depositou %d em caixa %d. Saldo: %d -> %d", i, randomValue, this.id, this.saldo, this.saldo + randomValue));
                Banco.depositos++;
            }
        }
    }

    private static int binariaAleatoria() {
        return (int) Math.round(Math.random());
    }

    private static int geraInteiroAleatorio(int a, int b) {
        return (int) Math.round(Math.random() * (b - a)) + a;
    }
}
