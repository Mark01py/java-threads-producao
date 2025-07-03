public class Intercalador {
    private int numero = 1;
    private final Object lock = new Object();

    class Thread implements Runnable {
        public void run() {
            while (numero <= 10) {
                synchronized (lock) {
                    System.out.println("A: " + numero++);
                    lock.notify();
                    try { lock.wait(); } catch (Exception e) {}
                }
            }
        }
    }

    class ThreadB implements Runnable {
        public void run() {
            while (numero <= 10) {
                synchronized (lock) {
                    System.out.println("B: " + numero++);
                    lock.notify();
                    try { lock.wait(); } catch (Exception e) {}
                }
            }
        }
    }

    public static void main(String[] args) {
        Intercalador inter = new Intercalador();
        new Produção().start();
        new Controledequalidade().start();
    }
}