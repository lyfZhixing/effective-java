package chapter6.strategy;

public class PayRollDayMain {

    public static void main(String[] args) {
        System.out.printf("周一挣了%s元\n", PayrollDay.MONDAY.pay(9 * 60, 10));

        System.out.printf("周一挣了%s元\n", PayrollDayStrategy.MONDAY.pay(9*60, 10));

        System.out.printf("周一挣了%s元\n", PayrollDayStrategyLambda.MONDAY.pay(9*60, 10));

        System.out.println("-----------------------------------------------------------------------------");

        System.out.printf("周六挣了%s元\n", PayrollDay.SATURDAY.pay(9 * 60, 10));

        System.out.printf("周六挣了%s元\n", PayrollDayStrategy.SATURDAY.pay(9*60, 10));

        System.out.printf("周六挣了%s元\n", PayrollDayStrategyLambda.SATURDAY.pay(9*60, 10));

    }
}
