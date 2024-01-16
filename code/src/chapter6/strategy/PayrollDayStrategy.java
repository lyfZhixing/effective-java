package chapter6.strategy;

/**
 * <p>
 * <b>需求：</b>
 * 考虑一个表示一周当中计算工资发放的枚举。
 * 枚举有一个方法，该方法根据工人的基本工资（每分钟）和当天的工作分钟数计算工人当天的工资。
 * 在五个工作日内，任何超过正常轮班时间的工作都会产生加班费；在两个周末，所有的工作都会产生加班费
 * </p>
 * <b>设计：</b>使用策略枚举模式 <br>
 * <b>Lambda方式实现策略</b> {@link PayrollDayStrategyLambda} <br>
 * <b>对比switch-case</b>  {@link PayrollDay} <br>
 */
public enum PayrollDayStrategy {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY(Strategy.WEEKEND),
    SUNDAY(Strategy.WEEKEND);

    private static final int MINS_PER_SHIFT = 8 * 60;
    private final Strategy strategy;
    PayrollDayStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    PayrollDayStrategy() {
        this(Strategy.WEEKDAY);
    }
    int pay(int minutesWorked, int payRate) {
        return strategy.pay(minutesWorked, payRate);
    }
    private enum Strategy {
        WEEKDAY{public int pay(int minutesWorked, int payRate){
            int basePay =  minutesWorked <= MINS_PER_SHIFT ? minutesWorked * payRate : MINS_PER_SHIFT * payRate;
            int overtimePay = minutesWorked <= MINS_PER_SHIFT ?0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
            return basePay + overtimePay;
        }},
        WEEKEND{public int pay(int minutesWorked, int payRate){
            return minutesWorked * payRate / 2;
        }},
        ;
        public abstract int pay(int minutesWorked, int payRate);
    }
}
