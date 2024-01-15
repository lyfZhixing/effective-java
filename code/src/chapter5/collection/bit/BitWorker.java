package chapter5.collection.bit;

public class BitWorker {
    private String name;
    private int workerDays;

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
