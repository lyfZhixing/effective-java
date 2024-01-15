package chapter4.heterogeneous;

import java.beans.BeanProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 类型安全的异构容器<br>
 * spring 中的IOC容器也可以看作一种松散耦合的异构容器
 */
public class Favorites {

    private final Map<Class<?>, Object> favorites = new HashMap<>();

    @BeanProperty(expert = true)
    public <T> void putFavorite(Class<T> type, T instance){
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    /**
     * <pre>
     * 该方法能够使 Favorites 类型安全，而不需要对 T 进行 unchecked 的转换
     * favorites.get(type)是 Object（favorites 的值类型），但我们需要返回一个 T。
     * getFavorite 的实现通过使用 Class 的 cast 方法，将对象引用类型动态转化为所代表的 Class 对象
     * cast 方法是 Java 的 cast 运算符的动态模拟。它只是检查它的参数是否是类对象表示的类型的实例。如果是，则返回参数；否则它将抛出 ClassCastException
     * </pre>
     * @param type
     * @return
     * @param <T>
     */
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
