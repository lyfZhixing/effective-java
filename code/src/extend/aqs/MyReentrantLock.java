package extend.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 可重入
 */
public class MyReentrantLock extends AbstractQueuedSynchronizer {

    public Integer getStatus() {
        return getState();
    }

    @Override
    public boolean tryAcquire(int arg) {
        if (getState() == 0 && compareAndSetState(0, 1)) {
            System.out.println("第一次加锁");
            setExclusiveOwnerThread(Thread.currentThread());
            System.out.println("加锁后锁状态：" + getState());
            return true;
        } else if (Thread.currentThread() == getExclusiveOwnerThread() && compareAndSetState(getState(), getState() + 1)) {
            System.out.println("加锁后锁状态：" + getState());
            return true;
        }
        return false;
    }

    @Override
    public boolean tryRelease(int arg) {
        if (getState() == 0 ) {
            System.err.println("释放锁失败");
            throw new IllegalMonitorStateException();
        }
        if (compareAndSetState(getState(), getState() - 1)) {
            System.out.println("释放后锁状态：" + getState());
            if (getState() == 0) {
                setExclusiveOwnerThread(null);
            }
            return true;
        }
        return false;
    }
}
