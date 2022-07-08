package thread_1;

import static thread_1.ThreadColor.*;

public class Thread_1 {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello from the Main.");

        Thread anotherThread1 = new AnotherThread();
        anotherThread1.setName(" -anotherThread1--");
        anotherThread1.start();
//        anotherThread1.run();
        // Anonymous class
        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN+"Hello from the anonymous class thread");
            }
        }.start();
        // Another and better way of Anonymous method
       // new Thread(() -> System.out.println(ANSI_GREEN+"Hello from the anonymous class thread")).start();

        Thread myRunnable = new Thread(new MyRunnable(){
            @Override
            public void run(){
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run.");
                try{
                    anotherThread1.join();
                    System.out.println(ANSI_RED+"AnotherThread1 terminated or timed out,so I am running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED+"I couldn't wait after all.I was interrupted.");
                }
            }
        });
        myRunnable.start();

        System.out.println("After another, I am from Main.");

    }
}
