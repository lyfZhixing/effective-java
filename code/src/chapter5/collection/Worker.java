package chapter5.collection;

import java.util.Set;

public class Worker {
    private String name;
    private Set<Day> workerDays;

    public String getName() {
        return name;
    }

    public Set<Day> getWorkerDays() {
        return workerDays;
    }

    Worker(String name, Set<Day> workerDays) {
        this.name = name;
        this.workerDays = workerDays;
    }
}
