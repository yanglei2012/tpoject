package four;

import untils.SleepUntils;
import untils.TimeUntils;

/**
 * Created by Administrator on 2017/4/15.
 */
public class Join {
    public static void main(String[] args) {
        Thread previous=Thread.currentThread();
        for (int i=0;i<10;i++){
            Thread thread=new Thread(new Domino(previous),"----"+String.valueOf(i));
            thread.start();
            previous=thread;
        }
        SleepUntils.second(5);
        System.out.println("结束"+Thread.currentThread().getName());
    }

    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SleepUntils.second(2);
            System.out.println(Thread.currentThread().getName()+"at"+TimeUntils.getCurrentTime());
        }
    }
}
