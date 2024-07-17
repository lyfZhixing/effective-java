package extend.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 公平锁： 减少线程饥饿，减少线程上下文切换，并非绝对公平
 */
public class MyFairSync extends AbstractQueuedSynchronizer {

    public Integer getStatus() {
        return getState();
    }
    @Override
    public boolean tryAcquire(int arg) {
        final Thread current = Thread.currentThread();
        if (getState() == 0) {
            if (!hasQueuedPredecessors() && compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(current);
                System.out.println("第一次加锁，当前线程：" + current.getName());
                System.out.println("加锁后锁状态：" + getState() + " 当前队列长度：" + getQueueLength());
                return true;
            }
        } else if (current == getExclusiveOwnerThread()) {
            setState(getState() + 1);
            System.out.println("加锁后锁状态：" + getState() + " 当前队列长度：" + getQueueLength());
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
            System.out.println("释放后锁状态：" + getState() + " 当前队列长度：" + getQueueLength());
            if (getState() == 0) {
                setExclusiveOwnerThread(null);
            }
            return true;
        }
        return false;
    }
}
