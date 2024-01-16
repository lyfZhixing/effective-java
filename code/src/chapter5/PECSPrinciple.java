package chapter5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * <pre>
 * PECS原则： producer-extends,consumer-super;
 * 即: 生产者使用上界通配 extends， 消费者使用下界通配 super
 * 该原则也称之为 Get and Put 原则：get 使用 extends, put 使用 super
 * </pre>
 */
public class PECSPrinciple {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1, 5, 2, 65));
        List<Double> list2 = new ArrayList<>(List.of(3.2, 7.1, 9.1, 15.0));
        List<Number> union = union(list1, list2);
        sort(union, Comparator.comparingDouble(Number::doubleValue));
        System.out.println(union);
    }

    /**
     *
     * @param list1 生产者
     * @param list2 生产者
     * @return List<E> 消费者
     * @param <E>
     */
    public static <E> List<E> union(List<? extends E> list1, List<? extends E> list2){
        List<E> res = new ArrayList<>(list1);
        res.addAll(list2);
        return res;
    }

    /**
     *
     * @param list 生产者
     * @param comparator 消费者
     * @param <E>
     */
    public static <E> void sort(List<? extends E> list, Comparator<? super E> comparator) {
        if(Objects.isNull(list))
            return;
        list.sort(comparator);
    }


}
