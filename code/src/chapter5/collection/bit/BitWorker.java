package chapter5.collection.bit;

public class BitWorker {
    private final String name;
    private final int workerDays;

    public String getName() {
        return name;
    }

    public int getWorkerDays() {
        return workerDays;
    }

    BitWorker(String name, int workerDays) {
        this.name = name;
        this.workerDays = workerDays;
    }
}
