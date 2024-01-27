package chapter9.boxing;

/**
 * 自动装箱拆箱性能测试 <br>
 * 装箱 {@link #sumAutoBoxing()} 测试结果：用时6520ms <br>
 * 基本类型 {@link #sumPrimitive()} 测试结果：用时669ms <br>
 * 性能相差近10倍
 */
public class PerformanceInAutoBoxing {

    public static void main(String[] args) {
        sumAutoBoxing();
        sumPrimitive();
    }

    /**
     * Long 与 long 反复装箱拆箱
     */
    static void sumAutoBoxing() {
        long sns = System.nanoTime();
        long sms = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.printf("自动装箱拆箱--运行时间: %sns\n", System.nanoTime() - sns); // 6511615800ns
        System.out.printf("          --运行时间: %sms\n", System.currentTimeMillis() - sms);    // 6520ms
    }

    /**
     * 只使用基本类型
     */
    static void sumPrimitive() {
        long sns = System.nanoTime();
        long sms = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.printf("基本类型--运行时间: %sns\n", System.nanoTime() - sns);   // 669057700ns
        System.out.printf("          --运行时间: %sms\n", System.currentTimeMillis() - sms); // 669ms
    }
}
