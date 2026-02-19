class Table {
    // synchronized locks the 'obj' so threads don't mix their outputs
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            // This prints: "Number " (satisfying the trailing space requirement)
            System.out.print(n * i + " ");
            try {
                Thread.sleep(400); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        // Newline is inside the lock to prevent the next thread 
        // from starting on the same line.
        System.out.println(); 
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

        // Starting both simultaneously to let the monitor lock manage the queue
        t1.start();
        t2.start();
    }
}