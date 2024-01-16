package chapter5.mixing;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 泛型和可变参数混合使用 可能违反类型安全原则 不推荐
 */
public class MixingGenericsVarargs {

    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");     //java.lang.ClassCastException Ljava.lang.Object; cannot be cast to class [Ljava.lang.String;
        String[] attributes2 = toArray("Good", "Fast", "Cheap");

        // -----------------

    }

    /**
     * <pre>
     * 无论调用站点上传递给 pickTwo 的是什么类型的对象,这段代码都会分配一个 type Object[] 数组，保证保存这些实例的最特定的类型。
     * toArray 方法只是将这个数组返回给 pickTwo，而 pickTwo 又将这个数组返回给它的调用者，
     * 所以 pickTwo 总是返回一个 Object[] 类型的数组
     * </pre>
     *
     * @param a
     * @param b
     * @param c
     * @return
     * @param <T>
     */
    static <T> T[] pickTwo(T a, T b, T c) {
        System.out.println(a instanceof String);        // true
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    static <T> T[] toArray(T... args) {
        System.out.println(args instanceof String[]);   // attributes:false  attributes2:true
        return args;
    }

    static void dangerous(String... strings){
        int num = 42;
        Object[] objects = strings;
        objects[0] = num;
        String str = strings[0];            // java.lang.ArrayStoreException

    }

    static void dangerousList(List<String>... strings){
        List<Integer> num = List.of(42);
        Object[] objects = strings;
        objects[0] = num;
        String str = strings[0].get(0);     // java.lang.ClassCastException
    }
}
