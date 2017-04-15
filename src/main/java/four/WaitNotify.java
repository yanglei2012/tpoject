package four;

import untils.SleepUntils;
import untils.TimeUntils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/15.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] arg) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true.Wait1 " + TimeUntils.getCurrentTime());
                        lock.wait();
                    } catch (Exception ex) {

                    }
                    System.out.println(Thread.currentThread() + " flag is false.Wait2 " + TimeUntils.getCurrentTime());
                }
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " flag is true.Notify1 " + TimeUntils.getCurrentTime());
                lock.notifyAll();
                flag = false;
                SleepUntils.second(5);
                System.out.println(Thread.currentThread() + " flag is false.Notify2 " + TimeUntils.getCurrentTime());
                SleepUntils.second(5);
            }
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "lockAgain " + TimeUntils.getCurrentTime());
                SleepUntils.second(5);
            }
        }
    }
}
