package Counter;

public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        Countdown countdown1 = new Countdown();

        CountDownThread t1 = new CountDownThread(countdown);
        t1.setName("Thread 1");

        CountDownThread t2 = new CountDownThread(countdown1);
        t2.setName("Thread 2");

        t1.start();
        t2.start();

    }
}

class Countdown {
    private int i;
    public synchronized void doCountDown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        /*String color = switch (Thread.currentThread().getName()) {
            case "Thread 1" -> ThreadColor.ANSI_CYAN;
            case "thread 2" -> ThreadColor.ANSI_PURPLE;
            default -> ThreadColor.ANSI_GREEN;
        };*/

        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " : i = " + i);
        }
    }
}

class CountDownThread extends Thread {
    private Countdown threadCountDown;

    public CountDownThread(Countdown countdown) {
        threadCountDown = countdown;
    }

    public void run() {
        threadCountDown.doCountDown();
    }
}
