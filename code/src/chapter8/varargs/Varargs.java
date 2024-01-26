package chapter8.varargs;

import java.util.Arrays;
import java.util.EnumSet;

/**
 * 可变参数得使用 <br>
 *  <pre>
 * 使用可变参数会损失性能，因为每次调用可变参数都会导致数组分配和初始化
 *    解决方案：
 *      假设你已经确定对方法 95% 的调用只需要三个或更少的参数。可以声明该方法的 5 个重载，每个重载 0 到 3 个普通参数，当参数数量超过 3 个时引入可变参数
 *      {@link EnumSet} 的静态工厂使用这种技术将创建枚举集的成本降到最低。这是适当的，因为 enum 集合为位字段提供具有性能竞争力的替代方法是至关重要的
 *  </pre>
 */
public class Varargs {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intArray()));
        System.out.println(Arrays.toString(intArray(1)));
        System.out.println(Arrays.toString(intArray(1, 2)));
        System.out.println(Arrays.toString(intArray(1, 2, 3)));
        System.out.println(Arrays.toString(intArray(1, 2, 3, 4)));
        System.out.println(Arrays.toString(intArray(1, 2, 3, 4, 5)));
    }

    public static int[] intArray() {
        return new int[]{};
    }

    public static int[] intArray(int a1) {
        System.out.println("intArray1");
        return new int[]{a1};
    }

    public static int[] intArray(int a1, int a2) {
        System.out.println("intArray2");
        return new int[]{a1, a2};
    }

    public static int[] intArray(int a1, int a2, int a3) {
        System.out.println("intArray3");
        return new int[]{a1,a2,a3};
    }

    public static int[] intArray(int a1, int... rest) {
        System.out.println("intArray varargs");
        int[] res = new int[1 + rest.length];
        res[0] = a1;
        for (int i = 1; i < res.length; i++) {
            res[i] = rest[i-1];
        }
        return res;
    }
}
