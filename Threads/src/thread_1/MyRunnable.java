package thread_1;

import static thread_1.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Hello, I am from MyRunnable Class.");
    }
}
