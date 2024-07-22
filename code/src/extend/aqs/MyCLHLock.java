package extend.aqs;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CLH 队列 简单实现
 */
public class MyCLHLock {

    private final ThreadLocal<Node> prev;
    private final ThreadLocal<Node> node;
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    public MyCLHLock() {
        this.node = ThreadLocal.withInitial(Node::new);
        this.prev = ThreadLocal.withInitial(() -> null);
    }

    public void lock() {
        final Node node = this.node.get();
        node.locked = true;
        Node pred = this.tail.getAndSet(node);
        this.prev.set(pred);
        while (pred.locked) {
            try {
                // 线程休眠 方便控制台观察
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("自旋中……");
        }
    }

    public void unlock() {
        final Node node = this.node.get();
        node.locked = false;
        this.node.set(this.prev.get());
    }


    private static class Node {
        private volatile boolean locked = false;
    }
}
