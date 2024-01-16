package chapter6.strategy;

import java.util.function.BiFunction;

/**
 * <p>
 * <b>需求：</b>
 * 考虑一个表示一周当中计算工资发放的枚举。
 * 枚举有一个方法，该方法根据工人的基本工资（每分钟）和当天的工作分钟数计算工人当天的工资。
 * 在五个工作日内，任何超过正常轮班时间的工作都会产生加班费；在两个周末，所有的工作都会产生加班费
 * </p>
 * <b>设计：</b>使用策略枚举模式 <br>
 * <b>枚举常量方法实现实现策略</b> {@link PayrollDayStrategy} <br>
 * <b>对比switch-case</b>  {@link PayrollDay} <br>
 */
public enum PayrollDayStrategyLambda {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY(LambdaStrategy.WEEKEND),
    SUNDAY(LambdaStrategy.WEEKEND);

    private static final int MINS_PER_SHIFT = 8 * 60;
    private final LambdaStrategy strategy;
    PayrollDayStrategyLambda(LambdaStrategy strategy) {
        this.strategy = strategy;
    }
    PayrollDayStrategyLambda() {
        this(LambdaStrategy.WEEKDAY);
    }

    int pay(int minutesWorked, int payRate) {
        return strategy.getStrategy().apply(minutesWorked, payRate);
    }

    private enum LambdaStrategy {
        WEEKDAY((minutesWorked, payRate) -> (minutesWorked <= MINS_PER_SHIFT ? minutesWorked * payRate : MINS_PER_SHIFT * payRate) + (minutesWorked <= MINS_PER_SHIFT ?0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2)),
        WEEKEND((minutesWorked, payRate) -> minutesWorked * payRate / 2),
        ;
        private final BiFunction<Integer, Integer, Integer> strategy;

        LambdaStrategy(BiFunction<Integer, Integer, Integer> strategy) {
            this.strategy = strategy;
        }

        public BiFunction<Integer, Integer, Integer> getStrategy() {
            return strategy;
        }
    }
}
