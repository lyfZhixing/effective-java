package chapter6.collection;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <b>使用 EnumMap</b>
 * <pre>
 * 枚举作为key时,使用EnumMap替代HashMap有以下几个主要优点:
 * 1. 性能更好
 * EnumMap内部使用枚举常量的序号作为哈希值和索引,查询速度比HashMap快得多。
 * 2. 空间利用更高效
 * EnumMap长度只等于枚举值数量,相比HashMap使用短数组,节省空间。
 * 3. 类型更安全
 * EnumMap只接收给定枚举作为Key,比较HashMap只接受Object类型,静态类型检查更严格。
 * 4. 可读性更好
 * EnumMap键直接使用枚举实例,比HashMap使用toString()比较直观。
 * 5. 扩展性强
 * 随着枚举常量增加,EnumMap会自动扩容,不需要人工调整。
 * 6. 防止异常
 * EnumMap内部使用int索引而非Object,避免空指针和NullPointerException。
 * 7. 易于维护
 * EnumMap源码简洁,很容易理解和参考实现。
 * 所以,当Key只使用枚举值时,EnumMap相对HashMap具有性能优势和安全性优势。应首选使用EnumMap来存储枚举到值的映射关系。
 * 它优化了枚举作为Key的特定场景,是更合理高效的选择。
 * </pre>
 */
public class EnumMapMain {

    public static void main(String[] args) {

        List<Worker> workers = Worker.mockData();
        System.out.printf("%s至少会有两个人来\n", nWorkerDay(workers, 2));
        System.out.printf("%s所有人都会来，以便开会\n", nWorkerDay(workers, workers.size()));
        System.out.printf("%s周一和周二都会来\n", workersByDay(workers, EnumSet.of(Day.MONDAY, Day.TUESDAY)));
    }

    /**
     * 一周至少有n个人上班的是周几
     * @param workers
     * @param n
     * @return
     */
    static EnumSet<Day> nWorkerDay(List<Worker> workers, int n){
        EnumSet<Day> res = EnumSet.noneOf(Day.class);
        EnumMap<Day, Set<Worker>> dayListEnumMap = DayMapWorker(workers);
        dayListEnumMap.forEach((k,v) -> {
            if(v.size() >= n)
                res.add(k);
        });
        return res;
    }

    static Set<String> workersByDay(List<Worker> workers, EnumSet<Day> days) {
        Set<String> res = null;
        EnumMap<Day, Set<Worker>> dayListEnumMap = DayMapWorker(workers);
        for (Day day : days) {
            Set<String> collect = dayListEnumMap.get(day).stream().map(Worker::getName).collect(Collectors.toSet());
            if(Objects.isNull(res)) {
                res = new HashSet<>(collect);
            }
            res.retainAll(collect);
        }
        return res;
    }

    private static EnumMap<Day, Set<Worker>> DayMapWorker(List<Worker> workers){
        EnumMap<Day, Set<Worker>> enumMap = new EnumMap<>(Day.class);
        for (Day value : Day.values()) {
            enumMap.put(value, new HashSet<>());
        }
        for (Worker worker : workers) {
            for (Day workerDay : worker.getWorkerDays()) {
                Set<Worker> workerList = enumMap.get(workerDay);
                workerList.add(worker);
                enumMap.put(workerDay, workerList);
            }
        }
        return enumMap;
    }

}
