package chapter6.annotations;

import java.lang.reflect.Method;
import java.util.Objects;

public class ExceptionTestMain {

    public static void main(String[] args) throws ReflectiveOperationException {
        int tests = 0;
        int passed = 0;
        Class<?> aClass = Class.forName("chapter6.annotations.Sample");
        Object o = aClass.getDeclaredConstructor().newInstance();
        for (Method method : aClass.getMethods()) {
            ExceptionTest annotation = method.getAnnotation(ExceptionTest.class);
            if(Objects.nonNull(annotation)) {
                Class<? extends Throwable> value = annotation.value();
                try {
                    method.invoke(o);
                } catch (Exception e) {
                    if (e.getCause().getClass().equals(value) ) {
                        System.out.printf("%s通过测试, 预期抛出%s，实际抛出%s\n", method.getName(), value, e.getCause().getClass());
                        passed++;
                    } else {
                        System.err.printf("%s测试异常, 预期抛出%s，实际抛出%s\n", method.getName(), value, e.getCause().getClass());
                    }
                }
                tests++;

            }
        }
        System.out.printf("对%s个方法进行测试，%s个方法测试通过\n", tests, passed);
    }
}
