package chapter9.strings;

/**
 * 字符串（{@link #compoundKey}）是聚合类型（{@link ClassCompoundKey}）的糟糕替代品
 */
public class AggregateType {
    public static void main(String[] args) {

        // 使用静态成员类
        ClassCompoundKey key = ClassCompoundKey.init("AggregateType", 1);
        System.out.printf("className:%s\tid:%s\t\n", key.className, key.id);

        // 使用 compoundKey 字符串拼接聚合
        String compoundKey = compoundKey("AggregateType", 1);
        System.out.printf("className:%s\tid:%s\t\n", compoundKey.split("#"));
    }

    /**
     * 使用字符串表示聚合类型 <br>
     * <pre>
     * 不推荐使用：
     *      1. 使用时需要解析字符串，缓慢、冗长、容易出错
     *      2. 不能提供 equals、toString 或 compareTo 方法，但必须接受 String 提供的行为
     *      3. 如果用于分隔字段的字符出现在其中一个字段中，可能会导致混乱
     * </pre>
     * @param className 类名
     * @param id    id
     * @return  className 和 id 的聚合类型，分隔符为 #
     */
    static String compoundKey(String className, int id) {
        return className + "#" + id;
    }

    private static class ClassCompoundKey {
        private String className;

        private int id;

        private ClassCompoundKey(){}

        static ClassCompoundKey init(String className, int id) {
            ClassCompoundKey represent = new ClassCompoundKey();
            represent.className = className;
            represent.id = id;
            return represent;
        }

        @Override
        public String toString() {
            return className + "#" + id;
        }

    }
}
