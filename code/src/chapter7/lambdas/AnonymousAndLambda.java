package chapter7.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 对比匿名类，λ表达式，方法引用 <br>
 * 总结： 方法引用优于 λ表达式 优于 匿名类(如果方法引用更短、更清晰，则使用它们；如果没有，仍然使用 lambda 表达式)<br>
 * λ表达式和匿名类的对比还可以参考: <br>
 * {@link chapter6.strategy.PayrollDayStrategy} 和 {@link chapter6.strategy.PayrollDayStrategyLambda}
 */
public class AnonymousAndLambda {

    public static void main(String[] args) {
        List<String> list = List.of("abc", "d", "efga", "agbcsd");
        System.out.println(anonymousImpl(new ArrayList<>(list)));
        System.out.println(lambdasImpl(new ArrayList<>(list)));
        System.out.println(methodReferencesImpl(new ArrayList<>(list)));
    }

    /**
     * 匿名类实现按字符串长度排序
     * @param list
     */
    static List<String> anonymousImpl(List<String> list){
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return list;
    }

    /**
     * lambda实现按字符串长度排序
     * @param list
     */
    static List<String> lambdasImpl(List<String> list){
        list.sort((o1, o2) -> o1.length() - o2.length());
        return list;
    }

    /**
     * 方法引用实现按字符串长度排序
     * @param list
     */
    static List<String> methodReferencesImpl(List<String> list){
        list.sort(Comparator.comparingInt(String::length));
        return list;
    }
}
