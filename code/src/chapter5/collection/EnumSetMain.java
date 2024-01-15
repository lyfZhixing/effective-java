package chapter5.collection;

import java.util.EnumSet;
import java.util.List;

public class EnumSetMain {

    public static void main(String[] args) {
        List<Worker> workers = List.of(new Worker("张三", EnumSet.of(Day.MONDAY, Day.WEDNESDAY, Day.SATURDAY)),
                new Worker("李四", EnumSet.of(Day.THURSDAY, Day.SATURDAY)),
                new Worker("王二", EnumSet.of(Day.FRIDAY, Day.SATURDAY)),
                new Worker("赵四", EnumSet.of(Day.SUNDAY, Day.SATURDAY))
        );
        System.out.printf("%s 没有人上班\n", noWorkerDay(workers));
        System.out.printf("%s 至少会有一个人来上班\n", oneWorkerDay(workers));
    }

    static EnumSet<Day> noWorkerDay(List<Worker> workers){
        EnumSet<Day> days = EnumSet.allOf(Day.class);
        for (Worker worker : workers) {
            days.removeAll(worker.getWorkerDays());
        }
        return days;
    }

    static EnumSet<Day> oneWorkerDay(List<Worker> workers){
        EnumSet<Day> days = EnumSet.noneOf(Day.class);
        for (Worker worker : workers) {
            days.addAll(worker.getWorkerDays());
        }
        return days;
    }

    static EnumSet<Day> twoWorkerDay(List<Worker> workers){
        EnumSet<Day> days = EnumSet.noneOf(Day.class);
        // todo ……
        return days;
    }


}
