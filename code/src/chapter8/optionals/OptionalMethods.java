package chapter8.optionals;

import java.util.Optional;
import java.util.stream.Stream;


/**
 * Optional 方法 <br>
 * 有几个 Optional 的方法来处理更特殊的用例：filter、map、flatMap 和 ifPresent isPresent()。在 Java 9 中，又添加了两个这样的方法：or 和 ifPresentOrElse
 */
public class OptionalMethods {

    private static final Optional<String> opStr = Optional.of("abcd\n124");
    private static final Optional<String> opStrBlank = Optional.of("");
    private static final Optional<String> opEmpty = Optional.empty();

    public static void main(String[] args) {
//        filterM();
        mapM();
        flatMapM();
        ifPresentM();
        isPresentM();
    }

    static void filterM() {
        opStrBlank.filter(String::isBlank).orElseThrow(() -> new RuntimeException("字符串为空"));
        opEmpty.filter(String::isBlank).orElseThrow(() -> new RuntimeException("字符串为空"));
    }

    static void mapM() {
        Stream<String> stringStream = opStr.map(String::lines).orElse(Stream.empty());
        stringStream.map(it -> it + "\t" + it.length()).forEach(System.out::println);
    }

    /**
     * flatMap 接受一个 入参为原类型T，出参为另一个类型的 Optional&lt;U&gt;
     */
    static void flatMapM() {
        Integer i = opStr.flatMap(str -> str.lines().map(String::length).max(Integer::compareTo)).orElse(-1);
        System.out.println(i);
    }

    /**
     * ifPresent 参数为一个 consumer 消费者 <br>
     * 如果存在则进行消费，不存在则不消费
     */
    static void ifPresentM() {
        opEmpty.ifPresent(System.out::println);
        opStrBlank.ifPresent(System.out::println);
        opStr.ifPresent(System.out::println);
    }

    static void isPresentM() {
        System.out.println(opEmpty.isPresent());
        System.out.println(opStrBlank.isPresent());
    }
}
