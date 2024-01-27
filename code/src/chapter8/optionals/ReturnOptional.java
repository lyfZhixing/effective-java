package chapter8.optionals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 明智地使用Optional 返回 <br>
 *
 */
public class ReturnOptional {

    public static void main(String[] args) {
        List<Integer> empty = new ArrayList<>();
        List<Integer> c = List.of(23, 235, 12, 124, 1244);
        System.out.println(max(c));
        // System.out.println(max(empty));     // java.lang.IllegalArgumentException: Empty collection

        // 使用Optional 返回值 根据调用侧业务情况自行处理
        System.out.println(maxWithOptional(c).orElse(-1));
        System.out.println(maxWithOptional(empty).orElse(-1));          // 默认返回-1
        System.out.println(maxWithOptional(empty).orElseThrow(IllegalArgumentException::new)); // 传入异常工厂，避免创建对象开销，捕获到异常后再创建对象并抛出
    }

    /**
     * 传统方式，直接抛出异常，代价较高， 因为在创建异常时捕获整个堆栈跟踪 <br>
     * 返回 null 没有这些缺点，但是它有自己的缺点。如果方法返回 null，客户端必须包含特殊情况代码来处理 null 返回的可能性 <br>
     * @param c 集合
     * @return 最大值
     * @param <E> 泛型
     */
    static <E extends Comparable<E>> E max(Collection<E> c) {
        if (Objects.isNull(c) || c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }
        E result = null;
        for (E e : c) {
            if (Objects.isNull(result) || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    /**
     * 对于非集合类型的空对象则考虑使用Optional返回，处理权交给客户端调用侧
     * @param c 集合
     * @return Optional包装的最大值
     * @param <E> 泛型
     */
    static <E extends Comparable<E>> Optional<E> maxWithOptional(Collection<E> c) {
        if (Objects.isNull(c) || c.isEmpty()) {
            return Optional.empty();
        }
        E result = null;
        for (E e : c) {
            if (Objects.isNull(result) || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return Optional.of(result);
    }
}
