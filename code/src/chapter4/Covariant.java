package chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 数组是协变的，而泛型是不变的
 * 协变的后果在{@link #arrayCovariant()} 中可以看出，很不安全，有可能在编译器产生ArrayStoreException异常
 * 故在实际开发中使用List优先于数组，虽然这可能会牺牲一点性能，但换来了安全和易读，是值得的
 * </pre>
 */
public class Covariant {

    public static void main(String[] args) {
        arrayCovariant();
    }

    static void arrayCovariant() {
        String[] strArray = new String[]{"123", "abc"};
        Object[] intArray = strArray; // 发生协变
        intArray[0] = 1;    //编译通过，但运行异常：ArrayStoreException: java.lang.Integer
    }

    static void genericsCovariant() {
        List<String> strList = new ArrayList<>();
        strList.add("abc");
        //List<Object> objectList = strList;  //编译不通过，因为泛型是不变的
    }
}
