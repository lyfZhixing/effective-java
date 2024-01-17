package chapter6.interfaces;

import java.util.Collection;
import java.util.EnumSet;

/**
 * 虽然不能编写可扩展枚举类型，但可以通过编写接口来模拟它，该接口与实现该接口的基本枚举类型一起编写。<br>
 * 这允许客户端编写自己的枚举(或其他类型)来实现接口。<br>
 * <pre>
 * jdk源码示例： {@link java.nio.file.LinkOption} 实现了{@link java.nio.file.OpenOption},{@link java.nio.file.CopyOption}两个操作接口
 * </pre>
 */
public class OperationMain {

    public static void main(String[] args) {

        test(ExtendedOperation.class, 1.2, 2.5);

        testCollection(EnumSet.allOf(ExtendedOperation.class), 1.2, 2.5);
    }

    /**
     * 使用 泛型 <T extends Enum<T> & Operation> 可以使方法内使用EnumSet，EnumMap等枚举独有的能力；<br>
     * 也对枚举参数产生约束：必修实现 {@link Operation} 接口
     * @param opEnumType
     * @param x
     * @param y
     * @param <T>
     */
    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y){
        /*
        EnumSet<T> ts = EnumSet.noneOf(opEnumType);         // 有使用 EnumSet 的能力，当然这里的逻辑没有使用
        EnumMap<T, Object> tm = new EnumMap<>(opEnumType);  // 有使用 EnumMap 的能力，当然这里的逻辑没有使用
         */

        for (T op : opEnumType.getEnumConstants()) {
            double res = op.apply(x, y);
            System.out.printf("%s %s %s = %s\n", x, op, y, res);
        }
    }

    /**
     * 对比 {@link #test(Class, double, double)} 方法，这里使用泛型 <T extends Operation> 就没有使用EnumSet EnumMap 等能力
     * @param opSet
     * @param x
     * @param y
     * @param <T>
     */
    private static <T extends Operation> void testCollection(Collection<T> opSet, double x, double y){
        for (T op : opSet) {
            double res = op.apply(x, y);
            System.out.printf("%s %s %s = %s\n", x, op, y, res);
        }
    }
}
