package chapter3.nested;

public class StaticInnerMain {

    public static void main(String[] args) {
        StaticInner user = new StaticInner("LyF", 20);
        System.out.println(StaticInner.Operation.UPPER_CASE.getOperation().apply(user));
        System.out.println(StaticInner.Operation.LOWER_CASE.getOperation().apply(user));
    }
}
