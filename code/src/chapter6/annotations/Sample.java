package chapter6.annotations;

public class Sample {

    @Test
    public static void m1() {}

    public static void m2() {}

    @Test
    @ExceptionTest(RuntimeException.class)
    public static void m3() {
        throw new RuntimeException("m3 exception");
    }

    @ExceptionTest(NullPointerException.class)
    public static void m4() throws Exception {
        throw new Exception("m4 exception");
    }

    @Test
    @ExceptionTest(NullPointerException.class)
    public void m5() {}

    @ExceptionTest(NullPointerException.class)
    public void m6() {
        throw new NullPointerException("m5 io exception");
    }

    @ExceptionTest(RuntimeException.class)
    public void m7() {
        throw new ArithmeticException("m7 ArithmeticException");
    }
}
