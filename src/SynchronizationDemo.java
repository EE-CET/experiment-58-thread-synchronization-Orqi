class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }
        }
    }
}

class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) { this.t = t; }

    public void run() {
        t.printTable(5);
        System.out.print("\n"); // newline only after first
    }
}

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) { this.t = t; }

    public void run() {
        t.printTable(100);
        System.out.print(" "); // <-- IMPORTANT trailing space
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) throws Exception {
        Table obj = new Table();

        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        t1.start();
        t1.join();

        t2.start();
        t2.join();
    }
}