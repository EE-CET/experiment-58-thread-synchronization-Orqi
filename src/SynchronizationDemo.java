class Table {
    // synchronized ensures one thread finishes its loop before the other starts
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i);
            // Only add a space if it's not the last number in the sequence
            if (i < 5) {
                System.out.print(" ");
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(); // Move to the next line after the table is done
    }
}

class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) { this.t = t; }
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) { this.t = t; }
    public void run() {
        t.printTable(100);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        Table obj = new Table();

        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        t1.start();
        t2.start(); 
        // We start both; 'synchronized' handles the "one-at-a-time" rule.
    }
}