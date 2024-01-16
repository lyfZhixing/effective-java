package chapter4.nested;

public class StaticMemberMain {

    public static void main(String[] args) {
        StaticMember user = new StaticMember("LyF", 20);
        System.out.println(StaticMember.Operation.UPPER_CASE.getOperation().apply(user));
        System.out.println(StaticMember.Operation.LOWER_CASE.getOperation().apply(user));
    }
}
