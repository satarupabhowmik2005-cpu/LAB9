import java.util.Scanner;

class CounterThread extends Thread {

    int lower, upper;

    CounterThread(String name, int l, int u) {
        super(name);
        lower = l;
        upper = u;
    }

    public void run() {
        try {
            System.out.println("Thread - " + getName());
            System.out.print("Counter - ");

            for (int i = lower; i <= upper; i++) {
                System.out.print(i + " ");
                Thread.sleep(5);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

 class CounterDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter thread name:");
        String name = sc.nextLine();

        System.out.println("Enter lower range:");
        int l = sc.nextInt();

        System.out.println("Enter upper range:");
        int u = sc.nextInt();

        CounterThread t1 = new CounterThread(name, l, u);
        t1.start();

        sc.close();
    }
}