package thread_1;

import static thread_1.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println( ANSI_BLUE+"Hello from "+currentThread().getName());

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }
        System.out.println(ANSI_BLUE + "Done with 3-second sleeping");

    }
}
