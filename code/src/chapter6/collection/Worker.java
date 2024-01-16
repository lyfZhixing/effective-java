package chapter6.collection;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Worker {
    private final String name;
    private final EnumSet<Day> workerDays;

    public String getName() {
        return name;
    }

    public Set<Day> getWorkerDays() {
        return workerDays;
    }

    Worker(String name, EnumSet<Day> workerDays) {
        this.name = name;
        this.workerDays = workerDays;
    }

    static List<Worker> mockData(){
        return List.of(new Worker("张三", EnumSet.of(Day.MONDAY, Day.TUESDAY,Day.WEDNESDAY, Day.SATURDAY)),
                new Worker("李四", EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.THURSDAY, Day.SATURDAY)),
                new Worker("王二", EnumSet.of(Day.FRIDAY, Day.SATURDAY)),
                new Worker("赵四", EnumSet.of(Day.SUNDAY, Day.SATURDAY))
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name) && Objects.equals(workerDays, worker.workerDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workerDays);
    }
}
