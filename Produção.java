public class Produção extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Produto fabricado: " + i);            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Produção().start();
    }
}