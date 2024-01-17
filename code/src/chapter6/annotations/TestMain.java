package chapter6.annotations;

import java.lang.reflect.Method;
import java.util.Objects;

public class TestMain {

    public static void main(String[] args) throws ReflectiveOperationException {
        int tests = 0;
        int passed = 0;
        Class<?> aClass = Class.forName("chapter6.annotations.Sample"); // 可修改为从main函数传参
        Object o = aClass.getDeclaredConstructor().newInstance();
        for (Method method : aClass.getMethods()) {
            Test annotation = method.getAnnotation(Test.class);
            if(Objects.nonNull(annotation)) {
                try {
                    method.invoke(o);
                    System.out.printf("%s通过测试\n", method.getName());
                    passed++;
                } catch (Exception e) {
                    System.err.printf("%s测试异常: %s", method.getName(), e.getCause().getMessage());
                }
                tests++;

            }
        }
        System.out.printf("对%s个方法进行测试，%s个方法测试通过\n", tests, passed);
    }
}
