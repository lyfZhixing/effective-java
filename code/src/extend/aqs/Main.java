package extend.aqs;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Main {

    @org.junit.Test
    public  void testLockSync() {
        LockSync lockSync = new LockSync();
        for (int i = 0; i < 100; i++) {
            lockSync.acquire(1);
            int finalI = i;
            new Thread(() -> {
                System.out.println(finalI + "");
                lockSync.release(1);
            }).start();
        }
    }

    @org.junit.Test
    public void testReentrantLock() throws InterruptedException {
        MyReentrantLock lock = new MyReentrantLock();
        Integer a = 0;
        递归示例(lock, a);

    }

    @org.junit.Test
    public void testMyFairSync() throws InterruptedException {
        MyFairSync lock = new MyFairSync();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                递归示例(lock, 0);
            }, "Thread-" + i).start();
        }
        Thread.sleep(9000L);
    }

    public <T extends AbstractQueuedSynchronizer> void 递归示例(T lock, Integer a) {
        if (a == 2) {
            return;
        }
        lock.acquire(1);
        try {
            递归示例(lock, a + 1);
        } finally {
            lock.release(1);
        }

    }
}
