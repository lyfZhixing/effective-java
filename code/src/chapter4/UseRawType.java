package chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 不要使用原始类型
 */
public class UseRawType {

    public static void main(String[] args) {
        rawTypeList();
        objectGenerics();
    }

    /**
     * 反面实例： List使用原始类型
     * 一个List可能会放入多个不同的类型，而这个错误在编译期无法被察觉，运行时会抛异常：ClassCastException
     */
    static void rawTypeList() {
        List list = new ArrayList();
        list.add(1);
        list.add("abc");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = (Integer) iterator.next(); // ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer
        }
    }

    /**
     * 使用泛型约束可以提前暴露错误
     */
    static void genericsList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add("abc"); // 编译不通过，提前发现错误
    }

    /**
     * List<Object> 替代 List 可以增加安全性，但也不建议这么用
     */
    static void objectGenerics() {
        List<String> list = new ArrayList<>();
        unsafeAdd(list, Integer.valueOf(12));
        System.out.println(list.get(0)); // 运行时抛出异常ClassCastException，但是可以通过编译

//        safeAdd(list, Integer.valueOf(12)); // 不能通过编译  java: 不兼容的类型: java.util.List<java.lang.String>无法转换为java.util.List<java.lang.Object>
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static void safeAdd(List<Object> list, Object o) {
        list.add(o);
    }

}
