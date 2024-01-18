package chapter7.lambdas;

import java.time.Instant;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * 主要介绍5中方法引用，以及与它们等效的λ表达式实现<br>
 * <pre>
 *     静态方法引用： {@link #staticEg()}
 *     绑定引用： {@link #boundEg()}
 *     未绑定引用： {@link #unboundEg()}
 *     构造函数引用： {@link #constructorEg()}
 *     数组构造函数引用： {@link #arrayConstructorEg()}
 * </pre>
 */
public class MethodReferencesAndLambda {

    public static void main(String[] args) {
        staticEg();
        boundEg();
        unboundEg();
        constructorEg();
        arrayConstructorEg();
    }

    /**
     * 静态方法引用
     */
    static void staticEg() {
        ToIntFunction<String> references = Integer::parseInt;           // 方法引用
        ToIntFunction<String> lambda = str -> Integer.parseInt(str);    // λ表达式

        System.out.println(references.applyAsInt("124"));
        System.out.println(lambda.applyAsInt("124"));
    }

    /**
     * 绑定引用在本质上与静态引用相似：函数对象接受与引用方法相同的参数
     */
    static void boundEg() {
        Predicate<Instant> references = Instant.now()::isAfter;         // 方法引用
        Predicate<Instant> lambda = ins -> Instant.now().isAfter(ins);         // λ表达式

        System.out.println(references.test(Instant.now().plus(1L, SECONDS)));
        System.out.println(lambda.test(Instant.now().plus(1L, SECONDS)));
    }

    /**
     * 未绑定引用中，在应用函数对象时通过方法声明参数之前的附加参数指定接收对象
     */
    static void unboundEg() {
        Function<String, String> references = String::toLowerCase;         // 方法引用
        Function<String, String> lambda = str -> str.toLowerCase();        // λ表达式

        System.out.println(references.apply("ABC"));
        System.out.println(lambda.apply("ABC"));
    }

    /**
     * 构造函数引用用作工厂对象
     */
    static void constructorEg() {
        Supplier<MethodReferencesAndLambda> references = MethodReferencesAndLambda::new;        // 方法引用
        Supplier<MethodReferencesAndLambda> lambda = () -> new MethodReferencesAndLambda();     // λ表达式

        System.out.println(references.get().getClass());
        System.out.println(lambda.get().getClass());
    }

    static void arrayConstructorEg() {
        IntFunction<MethodReferencesAndLambda[]> references = MethodReferencesAndLambda[]::new;             // 方法引用
        IntFunction<MethodReferencesAndLambda[]> lambda = len -> new MethodReferencesAndLambda[len];      // λ表达式

        System.out.println(references.apply(2).length);
        System.out.println(lambda.apply(2).length);
    }
}
