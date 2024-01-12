package chapter4;

import java.util.*;

/**
 * 不要使用原始类型<br>
 * 1. 使用原始类型反面示例 {@link #rawTypeList()}<br>
 * 2. 使用泛型替代原始类型 {@link #genericsList()}<br>
 * 3. 使用Object泛型替代原始类型 {@link #objectGenerics()}<br>
 * 4. 无界通配符的使用{@link #unboundedWildcard()}<br>
 */
public class UseRawType {

    public static void main(String[] args) {
        // rawTypeList();
        // objectGenerics();
        // unboundedWildcard();
    }

    /**
     * <pre>
     * 反面实例： List使用原始类型<br>
     * 一个List可能会放入多个不同的类型，而这个错误在编译期无法被察觉，运行时会抛异常：ClassCastException
     * </pre>
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
     * 使用泛型约束可以提前暴露错误<br>
     */
    static void genericsList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        // list.add("abc"); // 编译不通过，提前发现错误
    }

    /**
     * <pre>
     *     List< Object > 替代 List 可以增加安全性，但也不建议这么用
     * </pre>
     */
    static void objectGenerics() {
        List<String> list = new ArrayList<>();
        unsafeAdd(list, Integer.valueOf(12));
        System.out.println(list.get(0)); // 运行时抛出异常ClassCastException，但是可以通过编译

        // safeAdd(list, Integer.valueOf(12)); // 不能通过编译  java: 不兼容的类型: java.util.List<java.lang.String>无法转换为java.util.List<java.lang.Object>
    }

    /**

     * <pre>
     * 无界通配符 <?> <br>
     * 1. 不能将除 null 之外的任何元素放入 Collection<?> <br>
     * 2. 无界通配符泛型可以使用instanceof 比较：
     *    list instanceof List<?>
     *    是合法的，但没有意义<br>
     * 3. 总的来说无界通配符的意义就是：<br>
     *      a.增加安全性，使集合只读，不可新增删除修改（只可以添加null）<br>
     *      b.简化API设计，有些场景下不关心集合元素的具体类型,使用无界通配符可以使API定义的更简单通用<br>
     *      c.兼容旧代码<br>
     *</pre>
     */
    static void unboundedWildcard() {
        List<?> list = new ArrayList<>(List.of(1, 2));
        list.add(null);
        // list.add(1);  // 编译不通过 Required type:capture of ? but Provided: int
        if(list instanceof List<?>){

        }
        System.out.println(list);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static void safeAdd(List<Object> list, Object o) {
        list.add(o);
    }

}
