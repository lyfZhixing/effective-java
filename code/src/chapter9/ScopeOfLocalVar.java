package chapter9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 局部变量 最小化 <br>
 * 循环提供了一个特殊的机会来最小化变量的范围{@link #removeByFor(List)} <br>
 * 对比while遍历{@link #removeByWhile(List)} for循环显然更安全一些
 */
public class ScopeOfLocalVar {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("abc", "def", "opq", "qwer", "zxcv"));
        System.out.println(removeByFor(list));

        List<String> list2 = new ArrayList<>(List.of("abc", "def", "opq", "qwer", "zxcv"));
        System.out.println(removeByWhile(list2));
    }

    static List<String> removeByFor(List<String> list) {

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            System.out.println(next);
            if (next.length() > 3) iterator.remove();
        }
        return list;
    }

    /**
     * 局部变量 i ({@code Iterator<String> i = list.iterator();}) 的作用域没有控制到最小 <br> <br>
     * 导致的结果： 第二次使用while遍历时，由于疏忽将 i2 错写成 i ，编译器不会报错，但是程序运行不会给出预期结果 <br>
     * <pre>
     * {@code
     * Iterator<String> i2 = list.iterator();
     * while (i.hasNext()) }
     * </pre>
     * @param list 字符串集合
     * @return 处理后的字符串集合
     */
    static List<String> removeByWhile(List<String> list) {

        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            String next = i.next();
            System.out.println(next);
            if (next.length() > 3) i.remove();
        }

        Iterator<String> i2 = list.iterator();
        while (i.hasNext()) {       // bug 由于局部变量 i 定义的范围过大， 此处将 i2 错写 为 i ，编译器并不会报错，但是运行时无法给出预期结果。
            String next = i2.next();
            System.out.println(next);
            if (next.length() > 3) i2.remove();
        }
        return list;
    }
}
