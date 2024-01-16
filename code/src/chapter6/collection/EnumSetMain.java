package chapter6.collection;

import java.util.EnumSet;
import java.util.List;

/**
 * <pre>
 * <b>用 EnumSet 替代位字段</b>
 * <pre>
 * EnumSet使用ordinal()值作为bit位的索引
 * 通过修改对应位来标识包含的枚举值
 * 访问某个枚举时使用ordinal()获取其在EnumSet中的位置
 * </pre>
 * 1. 类型安全
 *      EnumSet只允许添加枚举值,不允许添加其他非法元素。而位字段可以直接设置为任意int值,较不安全。
 * 2. 可读性好
 * 3. 扩展性强
 *      新增枚举值只需添加枚举常量,EnumSet会自动支持。位字段需要修改掩码和相关逻辑。
 * 4. 支持高级操作
 *      EnumSet提供并集、交集、差集等集合运算,性能很好。位字段需要手动实现这些操作
 * 5. 语义更清晰
 * </pre>
 *
 * 相同功能的位字段实现： {@link chapter6.collection.bit.BitWorkerMain}
 *
 */
public class EnumSetMain {

    public static void main(String[] args) {
        List<Worker> workers = Worker.mockData();
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

}
