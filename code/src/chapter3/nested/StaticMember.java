package chapter3.nested;

import java.util.function.Function;

/**
 * <pre>
 * 嵌套静态成员类  (静态成员类不属于内部类)
 * 如果声明的成员类不需要访问外部的实例，那么应始终在声明中添加 static 修饰符，使其成为静态的而不是非静态的成员类
 * eg: 本例中的Operation并没有访问StaticInner中的其他实例属性name, age 等
 * 常见用法：
 * 1. 使用静态成员类实现辅助工具类 {@link StaticMember.Operation}
 * 2. 静态成员类实现Build模式构建对象 {@link chapter1.create.builder.NutritionFacts.Builder}
 * 3. 静态成员类实现单例模式
 * </pre>
 */
public class StaticMember {

    private String name;

    private int age;

    public StaticMember(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "StaticInner{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    /**
     * 使用静态成员类实现辅助工具类
     */
    public enum Operation {
        UPPER_CASE(user -> user.getName().toUpperCase()),
        LOWER_CASE(user -> user.getName().toLowerCase())
        ;
        private final Function<StaticMember, String> operation;

        public Function<StaticMember, String> getOperation() {
            return operation;
        }

        Operation(Function<StaticMember, String> operation) {
            this.operation = operation;
        }
    }


}
