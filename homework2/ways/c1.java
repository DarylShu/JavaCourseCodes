package java0;

public class c1 {
    public static void main(String[] args) {

        System.out.println("-------work------start---------");

        LockHandler mHandler = new LockHandler();

        Thread mThread = new Thread(new WorkRunnable(mHandler));

        mThread.setDaemon(true);

        mThread.start();

        mHandler.waitForDebug();

        System.out.println("-------work------end---------");

    }

    public static class WorkRunnable implements Runnable {

        public LockHandler mHandler;

        public WorkRunnable(LockHandler mHandler) {

            this.mHandler = mHandler;

        }

        public void run() {

//TODO

            try {

                Thread.sleep(5000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println("-------我在异步线程中睡了五秒---------");

            mHandler.notifytForDebug();

        }

    }

    public static class LockHandler {

        public synchronized void waitForDebug() {

            try {

                this.wait();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

        public synchronized void notifytForDebug() {

            this.notifyAll();

        }

    }

}

