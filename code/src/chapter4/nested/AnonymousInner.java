package chapter4.nested;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * <pre>
 * 匿名内部类
 * 这的代码采用书中的源码，实现将int数组转换为 List of Integer的功能：
 * - 使用匿名内部类作为静态工厂，负责初始化 List of Integer；
 *  . 使用静态方法intArrayAsList创建对象
 *  . 内部使用匿名内部类实现对象创建细节
 *  . 外部调用只需调用方法而无需关心实现
 * - intArrayAsList()同时也是一个适配器（Adapter）数组到List；
 * 常见用法：
 * 1. 静态工厂
 * 2. 在 lambda 表达式被添加到 Java之前，匿名类是动态创建小型函数对象和进程对象的首选方法，但 lambda 表达式现在是首选方法
 * </pre>
 */
public class AnonymousInner {

    public static void main(String[] args) {
        List<Integer> integers = intArrayAsList(new int[]{1, 2, 4, 5});
        System.out.println(integers);
    }

    /**
     * 将int数组转换为 List of Integer
     * 静态工厂
     * @param a
     * @return
     */
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);
        // The diamond operator is only legal here in Java 9 and later
        // If you're using an earlier release, specify <Integer>
        return new AbstractList<>() {
            @Override
            public Integer get(int i) {
                return a[i]; // Autoboxing (Item 6)
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val; // Auto-unboxing
                return oldVal; // Autoboxing
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
