package chapter4.mixing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <pre>
 * 一个通用的可变参数方法是安全的前提是：
 * 1. 没有在可变参数数组中存储任何东西
 * 2. 不会让数组（或者其副本）出现在不可信的代码中
 * </pre>
 */
public class SafeVarargsUse {

    public static void main(String[] args) {
        List<String> list = pickTwoList("Good", "Fast", "Cheap");
        System.out.println(list);
    }

    static <T> List<T> pickTwoList(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toList(a, b);
            case 1: return toList(a, c);
            case 2: return toList(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    /**
     * SafeVarargs 注释仅对不能覆盖的方法合法(static   private  final)，因为不可能保证所有可能覆盖的方法都是安全的<br>
     * 在 Java 8 中，注释仅对静态方法和最终实例方法合法；在 Java 9 中，它在私有实例方法上也成为合法的。
     * @param args
     * @return
     * @param <T>
     */
    @SafeVarargs
    static <T> List<T> toList(T... args) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            list.add(args[i]);
        }
        return list;
    }

}
