package threadFilaBanco;

public class Banco {

    public static int saques = 0;
    public static int depositos = 0;
    public static int totalSacado = 0;
    public static int totalDepositado = 0;

    public static void main(String[] args) {
        Caixa caixa1 = new Caixa(1, 100, 5);
        Caixa caixa2 = new Caixa(2, 50, 5);
        caixa1.start();
        caixa2.start();
        try {
            caixa1.join();
            caixa2.join();
            System.out.println(String.format("Saques: %d\nDepósitos: %d", Banco.saques, Banco.depositos));
            System.out.println(String.format("Total sacado: %d\nTotal depositado: %d", Banco.totalSacado, Banco.totalDepositado));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
