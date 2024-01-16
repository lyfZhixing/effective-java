package chapter5.heterogeneous;

public class AnnotationMethod {

    @DemoAnnotation
    public void hello() {
        System.out.println("hello");
    }

    @DemoAnnotation(enable = false)
    public void world() {
        System.out.println("world");
    }
}
