package chapter9.strings;

import java.util.Arrays;

/**
 * 字符串拼接
 */
public class ConcatStrings {

    public static void main(String[] args) {

        // 串联拼接 性能最差
        long start1 = System.nanoTime();
        System.out.println(statementByPlus());;
        System.out.println(System.nanoTime() - start1); // 12454200 ns

        // StringBuilder拼接
        long start2 = System.nanoTime();
        System.out.println(statementByBuilder());;
        System.out.println(System.nanoTime() - start2); // 136600 ns

        // 数组拼接
        long start3 = System.nanoTime();
        System.out.println(statementByArray());;
        System.out.println(System.nanoTime() - start3); // 160300 ns
    }

    /**
     * 使用 + 拼接 <br>
     * 时间复杂度： 字符串串联运算符重复串联 n 个字符串需要 n 的平方级时间
     * @return 拼接后的字符串
     */
    static String statementByPlus() {
        String result = "";
        for (int i = 0; i < 100; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 使用数组替代拼接
     * @return array toString
     */
    static String statementByArray() {
        String[] result = new String[100];
        for (int i = 0; i < 100; i++) {
            result[i] = String.valueOf(i);
        }
        return Arrays.toString(result);
    }

    /**
     * 使用StringBuilder append 拼接 <br>
     * 时间复杂度： 线性增长
     * @return 拼接后的字符串
     */
    static String statementByBuilder() {
        StringBuilder result = new StringBuilder(100);
        for (int i = 0; i < 100; i++) {
            result.append(i);
        }
        return result.toString();
    }
}
