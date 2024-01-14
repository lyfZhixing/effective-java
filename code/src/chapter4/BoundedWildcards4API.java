package chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 使用有界通配符增加API的灵活性
 * 在 API 中使用通配符类型虽然很棘手，但可以使其更加灵活。如果你编写的库将被广泛使用，则必须考虑通配符类型的正确使用
 * </pre>
 */
public class BoundedWildcards4API {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4));
        swap(integers, 1, 2);       // 正常编译
        swapE(integers, 1, 2);      // 正常编译

        List list = new ArrayList();
        list.add("a");
        list.add(1);
        list.add("b");
        list.add(2);
        swapE(list, 1, 2);          // Unchecked assignment: 'java.util.List' to 'java.util.List<java.lang.Object>'
        System.out.println(list);
        swap(list, 1, 2);           // 正常编译
        System.out.println(list);

    }

    /**
     * 使用通配符和泛型,让公共API可以更通用且类型安全,同时内部实现可以利用泛型信息进行更高效的操作
     * @param list
     * @param i
     * @param j
     */
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static <E> void swapE(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
