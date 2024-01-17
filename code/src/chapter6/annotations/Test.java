package chapter6.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模拟junit <br>
 * <pre>
 * JUnit 4 之前，JUnit 测试框架要求其用户通过以字符 test [Beck04] 开头的名称来指定测试方法,也就是命名模式
 *      这样代码过于脆弱，方法名拼写错误，既不会报错，junit也不会去执行测试
 * JUnit 从版本 4 开始就采用注解的方式进行测试方法标记
 * </pre>
 * {@link TestMain}
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
