package chapter4.heterogeneous;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class AnnotationMain {

    public static void main(String[] args) throws NoSuchMethodException {
        Method hello = AnnotationMethod.class.getMethod("hello");
        Annotation annotation = getAnnotation(hello, "chapter4.heterogeneous.DemoAnnotation");
        System.out.println(annotation);

        Method world = AnnotationMethod.class.getMethod("world");
        Annotation annotation2 = getAnnotation(world, "chapter4.heterogeneous.DemoAnnotation");
        System.out.println(annotation2);
    }

    /**
     * 使用 asSubclass 方法读取在编译时类型未知的注释
     * @param element
     * @param annotationTypeName
     * @return
     */
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null; // Unbounded type token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));      // <T extends Annotation> T getAnnotation(Class<T> annotationClass);
    }
}
