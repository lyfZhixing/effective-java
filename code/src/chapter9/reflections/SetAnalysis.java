package chapter9.reflections;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Set;

/**
 * 若需要用到在编译时无法获取的类，可以在写一个适当的接口或超类来引用该类，并用反射方式创建实例，并通过它们的接口或超类正常地访问它们<br>
 * <br>
 * <pre>
 * 这是一个创建 Set<String> 实例的程序，类由第一个命令行参数指定。程序将剩余的命令行参数插入到集合中并打印出来。
 * 不管第一个参数是什么，程序都会打印剩余的参数，并去掉重复项。
 * 然而，打印这些参数的顺序取决于第一个参数中指定的类。
 * 如果你指定 java.util.HashSet，它们显然是随机排列的；
 * 如果你指定 java.util.TreeSet，它们是按字母顺序打印的，因为 TreeSet 中的元素是有序的
 * </pre>
 *
 */
public class SetAnalysis {

    public static void main(String[] args) {

        setAnalysis(new String[]{"java.util.HashSet", "a", "e", "ee", "a", "b", "c", "a", "d", "d"});   // 无序

        setAnalysis(new String[]{"java.util.TreeSet", "a", "e", "ee", "a", "b", "c", "a", "d", "d"});   // 自然排序

        setAnalysis(new String[]{"java.util.LinkedHashSet", "a", "e", "ee", "a", "b", "c", "a", "d", "d"}); // 添加顺序


    }


    /**
     * 若需要用到在编译时无法获取的类，可以在写一个适当的接口或超类来引用该类，并用反射方式创建实例，并通过它们的接口或超类正常地访问它们<
     * @param args 输入参数 第一个为 Set的实现类全路径名， 后续参数为字符串
     */
    static void setAnalysis(String[] args){
        if (args.length < 2) {
            return;
        }

        Class<? extends Set<String>> clazz;
        String className = args[0];
        Set<String> set;
        try {
            //noinspection unchecked
            clazz = (Class<? extends Set<String>>) Class.forName(className);
            Constructor<? extends Set<String>> constructor = clazz.getDeclaredConstructor();
            set = constructor.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
        set.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(set);
    }
}
