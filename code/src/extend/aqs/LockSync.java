package extend.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class LockSync extends AbstractQueuedSynchronizer {

    @Override
    public boolean tryAcquire(int arg) {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    public boolean tryRelease(int arg) {
        if (getState() == 0) {
            System.err.println("释放锁失败");
            throw new IllegalMonitorStateException();
        }
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }
}
